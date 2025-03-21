package com.sumod;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;

public class StevenUniverseClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		// This method will be called only on the client side.
		System.out.println("Initializing client-side Steven Universe Mod!");

		// Example: You can add client-side registration for rendering, GUI screens, etc.
		// For example, registering a custom title screen:
		MinecraftClient.getInstance().getTitleScreen();
		// Or register custom keybindings, etc.
	}
}
