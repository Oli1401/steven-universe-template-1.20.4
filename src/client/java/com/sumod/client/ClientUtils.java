package com.sumod.client;

import com.sumod.screen.GemSelectionScreen;
import net.minecraft.client.MinecraftClient;

public class ClientUtils {

    public static void openGemSelectionScreen() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null) {
            client.setScreen(new GemSelectionScreen());
        }
    }
}
