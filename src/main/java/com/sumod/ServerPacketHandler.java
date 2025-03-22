package com.sumod.network;

import com.sumod.GemComponents;
import net.minecraft.util.Identifier;
import net.minecraft.server.network.ServerPlayerEntity;
import com.sumod.GemType;
import com.sumod.StevenUniverse;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;

public class ServerPacketHandler {

    public static void register() {
        // Register networking-related logic here

        // Triggered when a player joins
        ServerPlayNetworking.registerGlobalReceiver(
                new Identifier(StevenUniverse.MOD_ID, "player_joined"),
                (server, player, handler, buf, responseSender) -> server.execute(() -> {
                    // Check if player already has a gem, if not, assign or prompt selection
                    if (GemComponents.getGemType(player) == GemType.NONE) {
                        // Send a packet to the client to open the gem selection menu
                        ServerPlayNetworking.send(player, new Identifier(StevenUniverse.MOD_ID, "open_gem_selection"), buf);
                    }
                })
        );
    }
}