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
    public static final Item DESTABILIZER = createWeaponItem("destabilizer");
    public static final Item PRISMATIC_REFORGER = createUtilityItem();

    // Store registered gem and weapon items
    public static final Map<GemType, Item> GEM_ITEMS = new HashMap<>();
    public static final Map<String, Item> WEAPON_ITEMS = new HashMap<>();

    public static void registerItems() {
        // Register all gem items dynamically based on the GemType enum
        for (GemType gemType : GemType.values()) {
            if (gemType != GemType.NONE) { // Skip NONE
                registerGemItem(gemType);
            }
        }

        // Register specific weapon items
        registerWeaponItem("destabilizer", DESTABILIZER);

        // Register utility items (like the Prismatic Reforger)
        registerUtilityItem("prismatic_reforger", PRISMATIC_REFORGER);
    }

    private static void registerGemItem(GemType gemType) {
        Item gemItem = new GemItem(new Item.Settings(), gemType.getDisplayName(), gemType.getColor());
        GEM_ITEMS.put(gemType, gemItem); // Store gem in the GEM_ITEMS map
        String id = gemType.name().toLowerCase().replace("_", ""); // Generate ID dynamically
        Registry.register(Registries.ITEM, new Identifier(StevenUniverse.MOD_ID, id), gemItem);
    }

    private static void registerWeaponItem(String id, Item item) {
        WEAPON_ITEMS.put(id, item); // Add weapon to the map
        Registry.register(Registries.ITEM, new Identifier(StevenUniverse.MOD_ID, id), item);
    }

    private static void registerUtilityItem(String id, Item item) {
        Registry.register(Registries.ITEM, new Identifier(StevenUniverse.MOD_ID, id), item);
    }

    private static Item createWeaponItem(String weaponId) {
        return new DestabilizerItem(new Item.Settings()); // Destabilizer weapon
    }

    private static Item createUtilityItem() {
        return new PrismaticReforgerItem(new Item.Settings().maxCount(1)); // Prismatic Reforger
    }
}