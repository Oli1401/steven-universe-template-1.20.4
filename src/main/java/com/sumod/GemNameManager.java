package com.sumod;

import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.chat.style.Style;

public class GemNameManager {

    // Example of gemType list - replace with your actual GemType enum or class
    private static final GemType[] gemTypes = GemType.values();

    public static void assignTeamToPlayer(MinecraftClient client, String playerName, GemType gemType) {
        // Get the scoreboard
        Scoreboard scoreboard = client.getServer().getScoreboard();

        // Create a new team with the player's gem name
        Team team = new Team(scoreboard, playerName); // Team constructor requires a scoreboard and a name

        // Set color using TextColor and convert it to Formatting using toFormatting()
        team.setColor(gemType.getColor().toFormatting()); // Use toFormatting() for color

        // Register the team in the scoreboard
        scoreboard.addTeam(team);

        // Add the player to the team
        scoreboard.addPlayerToTeam(playerName, team.getName()); // Add player to team by team name
    }

    public static void handleGemColorUpdate(GemType gemType) {
        // Example of how to display a message in the chat for a color update
        String message = "Your gem color is now: " + gemType.toString();  // Use toString() instead of getName()
        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayNetworkHandler networkHandler = client.getNetworkHandler();
        if (networkHandler != null) {
            // Sending message to chat
            networkHandler.sendChatMessage(message);
        }
    }

    // Helper method to get a player's gem color based on their gem type
    public static Text getGemNameText(GemType gemType) {
        // Create a Style object using the TextColor, and apply it to the text
        Style style = Style.EMPTY.withColor(gemType.getColor());
        return Text.literal(gemType.toString()).setStyle(style); // Use Style to apply color
    }
}
