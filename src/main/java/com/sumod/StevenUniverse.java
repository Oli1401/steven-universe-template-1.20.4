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
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StevenUniverse implements ModInitializer {
	public static final String MOD_ID = "steven-universe";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// Creative Tabs
	public static final RegistryKey<ItemGroup> GEMS_TAB = RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(MOD_ID, "gems_tab"));
	public static final RegistryKey<ItemGroup> WEAPONS_TAB = RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(MOD_ID, "weapons_tab"));

	// Gem Items with colors defined based on the provided list
	public static final Item SAPPHIRE = new GemItem(new Item.Settings(), "Sapphire Gem", TextColor.fromRgb(0x1D4E89));
	public static final Item RUBY = new GemItem(new Item.Settings(), "Ruby Gem", TextColor.fromRgb(0x9B1B30));
	public static final Item PERIDOT = new GemItem(new Item.Settings(), "Peridot Gem", TextColor.fromRgb(0xB6E13E));
	public static final Item LAPIS_LAZULI = new GemItem(new Item.Settings(), "Lapis Lazuli Gem", TextColor.fromRgb(0x264D9D));
	public static final Item AMETHYST = new GemItem(new Item.Settings(), "Amethyst Gem", TextColor.fromRgb(0x9B59B6));
	public static final Item TOPAZ = new GemItem(new Item.Settings(), "Topaz Gem", TextColor.fromRgb(0xF4C542));
	public static final Item PEARL = new GemItem(new Item.Settings(), "Pearl Gem", TextColor.fromRgb(0xF2F0F0));
	public static final Item ROSE_QUARTZ = new GemItem(new Item.Settings(), "Rose Quartz Gem", TextColor.fromRgb(0xF1A7C2));
	public static final Item BISMUTH = new GemItem(new Item.Settings(), "Bismuth Gem", TextColor.fromRgb(0x5A4D3E));
	public static final Item JASPER = new GemItem(new Item.Settings(), "Jasper Gem", TextColor.fromRgb(0x9F3B3B));
	public static final Item SNOWFLAKE_OBSIDIAN = new GemItem(new Item.Settings(), "Snowflake Obsidian Gem", TextColor.fromRgb(0x50514F));
	public static final Item LARIMAR = new GemItem(new Item.Settings(), "Larimar Gem", TextColor.fromRgb(0x79C5E8));
	public static final Item TIGER_EYE = new GemItem(new Item.Settings(), "Tiger's Eye Gem", TextColor.fromRgb(0xE37B2D));
	public static final Item BERYL = new GemItem(new Item.Settings(), "Beryl Gem", TextColor.fromRgb(0x66A3AD));
	public static final Item SERPENTINE = new GemItem(new Item.Settings(), "Serpentine Gem", TextColor.fromRgb(0x679736));
	public static final Item EMERALD = new GemItem(new Item.Settings(), "Emerald Gem", TextColor.fromRgb(0x2A9D8F));
	public static final Item HESSONITE = new GemItem(new Item.Settings(), "Hessonite Gem", TextColor.fromRgb(0x7C3F26));
	public static final Item DEMANTOID = new GemItem(new Item.Settings(), "Demantoid Gem", TextColor.fromRgb(0x4F9C3D));
	public static final Item PYROPE = new GemItem(new Item.Settings(), "Pyrope Gem", TextColor.fromRgb(0xA03D3D));
	public static final Item AQUAMARINE = new GemItem(new Item.Settings(), "Aquamarine Gem", TextColor.fromRgb(0x7A9E9F));
	public static final Item NEPHRITE = new GemItem(new Item.Settings(), "Nephrite Gem", TextColor.fromRgb(0x7A7C4D));
	public static final Item HOLY_BLUE_AGATE = new GemItem(new Item.Settings(), "Holy Blue Agate Gem", TextColor.fromRgb(0xA8B9C4));
	public static final Item CARNELIAN = new GemItem(new Item.Settings(), "Carnelian Gem", TextColor.fromRgb(0x9E2A2F));
	public static final Item CHERRY_QUARTZ = new GemItem(new Item.Settings(), "Cherry Quartz Gem", TextColor.fromRgb(0xF1C3C6));
	public static final Item FLINT = new GemItem(new Item.Settings(), "Flint Gem", TextColor.fromRgb(0x7A7A7A));
	public static final Item CHERT = new GemItem(new Item.Settings(), "Chert Gem", TextColor.fromRgb(0x5D4F47));
	public static final Item ZIRCON = new GemItem(new Item.Settings(), "Zircon Gem", TextColor.fromRgb(0x5B7F7E));
	public static final Item SPINEL = new GemItem(new Item.Settings(), "Spinel Gem", TextColor.fromRgb(0x7C3D54));
	public static final Item PEBBLE = new GemItem(new Item.Settings(), "Pebble Gem", TextColor.fromRgb(0xB0B0B0));
	public static final Item PADPARADSCHA_SAPPHIRE = new GemItem(new Item.Settings(), "Padparadscha Sapphire Gem", TextColor.fromRgb(0xFF9C84));
	public static final Item RUTILE = new GemItem(new Item.Settings(), "Rutile Gem", TextColor.fromRgb(0xAA4C29));
	public static final Item BIXBITE = new GemItem(new Item.Settings(), "Bixbite Gem", TextColor.fromRgb(0xC90F5B));
	public static final Item ORANGE_SPODUMENE = new GemItem(new Item.Settings(), "Orange Spodumene Gem", TextColor.fromRgb(0xD57F36));
	public static final Item CRAZY_LACE_AGATE = new GemItem(new Item.Settings(), "Crazy Lace Agate Gem", TextColor.fromRgb(0xC24B3E));
	public static final Item WATERMELON_TOURMALINE = new GemItem(new Item.Settings(), "Watermelon Tourmaline Gem", TextColor.fromRgb(0xF56A8A));
	public static final Item MOONSTONE = new GemItem(new Item.Settings(), "Moonstone Gem", TextColor.fromRgb(0xB8C2C5));
	public static final Item BLUE_CHALCEDONY = new GemItem(new Item.Settings(), "Blue Chalcedony Gem", TextColor.fromRgb(0xA1B7D1));
	public static final Item CHRYSOCOLLA = new GemItem(new Item.Settings(), "Chrysocolla Gem", TextColor.fromRgb(0x2A6F61));


	// Destabilizer Item
	public static final Item DESTABILIZER = new DestabilizerItem(new Item.Settings());

	@Override
	public void onInitialize() {
		LOGGER.info("It's Rock Hard Time! (We go hard, we stay hard!!!)");

		// Register Creative Tabs
		Registry.register(Registries.ITEM_GROUP, GEMS_TAB, FabricItemGroup.builder()
				.displayName(Text.literal("Gems"))
				.icon(() -> new ItemStack(SAPPHIRE))  // Set the icon for the tab
				.entries((context, entries) -> {
					// Add all gem items here
					entries.add(SAPPHIRE);
					entries.add(RUBY);
					entries.add(PERIDOT);
					entries.add(LAPIS_LAZULI);
					entries.add(AMETHYST);
					entries.add(TOPAZ);
					entries.add(PEARL);
					entries.add(ROSE_QUARTZ);
					entries.add(BISMUTH);
					entries.add(JASPER);
					entries.add(SNOWFLAKE_OBSIDIAN);
					entries.add(LARIMAR);
					entries.add(TIGER_EYE);
					entries.add(BERYL);
					entries.add(SERPENTINE);
					entries.add(EMERALD);
					entries.add(HESSONITE);
					entries.add(DEMANTOID);
					entries.add(PYROPE);
					entries.add(AQUAMARINE);
					entries.add(NEPHRITE);
					entries.add(HOLY_BLUE_AGATE);
					entries.add(CARNELIAN);
					entries.add(CHERRY_QUARTZ);
					entries.add(FLINT);
					entries.add(CHERT);
					entries.add(ZIRCON);
					entries.add(SPINEL);
					entries.add(PEBBLE);
					entries.add(PADPARADSCHA_SAPPHIRE);
					entries.add(RUTILE);
					entries.add(BIXBITE);
					entries.add(ORANGE_SPODUMENE);
					entries.add(CRAZY_LACE_AGATE);
					entries.add(WATERMELON_TOURMALINE);
					entries.add(MOONSTONE);
					entries.add(BLUE_CHALCEDONY);
					entries.add(CHRYSOCOLLA);
				})
				.build());

		// Register the Weapons Tab
		Registry.register(Registries.ITEM_GROUP, WEAPONS_TAB, FabricItemGroup.builder()
				.displayName(Text.literal("Weapons"))
				.icon(() -> new ItemStack(DESTABILIZER))
				.entries((context, entries) -> {
					entries.add(DESTABILIZER);  // Add weapons to the weapons tab
				})
				.build());

		// Register Items (Gem items)
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sapphire"), SAPPHIRE);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby"), RUBY);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "peridot"), PERIDOT);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "lapis_lazuli"), LAPIS_LAZULI);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "amethyst"), AMETHYST);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "topaz"), TOPAZ);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pearl"), PEARL);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "rose_quartz"), ROSE_QUARTZ);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bismuth"), BISMUTH);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "jasper"), JASPER);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "snowflake_obsidian"), SNOWFLAKE_OBSIDIAN);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "larimar"), LARIMAR);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "tiger_eye"), TIGER_EYE);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "beryl"), BERYL);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "serpentine"), SERPENTINE);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "emerald"), EMERALD);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "hessonite"), HESSONITE);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "demantoid"), DEMANTOID);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pyrope"), PYROPE);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "aquamarine"), AQUAMARINE);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "nephrite"), NEPHRITE);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "holy_blue_agate"), HOLY_BLUE_AGATE);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "carnelian"), CARNELIAN);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cherry_quartz"), CHERRY_QUARTZ);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "flint"), FLINT);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "chert"), CHERT);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "zircon"), ZIRCON);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "spinel"), SPINEL);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pebble"), PEBBLE);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "padparadscha_sapphire"), PADPARADSCHA_SAPPHIRE);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "rutile"), RUTILE);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bixbite"), BIXBITE);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "orange_spodumene"), ORANGE_SPODUMENE);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "crazy_lace_agate"), CRAZY_LACE_AGATE);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "watermelon_tourmaline"), WATERMELON_TOURMALINE);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "moonstone"), MOONSTONE);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blue_chalcedony"), BLUE_CHALCEDONY);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "chrysocolla"), CHRYSOCOLLA);

		// Register Destabilizer Item
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "destabilizer"), DESTABILIZER);
	}
}
