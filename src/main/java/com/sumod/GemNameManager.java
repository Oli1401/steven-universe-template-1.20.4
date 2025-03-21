package com.sumod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.scoreboard.ScoreboardPlayerScore;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class GemNameManager {
    private static final Map<UUID, String> playerGemCodes = new HashMap<>();
    private static final Map<UUID, String> playerGemNicknames = new HashMap<>();
    private static final Random random = new Random();

    // Generate a random gem code like [2X7N]
    public static String generateGemCode() {
        StringBuilder code = new StringBuilder();
        code.append("[");

        // Add a random number from 1-9
        code.append(random.nextInt(9) + 1);

        // Add a random letter from A-Z
        code.append((char) (random.nextInt(26) + 'A'));

        // Add a random number from 1-9
        code.append(random.nextInt(9) + 1);

        // Add a random letter from A-Z
        code.append((char) (random.nextInt(26) + 'A'));

        code.append("]");

        return code.toString();
    }

    // Generate a gem nickname based on the player's username and gem type
    public static String generateGemNickname(PlayerEntity player, GemType gemType) {
        String playerName = player.getName().getString();
        String gemName = gemType.getDisplayName();

        // Simple nickname generation: Gem + Player's initial letter(s)
        String nickname;
        if (playerName.length() > 2) {
            nickname = gemName + " " + playerName.substring(0, 2).toUpperCase();
        } else {
            nickname = gemName + " " + playerName.toUpperCase();
        }

        return nickname;
    }

    // Set a player's gem code and nickname
    public static void setPlayerGemIdentity(MinecraftServer server, PlayerEntity player, GemType gemType) {
        UUID playerId = player.getUuid();

        // Generate or retrieve gem code
        String gemCode = playerGemCodes.computeIfAbsent(playerId, k -> generateGemCode());

        // Generate or retrieve gem nickname
        String gemNickname = playerGemNicknames.computeIfAbsent(playerId, k -> generateGemNickname(player, gemType));

        // Create or get team for this gem type
        ServerScoreboard scoreboard = server.getScoreboard();
        String teamName = "gem_" + gemType.name().toLowerCase();
        Team team = scoreboard.getTeam(teamName);

        if (team == null) {
            // Create team if it doesn't exist
            team = scoreboard.addTeam(teamName);
            team.setColor(gemType.getColor());
            team.setPrefix(Text.literal("[" + gemType.getDisplayName() + "] "));
        }

        // Add player to team if not already in it
        if (!scoreboard.getPlayerTeam(player.getName().getString()).equals(team)) {
            scoreboard.addPlayerToTeam(player.getName().getString(), team);
        }

        // Set suffix with gem code
        team.setSuffix(Text.literal(" " + gemCode));

        // Optionally set display name with nickname
        player.setCustomName(Text.literal(gemNickname));
        player.setCustomNameVisible(true);

        // Store in maps for persistence
        playerGemCodes.put(playerId, gemCode);
        playerGemNicknames.put(playerId, gemNickname);
    }

    // Get a player's gem code
    public static String getPlayerGemCode(UUID playerId) {
        return playerGemCodes.getOrDefault(playerId, "");
    }

    // Get a player's gem nickname
    public static String getPlayerGemNickname(UUID playerId) {
        return playerGemNicknames.getOrDefault(playerId, "");
    }
}