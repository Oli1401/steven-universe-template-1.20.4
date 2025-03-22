package com.sumod;

import com.sumod.registry.ItemRegistry;
import com.sumod.registry.TabRegistry;
import com.sumod.network.ServerPacketHandler;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StevenUniverse implements ModInitializer {
	public static final String MOD_ID = "steven-universe";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Starting Steven Universe mod...");

		// Initialize registries
		ItemRegistry.registerItems();
		TabRegistry.registerTabs();

		// Register packet handlers for networking
		ServerPacketHandler.register();

		// Handle new players joining the server
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			ServerPlayerEntity player = handler.getPlayer();
			if (GemComponents.getGemType(player) == GemType.NONE) {
				// Notify the client that the gem selection menu should be opened
				ServerPlayNetworking.send(player, new Identifier(StevenUniverse.MOD_ID, "open_gem_selection"), PacketByteBufs.empty());
			}
		});

		LOGGER.info("Steven Universe mod initialized!");
	}
}