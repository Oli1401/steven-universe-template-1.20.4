package com.sumod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.sumod.GemPoofHandler;
import net.minecraft.command.CommandRegistrationCallback;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class ShatterCommand {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            registerShatterCommand(dispatcher);
        });
    }

    private static void registerShatterCommand(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                CommandManager.literal("shatter")
                        .requires(source -> source.hasPermissionLevel(2)) // Require op permission
                        .then(CommandManager.argument("target", EntityArgumentType.player())
                                .executes(ShatterCommand::executeShatter)
                        )
        );
    }

    private static int executeShatter(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity target = EntityArgumentType.getPlayer(context, "target");
        ServerCommandSource source = context.getSource();

        // Shatter the target player
        GemPoofHandler.shatterPlayer(target);

        // Send feedback to the command executor
        source.sendFeedback(() -> Text.literal("Shattered " + target.getName().getString()), true);

        return 1;
    }
}