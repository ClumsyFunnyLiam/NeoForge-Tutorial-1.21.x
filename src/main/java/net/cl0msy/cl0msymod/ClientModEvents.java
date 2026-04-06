package net.cl0msy.cl0msymod;

import com.mojang.blaze3d.platform.InputConstants;
import net.cl0msy.cl0msymod.client.gui.AppendagesScreen;
import net.cl0msy.cl0msymod.client.model.Appendages;
import net.cl0msy.cl0msymod.client.renderer.AppendagesLayer;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.common.NeoForge;

public class ClientModEvents {
    public static final KeyMapping MENU_KEY = new KeyMapping("key.cl0msymod.menu", InputConstants.Type.KEYSYM, InputConstants.KEY_P, "key.categories.misc");

    public static void register(IEventBus modBus) {
        modBus.addListener(ClientModEvents::registerLayers);
        modBus.addListener(ClientModEvents::addPlayerLayers);
        modBus.addListener(ClientModEvents::registerKeyMapping);

        // This is where the ClientTickEvent lives in 1.21.1
        NeoForge.EVENT_BUS.addListener(ClientModEvents::onClientTick);
    }

    public static void registerKeyMapping(RegisterKeyMappingsEvent event) {
        event.register(MENU_KEY);
    }

    public static void onClientTick(ClientTickEvent.Post event) {
        while (MENU_KEY.consumeClick()) {
            Minecraft.getInstance().setScreen(new AppendagesScreen());
        }
    }

    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(Appendages.LAYER_LOCATION, () -> Appendages.createLayer());
        event.registerLayerDefinition(Appendages.SLIM_LAYER_LOCATION, () -> Appendages.createLayer());
    }

    public static void addPlayerLayers(EntityRenderersEvent.AddLayers event) {
        // Wide (Steve) support
        PlayerRenderer defaultRenderer = event.getSkin(net.minecraft.client.resources.PlayerSkin.Model.WIDE);
        if (defaultRenderer != null) {
            defaultRenderer.addLayer(new AppendagesLayer(defaultRenderer, event.getEntityModels(), false));
        }

        // Slim (Alex) support
        PlayerRenderer slimRenderer = event.getSkin(net.minecraft.client.resources.PlayerSkin.Model.SLIM);
        if (slimRenderer != null) {
            slimRenderer.addLayer(new AppendagesLayer(slimRenderer, event.getEntityModels(), true));
        }
    }
}