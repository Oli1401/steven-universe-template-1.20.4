package com.sumod;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class GemPoofHandler {
    // Map to track poofed players and their gem positions
    private static final Map<UUID, Vec3d> poofedPlayers = new HashMap<>();

    // Map to track when players were poofed (to track regeneration time)
    private static final Map<UUID, Long> poofTimestamps = new HashMap<>();

    // Random instance for generating random poof timer
    private static final Random random = new Random();

    // Minimum and maximum poof timer in milliseconds
    private static final long MIN_POOF_TIME = 30 * 1000; // 30 seconds
    private static final long MAX_POOF_TIME = 60 * 1000; // 1 minute

    // Check if a player would die, and poof them instead
    public static boolean handlePlayerDamage(PlayerEntity player, DamageSource source, float amount) {
        // Get the player's gem type
        GemComponents.GemType gemType = GemComponents.getPlayerGem(player).getGemType();

        // If player has no gem or is already poofed, let vanilla handle it
        if (gemType == GemComponents.GemType.NONE || isPlayerPoofed(player.getUuid())) {
            return false;
        }

        // If player would die from this damage
        if (player.getHealth() - amount <= 0) {
            // Cancel the damage
            player.setHealth(1.0f);

            // Poof the player
            poofPlayer((ServerPlayerEntity) player);

            // Return true to indicate we handled the damage
            return true;
        }

        // Let vanilla handle normal damage
        return false;
    }

    // Poof a player
    public static void poofPlayer(ServerPlayerEntity player) {
        UUID playerId = player.getUuid();
        ServerWorld world = player.getServerWorld();

        // Store the player's position
        poofedPlayers.put(playerId, player.getPos());

        // Generate a random time for the poof (between 30 seconds and 1 minute)
        long poofTime = MIN_POOF_TIME + random.nextInt((int) (MAX_POOF_TIME - MIN_POOF_TIME));
        poofTimestamps.put(playerId, System.currentTimeMillis() + poofTime);

        // Play poof effects
        world.spawnParticles(
                ParticleTypes.CLOUD,
                player.getX(), player.getY() + 1.0, player.getZ(),
                30, 0.5, 0.5, 0.5, 0.1
        );

        // Play poof sound
        world.playSound(
                null,
                player.getX(), player.getY(), player.getZ(),
                SoundEvents.ENTITY_PLAYER_ATTACK_CRIT,
                SoundCategory.PLAYERS,
                1.0f, 1.0f
        );

        // Put player in spectator mode
        player.changeGameMode(net.minecraft.world.GameMode.SPECTATOR);

        // Send message
        player.sendMessage(Text.literal("You have been poofed! You'll reform soon..."), true);

        // Broadcast poof message
        world.getServer().getPlayerManager().broadcast(
                Text.literal(player.getName().getString() + " has been poofed!"),
                false
        );
    }

    // Shatter a player (permanent death)
    public static void shatterPlayer(ServerPlayerEntity player) {
        UUID playerId = player.getUuid();
        ServerWorld world = player.getServerWorld();

        // Get the gem position or player position
        Vec3d pos = poofedPlayers.getOrDefault(playerId, player.getPos());

        // Play glass breaking sound
        world.playSound(
                null,
                pos.getX(), pos.getY(), pos.getZ(),
                SoundEvents.BLOCK_GLASS_BREAK,
                SoundCategory.PLAYERS,
                1.0f, 0.8f
        );

        // Play glass particle effects
        ItemStack gemItem = GemComponents.getGemItem(player);  // Ensure gemItem is obtained correctly
        ItemStackParticleEffect particleEffect = new ItemStackParticleEffect(ParticleTypes.ITEM, gemItem);

        // Spawn the particle effects
        world.spawnParticles(particleEffect, pos.getX(), pos.getY() + 0.5, pos.getZ(), 50, 0.5, 0.5, 0.5, 0.1);

        // Actually kill the player
        player.setHealth(0);

        // Clear poofed status
        poofedPlayers.remove(playerId);
        poofTimestamps.remove(playerId);

        // Broadcast shatter message
        world.getServer().getPlayerManager().broadcast(
                Text.literal(player.getName().getString() + " has been shattered!"),
                false
        );
    }

    // Reform a poofed player
    public static void reformPlayer(ServerPlayerEntity player) {
        UUID playerId = player.getUuid();

        if (!isPlayerPoofed(playerId)) {
            return;
        }

        // Get the gem item for particle effects
        ItemStack gemItem = GemComponents.getGemItem(player);

        // Create a particle effect with the gem item
        ItemStackParticleEffect particleEffect = new ItemStackParticleEffect(ParticleTypes.ITEM, gemItem);
        ServerWorld world = player.getServerWorld();

        // Spawn particles with the gem item effect
        world.spawnParticles(particleEffect, player.getX(), player.getY() + 1.0, player.getZ(), 30, 0.5, 0.5, 0.5, 0.1);

        // Additional code for the reforming process...
        Vec3d pos = poofedPlayers.get(playerId);
        player.teleport(pos.getX(), pos.getY(), pos.getZ());

        // Return to survival mode
        player.changeGameMode(net.minecraft.world.GameMode.SURVIVAL);

        // Heal the player
        player.setHealth(player.getMaxHealth());

        // Clear hunger
        player.getHungerManager().setFoodLevel(20);
        player.getHungerManager().setSaturationLevel(20.0f);

        // Remove from poofed players
        poofedPlayers.remove(playerId);
        poofTimestamps.remove(playerId);

        // Send message
        player.sendMessage(Text.literal("You have reformed!"), true);
    }

    // Check if it's time for a player to reform
    public static void checkReforms(ServerPlayerEntity player) {
        UUID playerId = player.getUuid();

        if (!isPlayerPoofed(playerId)) {
            return;
        }

        long poofTime = poofTimestamps.get(playerId);
        long currentTime = System.currentTimeMillis();

        // If enough time has passed
        if (currentTime >= poofTime) {
            reformPlayer(player);
        }
    }

    // Check if a player is currently poofed
    public static boolean isPlayerPoofed(UUID playerId) {
        return poofedPlayers.containsKey(playerId);
    }
}
