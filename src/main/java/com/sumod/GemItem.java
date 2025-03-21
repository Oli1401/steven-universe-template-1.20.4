package com.sumod;

import net.minecraft.item.Item;
import net.minecraft.text.Text;

public class GemItem extends Item {
    private final String gemName;

    public GemItem(Item.Settings settings, String gemName) {
        super(settings);
        this.gemName = gemName;  // Store the gem's name
    }

    @Override
    public Text getName() {
        return Text.literal(gemName);  // Display the gem's custom name
    }
}
