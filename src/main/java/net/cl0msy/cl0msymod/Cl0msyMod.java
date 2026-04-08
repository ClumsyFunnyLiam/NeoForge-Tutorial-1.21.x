package net.cl0msy.cl0msymod;

import net.cl0msy.cl0msymod.block.ModBlocks;
import net.cl0msy.cl0msymod.client.ClientModEvents;
import net.cl0msy.cl0msymod.compat.ProjectECompat;
import net.cl0msy.cl0msymod.component.ModDataComponents;
import net.cl0msy.cl0msymod.datagen.DataGenerators;
import net.cl0msy.cl0msymod.item.ModCreativeModeTabs;
import net.cl0msy.cl0msymod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(Cl0msyMod.MODID)
public class Cl0msyMod {
    public static final String MODID = "cl0msymod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Cl0msyMod(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ProjectECompat.init(modEventBus);



        ModDataComponents.register(modEventBus);
        ClientModEvents.register(modEventBus);

        modEventBus.addListener(DataGenerators::gatherData);


        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }


    private void commonSetup(FMLCommonSetupEvent event) { }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.WOAR);
            event.accept(ModItems.WOAR_RAW);
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.WOAR_BLOCK);
            event.accept(ModBlocks.WOAR_ORE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

}