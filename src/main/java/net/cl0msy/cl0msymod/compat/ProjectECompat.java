package net.cl0msy.cl0msymod.compat;

import net.cl0msy.cl0msymod.block.ModBlocks;
import net.cl0msy.cl0msymod.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.InterModComms;

import java.util.HashMap;
import java.util.Map;

import net.cl0msy.cl0msymod.Cl0msyMod;
import net.cl0msy.cl0msymod.item.ModItems;

public class ProjectECompat {

    private static final String PROJECTE_MODID = "projecte";

    public static void init(IEventBus modBus) {
        if (!ModList.get().isLoaded(PROJECTE_MODID)) return;

        modBus.addListener(ProjectECompat::onIMCEnqueue);
    }

    private static void onIMCEnqueue(final InterModEnqueueEvent event) {
        // You must send a separate message for every item
        registerEMC(ModItems.WOAR.get(), 32L);
        registerEMC(ModItems.WOAR_RAW.get(), 32L);
        registerEMC(ModBlocks.WOAR_DEEPSLATE_ORE.get().asItem(), 32L);
        registerEMC(ModBlocks.WOAR_ORE.get().asItem(), 32L);

        registerEMC(ModItems.PYR.get(), 32L);
        registerEMC(ModItems.PYR_RAW.get(), 32L);
        registerEMC(ModBlocks.PYR_DEEPSLATE_ORE.get().asItem(), 32L);
        registerEMC(ModBlocks.PYR_ORE.get().asItem(), 32L);
    }

    // Helper method to keep the code clean
    private static void registerEMC(net.minecraft.world.level.ItemLike item, long value) {
        InterModComms.sendTo(PROJECTE_MODID, "register_emc", () -> {
            // ProjectE expects a 'NSSItem' or a formatted message depending on the version
            // If using the ProjectE API dependency:
            // return kozlo.projecte.api.nss.NSSItem.createItem(item);

            // For standard IMC string-based registration in modern versions:
            return new net.minecraft.world.item.ItemStack(item);
        });
    }
}

