package com.sumod.screen;

import com.sumod.GemType;
import com.sumod.networking.GemSelectionS2CPacket;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ListWidget;
import net.minecraft.util.registry.Registry;

import java.util.List;

public class GemSelectionScreen extends Screen {
    private final List<GemType> availableGems;

    public GemSelectionScreen() {
        super(Text.literal("Select Your Gem"));
        this.availableGems = List.of(GemType.values());  // Assume GemType is an enum
    }

    @Override
    protected void init() {
        super.init();

        // Button to apply the gem
        this.addDrawableChild(new ButtonWidget(
                this.width / 2 - 100, this.height - 40, 200, 20,
                Text.literal("Select Gem"),
                button -> onGemSelected()
        ));

        // Button to cancel (close screen)
        this.addDrawableChild(new ButtonWidget(
                this.width / 2 - 100, this.height - 70, 200, 20,
                Text.literal("Cancel"),
                button -> this.client.setScreen(null)  // Close screen
        ));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);

        TextRenderer textRenderer = this.client.textRenderer;
        String title = "Select Your Gem";
        textRenderer.draw(matrices, title, this.width / 2 - textRenderer.getWidth(title) / 2, 20);
    }

    private void onGemSelected() {
        // Apply the selected gem to the player
        GemType selectedGem = GemType.SAPPHIRE; // Example, could be dynamic
        // Send packet to server for updating the player's gem
        GemSelectionS2CPacket.sendGemSelection(selectedGem);
        this.client.setScreen(null);  // Close the screen
    }
}
