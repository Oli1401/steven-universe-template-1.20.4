package com.sumod;

import net.minecraft.text.Text;
import net.minecraft.text.TextColor;

public enum GemType {
    NONE("None", TextColor.fromRgb(0x000000)),  // NONE GemType with no color (black or a default color)
    SAPPHIRE("Sapphire", TextColor.fromRgb(0x1D4E89)),
    RUBY("Ruby", TextColor.fromRgb(0x9B1B30)),
    PERIDOT("Peridot", TextColor.fromRgb(0xB6E13E)),
    LAPIS_LAZULI("Lapis Lazuli", TextColor.fromRgb(0x264D9D)),
    AMETHYST("Amethyst", TextColor.fromRgb(0x9B59B6)),
    TOPAZ("Topaz", TextColor.fromRgb(0xF4C542)),
    PEARL("Pearl", TextColor.fromRgb(0xF2F0F0)),
    ROSE_QUARTZ("Rose Quartz", TextColor.fromRgb(0xF1A7C2)),
    BISMUTH("Bismuth", TextColor.fromRgb(0x5A4D3E)),
    JASPER("Jasper", TextColor.fromRgb(0x9F3B3B)),
    SNOWFLAKE_OBSIDIAN("Snowflake Obsidian", TextColor.fromRgb(0x50514F)),
    LARIMAR("Larimar", TextColor.fromRgb(0x79C5E8)),
    TIGER_EYE("Tiger's Eye", TextColor.fromRgb(0xE37B2D)),
    BERYL("Beryl", TextColor.fromRgb(0x66A3AD)),
    SERPENTINE("Serpentine", TextColor.fromRgb(0x679736)),
    EMERALD("Emerald", TextColor.fromRgb(0x2A9D8F)),
    HESSONITE("Hessonite", TextColor.fromRgb(0x7C3F26)),
    DEMANTOID("Demantoid", TextColor.fromRgb(0x4F9C3D)),
    PYROPE("Pyrope", TextColor.fromRgb(0xA03D3D)),
    AQUAMARINE("Aquamarine", TextColor.fromRgb(0x7A9E9F)),
    NEPHRITE("Nephrite", TextColor.fromRgb(0x7A7C4D)),
    HOLY_BLUE_AGATE("Holy Blue Agate", TextColor.fromRgb(0xA8B9C4)),
    CARNELIAN("Carnelian", TextColor.fromRgb(0x9E2A2F)),
    CHERRY_QUARTZ("Cherry Quartz", TextColor.fromRgb(0xF1C3C6)),
    FLINT("Flint", TextColor.fromRgb(0x7A7A7A)),
    CHERT("Chert", TextColor.fromRgb(0x5D4F47)),
    ZIRCON("Zircon", TextColor.fromRgb(0x5B7F7E)),
    SPINEL("Spinel", TextColor.fromRgb(0x7C3D54)),
    PEBBLE("Pebble", TextColor.fromRgb(0xB0B0B0)),
    PADPARADSCHA_SAPPHIRE("Padparadscha Sapphire", TextColor.fromRgb(0xFF9C84)),
    RUTILE("Rutile", TextColor.fromRgb(0xAA4C29)),
    BIXBITE("Bixbite", TextColor.fromRgb(0xC90F5B)),
    ORANGE_SPODUMENE("Orange Spodumene", TextColor.fromRgb(0xD57F36)),
    CRAZY_LACE_AGATE("Crazy Lace Agate", TextColor.fromRgb(0xC24B3E)),
    WATERMELON_TOURMALINE("Watermelon Tourmaline", TextColor.fromRgb(0xF56A8A)),
    MOONSTONE("Moonstone", TextColor.fromRgb(0xB8C2C5)),
    BLUE_CHALCEDONY("Blue Chalcedony", TextColor.fromRgb(0xA1B7D1)),
    CHRYSOCOLLA("Chrysocolla", TextColor.fromRgb(0x2A6F61));

    private final String displayName;
    private final TextColor color;

    GemType(String displayName, TextColor color) {
        this.displayName = displayName;
        this.color = color;
    }

    public String getDisplayName() {
        return displayName;
    }

    public TextColor getColor() {
        return color;
    }
}
