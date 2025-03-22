package com.sumod.registry;

import com.sumod.GemType;
import com.sumod.StevenUniverse;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TabRegistry {
    public static ItemGroup GEM_ITEMS_TAB;
    public static ItemGroup WEAPONS_TAB;

    public static void registerTabs() {
        GEM_ITEMS_TAB = Registry.register(
                Registries.ITEM_GROUP,
                new Identifier(StevenUniverse.MOD_ID, "gem_items_tab"),
                FabricItemGroup.builder()
                        .displayName(Text.literal("Gems"))
                        .icon(() -> new ItemStack(ItemRegistry.GEM_ITEMS.get(GemType.SAPPHIRE))) // Example gem icon
                        .entries((context, entries) -> {
                            ItemRegistry.GEM_ITEMS.values()
                                    .forEach(item -> entries.add(new ItemStack(item))); // Add all gems to the tab
                        })
                        .build()
        );

        WEAPONS_TAB = Registry.register(
                Registries.ITEM_GROUP,
                new Identifier(StevenUniverse.MOD_ID, "weapons_tab"),
                FabricItemGroup.builder()
                        .displayName(Text.literal("Weapons"))
                        .icon(() -> new ItemStack(ItemRegistry.DESTABILIZER)) // Example weapon icon
                        .entries((context, entries) -> {
                            ItemRegistry.WEAPON_ITEMS.values()
                                    .forEach(item -> entries.add(new ItemStack(item))); // Add all weapons
                        })
                        .build()
        );
    }
}