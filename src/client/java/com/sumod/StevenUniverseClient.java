package com.sumod;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class StevenUniverseClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		// This method will be called only on the client side.
		System.out.println("Initializing client-side Steven Universe Mod!");

		// Example: You can add client-side registration for rendering, GUI screens, etc.
		// If you want to register custom screens, keybindings, or anything client-specific, do it here.

		// If you're just initializing your mod, there's no need to call the title screen.
		// You might want to add your own custom screens or keybindings here.
	}
}
