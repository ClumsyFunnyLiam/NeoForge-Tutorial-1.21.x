package net.cl0msy.cl0msymod.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.cl0msy.cl0msymod.Cl0msyMod;
import net.cl0msy.cl0msymod.ModSettings;
import net.cl0msy.cl0msymod.client.renderer.AppendagesLayer;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderHandEvent;

@EventBusSubscriber(modid = Cl0msyMod.MODID, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onRenderHand(RenderHandEvent event) {
        // This is a complex topic—by default, the hand is a single ModelPart.
        // To make fingers show up, you'd usually have to render the Appendages model
        // inside this event and translate it to match the hand's current position.
        if (ModSettings.showFingers) {
            // For now, focus on getting the Third-Person (F5) and Sliders working.
            // First-person finger sync usually requires a 'First Person Model' mod
            // or very specific PoseStack translations.
        }
    }
}