package com.sumod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StevenUniverse implements ModInitializer {
	public static final String MOD_ID = "steven-universe";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// Creative Tabs
	public static final RegistryKey<ItemGroup> GEMS_TAB = RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(MOD_ID, "gems_tab"));
	public static final RegistryKey<ItemGroup> WEAPONS_TAB = RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(MOD_ID, "weapons_tab"));

	// Items
	public static final Item SAPPHIRE = new GemItem(new Item.Settings(), "Sapphire Gem");
	public static final Item DESTABILIZER = new DestabilizerItem(new Item.Settings());

	@Override
	public void onInitialize() {
		LOGGER.info("It's Rock Hard Time! (We go hard, we stay hard!!!)");

		// Register Creative Tabs
		Registry.register(Registries.ITEM_GROUP, GEMS_TAB, FabricItemGroup.builder()
				.displayName(Text.literal("Gems"))
				.icon(() -> new ItemStack(SAPPHIRE))  // Set the icon for the tab
				.entries((context, entries) -> {
					entries.add(SAPPHIRE); // Add gem items here. You can add all your gems as needed.
				})
				.build());

		Registry.register(Registries.ITEM_GROUP, WEAPONS_TAB, FabricItemGroup.builder()
				.displayName(Text.literal("Weapons"))
				.icon(() -> new ItemStack(DESTABILIZER))  // Set the icon for the tab
				.entries((context, entries) -> {
					entries.add(DESTABILIZER);  // Add weapons to the weapons tab.
				})
				.build());

		// Register Items
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sapphire"), SAPPHIRE);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "destabilizer"), DESTABILIZER);
	}
}
