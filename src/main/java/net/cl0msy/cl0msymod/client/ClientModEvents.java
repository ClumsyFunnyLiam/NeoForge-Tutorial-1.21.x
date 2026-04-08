package net.cl0msy.cl0msymod.client;

import net.cl0msy.cl0msymod.client.model.Appendages;
import net.cl0msy.cl0msymod.client.renderer.AppendagesLayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.resources.PlayerSkin;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.minecraft.client.KeyMapping;
import com.mojang.blaze3d.platform.InputConstants;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.lwjgl.glfw.GLFW;

public class ClientModEvents {

    public static final KeyMapping SETTINGS_KEY = new KeyMapping(
            "key.cl0msymod.settings",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_P,
            "key.categories.cl0msymod"
    );

    // This is the method Cl0msyMod.java is looking for
    public static void register(IEventBus modEventBus) {
        modEventBus.addListener(ClientModEvents::registerLayerDefinitions);
        modEventBus.addListener(ClientModEvents::addLayers);
        // ADD THIS: Registers the key with the game
        modEventBus.addListener(ClientModEvents::onRegisterKeyMappings);

        // ADD THIS: Listens for the actual key press on the game bus
        NeoForge.EVENT_BUS.addListener(ClientModEvents::onClientTick);
    }

    public static void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(SETTINGS_KEY);
    }

    // This checks every "tick" if you are pressing the 'O' key
    public static void onClientTick(ClientTickEvent.Post event) {
        while (SETTINGS_KEY.consumeClick()) {
            net.minecraft.client.Minecraft.getInstance().setScreen(new net.cl0msy.cl0msymod.client.gui.AppendagesScreen());
        }
    }

    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(Appendages.LAYER_LOCATION, Appendages::createLayer);
    }

    @SuppressWarnings("unchecked")
    public static void addLayers(EntityRenderersEvent.AddLayers event) {
        // Fix for 1.21.1: Use PlayerSkin.Model Enums instead of Strings
        PlayerRenderer wideRenderer = event.getSkin(PlayerSkin.Model.WIDE);
        if (wideRenderer != null) {
            wideRenderer.addLayer(new AppendagesLayer<>(wideRenderer, event.getEntityModels()));
        }

        PlayerRenderer slimRenderer = event.getSkin(PlayerSkin.Model.SLIM);
        if (slimRenderer != null) {
            slimRenderer.addLayer(new AppendagesLayer<>(slimRenderer, event.getEntityModels()));
        }
    }
}