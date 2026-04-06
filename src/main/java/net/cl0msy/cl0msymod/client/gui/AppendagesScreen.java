package net.cl0msy.cl0msymod.client.gui;

import net.cl0msy.cl0msymod.ModSettings;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.client.gui.widget.ExtendedSlider;

public class AppendagesScreen extends Screen {
    public AppendagesScreen() {
        super(Component.literal("Appendage Settings"));
    }

    @Override
    protected void init() {
        int x = this.width / 2 - 100;
        int y = this.height / 2 - 80;

        // --- TOGGLE BUTTONS ---
        this.addRenderableWidget(Button.builder(Component.literal("Fingers: " + (ModSettings.showFingers ? "ON" : "OFF")), (btn) -> {
            ModSettings.showFingers = !ModSettings.showFingers;
            btn.setMessage(Component.literal("Fingers: " + (ModSettings.showFingers ? "ON" : "OFF")));
        }).bounds(x, y, 200, 20).build());

        this.addRenderableWidget(Button.builder(Component.literal("Feet: " + (ModSettings.showFeet ? "ON" : "OFF")), (btn) -> {
            ModSettings.showFeet = !ModSettings.showFeet;
            btn.setMessage(Component.literal("Feet: " + (ModSettings.showFeet ? "ON" : "OFF")));
        }).bounds(x, y + 25, 200, 20).build());

        this.addRenderableWidget(Button.builder(Component.literal("Chest: " + (ModSettings.showChest ? "ON" : "OFF")), (btn) -> {
            ModSettings.showChest = !ModSettings.showChest;
            btn.setMessage(Component.literal("Chest: " + (ModSettings.showChest ? "ON" : "OFF")));
        }).bounds(x, y + 50, 200, 20).build());

        // --- FIXED SLIDERS (Using Anonymous Classes) ---
        // Chest Size Slider
        this.addRenderableWidget(new ExtendedSlider(x, y + 80, 200, 20,
                Component.literal("Chest Volume: "), Component.empty(),
                0.5D, 2.0D, (double)ModSettings.chestSize, 0.05D, 1, true) { // 0.05 step for precision
            @Override
            protected void applyValue() {
                ModSettings.chestSize = (float)this.getValue();
            }
        });

        // Finger Size Slider
        this.addRenderableWidget(new ExtendedSlider(x, y + 105, 200, 20,
                Component.literal("Finger Size: "), Component.empty(),
                0.5D, 3.0D, (double)ModSettings.fingerSize, 0.1D, 1, true) {
            @Override
            protected void applyValue() {
                ModSettings.fingerSize = (float)this.getValue();
            }
        });

        // Done Button
        this.addRenderableWidget(Button.builder(Component.literal("Done"), (btn) -> this.onClose())
                .bounds(x, y + 140, 200, 20).build());
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics, mouseX, mouseY, partialTick);
        super.render(graphics, mouseX, mouseY, partialTick);
        graphics.drawCenteredString(this.font, this.title, this.width / 2, this.height / 2 - 110, 0xFFFFFF);
    }
}