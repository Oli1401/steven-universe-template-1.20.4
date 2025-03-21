package com.sumod.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.sumod.GemType;
import com.sumod.StevenUniverse;
import com.sumod.networking.NetworkingConstants;
import com.sumod.networking.SelectGemPacket;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GemSelectionScreen extends Screen {
    private static final Identifier BACKGROUND = new Identifier(StevenUniverse.MOD_ID, "textures/gui/gem_selection.png");
    private static final int BACKGROUND_WIDTH = 256;
    private static final int BACKGROUND_HEIGHT = 192;

    private GemType selectedGem = null;
    private Text gemDescription = Text.empty();

    public GemSelectionScreen() {
        super(Text.literal("Choose Your Gem"));
    }

    @Override
    protected void init() {
        super.init();

        int centerX = this.width / 2;
        int centerY = this.height / 2;
        int startY = centerY - 70;

        // Create a button for each gem type
        int buttonIndex = 0;
        for (GemType gemType : GemType.values()) {
            if (gemType == GemType.NONE) continue;

            int x = (buttonIndex % 2 == 0) ? centerX - 100 : centerX + 10;
            int y = startY + (buttonIndex / 2) * 25;

            ButtonWidget button = ButtonWidget.builder(
                    Text.literal(gemType.getDisplayName()).formatted(gemType.getColor()),
                    btn -> {
                        this.selectedGem = gemType;
                        this.gemDescription = createGemDescription(gemType);
                        this.clearAndInit(); // Refresh buttons to show selected state
                    }
            ).dimensions(x, y, 90, 20).build();

            // Highlight the button if it's the selected gem
            if (gemType == selectedGem) {
                // Use a different button texture for the selected gem
                button.active = false;
            }

            this.addDrawableChild(button);
            buttonIndex++;
        }

        // Add confirm button at the bottom
        ButtonWidget confirmButton = ButtonWidget.builder(
                Text.literal("Confirm Selection"),
                btn -> {
                    if (selectedGem != null) {
                        sendGemSelectionToServer(selectedGem);
                        this.close();
                    }
                }
        ).dimensions(centerX - 75, centerY + 60, 150, 20).build();

        // Only enable the confirm button if a gem is selected
        confirmButton.active = (selectedGem != null);

        this.addDrawableChild(confirmButton);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);

        int centerX = this.width / 2;
        int centerY = this.height / 2;

        // Draw the background texture
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        context.drawTexture(
                BACKGROUND,
                centerX - BACKGROUND_WIDTH / 2,
                centerY - BACKGROUND_HEIGHT / 2,
                0, 0,
                BACKGROUND_WIDTH, BACKGROUND_HEIGHT
        );

        // Draw the title
        context.drawCenteredTextWithShadow(
                this.textRenderer,
                this.title,
                centerX,
                centerY - 85,
                0xFFFFFF
        );

        // Draw the gem description
        if (selectedGem != null) {
            context.drawCenteredTextWithShadow(
                    this.textRenderer,
                    Text.literal("Selected: ").append(
                            Text.literal(selectedGem.getDisplayName()).formatted(selectedGem.getColor())
                    ),
                    centerX,
                    centerY + 20,
                    0xFFFFFF
            );

            // Draw the gem description text
            int descY = centerY + 35;
            for (String line : gemDescription.getString().split("\n")) {
                context.drawCenteredText(
                        this.textRenderer,
                        Text.literal(line),
                        centerX,
                        descY,
                        0xDDDDDD
                );
                descY += 10;
            }
        }

        super.render(context, mouseX, mouseY, delta);
    }

    private Text createGemDescription(GemType gemType) {
        GemType.Abilities abilities = gemType.getAbilities();
        StringBuilder description = new StringBuilder();

        // Add gem lore and basic description
        switch (gemType) {
            case RUBY:
                description.append("Small but fierce soldiers with fire abilities");
                break;
            case SAPPHIRE:
                description.append("Rare aristocratic gems with future vision");
                break;
            case AMETHYST:
                description.append("Fun-loving quartz soldiers with whip abilities");
                break;
            case PEARL:
                description.append("Elegant service gems with precise spear combat");
                break;
            case PERIDOT:
                description.append("Technical gems with metal control powers");
                break;
            case LAPIS:
                description.append("Powerful terraformers with water control");
                break;
            case BISMUTH:
                description.append("Builder gems with weapon forging abilities");
                break;
            case JASPER:
                description.append("Perfect quartz soldier with immense strength");
                break;
            default:
                description.append("Unknown gem type");
        }

        return Text.literal(description.toString());
    }

    private void sendGemSelectionToServer(GemType gemType) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeString(gemType.name());

        ClientPlayNetworking.send(NetworkingConstants.SELECT_GEM_PACKET_ID, buf);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}