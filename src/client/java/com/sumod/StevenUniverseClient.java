package com.sumod;

import com.sumod.screen.GemSelectionScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;

public class StevenUniverseClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		// Run any necessary client-specific initialization here
	}

	public static void openGemSelectionScreen() {
		MinecraftClient client = MinecraftClient.getInstance();
		if (client.player != null) { // Ensure player exists before opening the screen
			client.setScreen(new GemSelectionScreen());
		}
	}
}