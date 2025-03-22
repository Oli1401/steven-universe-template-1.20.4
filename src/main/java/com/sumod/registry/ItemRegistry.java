package com.sumod.registry;

import com.sumod.GemItem;
import com.sumod.GemType;
import com.sumod.StevenUniverse;
import com.sumod.items.DestabilizerItem;
import com.sumod.items.PrismaticReforgerItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class ItemRegistry {
    // Create static instances for items
    public static final Item DESTABILIZER = createWeaponItem("destabilizer");
    public static final Item PRISMATIC_REFORGER = createUtilityItem(); // Register Prismatic Reforger

    // Maps to store dynamically registered items
    public static final Map<GemType, Item> GEM_ITEMS = new HashMap<>();
    public static final Map<String, Item> WEAPON_ITEMS = new HashMap<>();

    /**
     * Register all items: Gems, weapons, and utilities.
     */
    public static void registerItems() {
        // Register all gem items based on the GemType enum
        for (GemType gemType : GemType.values()) {
            if (gemType != GemType.NONE) { // Skip NONE type
                registerGemItem(gemType);
            }
        }

        // Register specific weapon items
        registerWeaponItem("destabilizer", DESTABILIZER);

        // Register utility items, including the new Prismatic Reforger
        registerUtilityItem("prismatic_reforger", PRISMATIC_REFORGER);
    }

    /**
     * Registers gem items dynamically based on GemType.
     *
     * @param gemType The GemType to register.
     */
    private static void registerGemItem(GemType gemType) {
        // Create a GemItem based on the gemType details
        Item gemItem = new GemItem(new Item.Settings(), gemType.getDisplayName(), gemType.getColor());
        GEM_ITEMS.put(gemType, gemItem); // Add the item to the GEM_ITEMS map
        String id = gemType.name().toLowerCase().replace("_", ""); // Generate a unique identifier
        Registry.register(Registries.ITEM, new Identifier(StevenUniverse.MOD_ID, id), gemItem);
    }

    /**
     * Registers a weapon item with a specific ID.
     *
     * @param id The ID of the weapon item.
     * @param item The item instance to register.
     */
    private static void registerWeaponItem(String id, Item item) {
        WEAPON_ITEMS.put(id, item); // Add item to the WEAPON_ITEMS map
        Registry.register(Registries.ITEM, new Identifier(StevenUniverse.MOD_ID, id), item);
    }

    /**
     * Registers a utility item with a specific ID.
     *
     * @param id The ID of the utility item.
     * @param item The item instance to register.
     */
    private static void registerUtilityItem(String id, Item item) {
        Registry.register(Registries.ITEM, new Identifier(StevenUniverse.MOD_ID, id), item);
    }

    /**
     * Create a specific weapon item, such as the Destabilizer.
     *
     * @param weaponId The unique ID for the weapon.
     * @return The weapon item instance.
     */
    private static Item createWeaponItem(String weaponId) {
        return new DestabilizerItem(new Item.Settings()); // Example weapon
    }

    /**
     * Create and return the Prismatic Reforger item.
     *
     * @return The Prismatic Reforger item instance.
     */
    private static Item createUtilityItem() {
        return new PrismaticReforgerItem(new Item.Settings().maxCount(1)); // Prismatic Reforger is not stackable
    }
}