package com.sumod.items;

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
        if (world.isClient()) { // Ensure this code runs only on the client
            handleClientUse();
        }
        return TypedActionResult.success(player.getStackInHand(hand));
    }

    private void handleClientUse() {
        // Delegate the client-specific action to a client-side proxy
        com.sumod.client.ClientUtils.openGemSelectionScreen();
    }
}