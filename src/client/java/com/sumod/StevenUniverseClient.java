package com.sumod;

import com.sumod.screen.GemSelectionScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;

public class StevenUniverseClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Register client-side networking for opening the gem selection menu
		ClientPlayNetworking.registerGlobalReceiver(new Identifier(StevenUniverse.MOD_ID, "open_gem_selection"), (client, handler, buf, responseSender) -> {
			client.execute(() -> {
				// Open the gem selection screen
				MinecraftClient.getInstance().setScreen(new GemSelectionScreen());
			});
		});
	}
}