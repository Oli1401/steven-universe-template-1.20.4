package com.sumod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import com.sumod.GemType;


public class GemComponents {

    // Store gem information for players
    private static final Map<UUID, Gem> playerGems = new HashMap<>();

    // Store gem items for players
    private static final Map<UUID, ItemStack> playerGemItems = new HashMap<>();

    // Assign a gem to a player
    public static void assignGemToPlayer(PlayerEntity player, Gem gem, ItemStack gemItem) {
        playerGems.put(player.getUuid(), gem);
        playerGemItems.put(player.getUuid(), gemItem);
    }

    // Get a player's gem type
    public static GemType getGemType(PlayerEntity player) {
        Gem gem = playerGems.get(player.getUuid());
        return gem != null ? gem.getGemType() : GemType.NONE;
    }

    // Get a player's gem item
    public static ItemStack getGemItem(PlayerEntity player) {
        return playerGemItems.getOrDefault(player.getUuid(), ItemStack.EMPTY);
    }

    // Get the Gem object for a player
    public static Gem getPlayerGem(PlayerEntity player) {
        return playerGems.getOrDefault(player.getUuid(), new Gem(GemType.NONE));
    }

    // You may need to add more methods to manage player gem data,
    // such as removing gems, checking if a player has a gem, etc.

    // Example of a Gem class with GemType
    public static class Gem {
        private GemType gemType;

        public Gem(GemType gemType) {
            this.gemType = gemType;
        }

        public GemType getGemType() {
            return gemType;
        }

        public void setGemType(GemType gemType) {
            this.gemType = gemType;
        }
    }

    // Enum to represent different types of gems
    public enum GemType {
        NONE,
        SAPPHIRE,
        RUBY,
        AMETHYST,
        // Add more gem types here as needed
    }
}
