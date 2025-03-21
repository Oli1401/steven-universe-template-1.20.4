package com.sumod;

import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;

public class GemItem extends Item {
    private final String gemName;
    private final TextColor gemColor;

    // Constructor that accepts the gem name and color
    public GemItem(Item.Settings settings, String gemName, TextColor gemColor) {
        super(settings);
        this.gemName = gemName;
        this.gemColor = gemColor;
    }

    @Override
    public Text getName() {
        // Return the gem name with the assigned color
        return Text.literal(gemName).styled(style -> style.withColor(gemColor));
    }
}
