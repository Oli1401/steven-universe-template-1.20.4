package com.sumod.items;

import com.sumod.screen.GemSelectionScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PrismaticReforgerItem extends Item {

    public PrismaticReforgerItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (world.isClient) {
            // Open the gem selection screen on the client side
            MinecraftClient.getInstance().setScreen(new GemSelectionScreen());
        }
        return TypedActionResult.success(player.getStackInHand(hand));
    }
}