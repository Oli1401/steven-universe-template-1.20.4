package com.sumod;

import net.minecraft.text.Text;
import net.minecraft.text.TextColor;

public class GemNameManager {

    // Method to get a gem's display name formatted with color
    public Text getGemName(GemType gemType) {
        // Use Text.literal() to create the gem's name, and append the color
        return Text.literal(gemType.getDisplayName()).styled(style -> style.withColor(gemType.getColor()));
    }

    // Example of how to display a gem name
    public void displayGemName(GemType gemType) {
        Text gemNameText = getGemName(gemType); // Get formatted gem name
        // Now you can use gemNameText to display the gem's name somewhere
    }
}
