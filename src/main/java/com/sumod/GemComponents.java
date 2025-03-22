package com.sumod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GemComponents {

    // Store gem information for players
    private static final Map<UUID, Gem> playerGems = new HashMap<>();
    private static final Map<UUID, ItemStack> playerGemItems = new HashMap<>();

    // Assign a gem to a player
    public static void assignGemToPlayer(PlayerEntity player, Gem gem, ItemStack gemItem) {
        playerGems.put(player.getUuid(), gem);
        playerGemItems.put(player.getUuid(), gemItem);
    }

    // Get a player's gem type
    public static com.sumod.GemType getGemType(PlayerEntity player) {
        Gem gem = playerGems.get(player.getUuid());
        return gem != null ? gem.getGemType() : com.sumod.GemType.NONE;
    }

    // Get a player's full Gem object (new code)
    public static Gem getPlayerGem(PlayerEntity player) {
        return playerGems.get(player.getUuid());
    }

    // Get a player's gem item
    public static ItemStack getGemItem(PlayerEntity player) {
        return playerGemItems.getOrDefault(player.getUuid(), ItemStack.EMPTY);
    }

    // Gem class with com.sumod.GemType
    public static class Gem {
        private com.sumod.GemType gemType;

        public Gem(com.sumod.GemType gemType) {
            this.gemType = gemType;
        }

        public com.sumod.GemType getGemType() {
            return gemType;
        }

        public void setGemType(com.sumod.GemType gemType) {
            this.gemType = gemType;
        }
    }
}