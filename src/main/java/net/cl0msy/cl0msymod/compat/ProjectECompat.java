package net.cl0msy.cl0msymod.compat;

import moze_intel.projecte.config.CustomEMCParser;
import moze_intel.projecte.api.ProjectEAPI;
import moze_intel.projecte.api.nss.NSSItem;
import moze_intel.projecte.api.nss.NormalizedSimpleStack;
import net.cl0msy.cl0msymod.block.ModBlocks;
import net.cl0msy.cl0msymod.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.fml.InterModComms;
import net.neoforged.neoforgespi.locating.IModFile;

public class ProjectECompat {
    public static IModFile pe;

    public static void registerEMCValues(IModFile modFile) {
        try {
            pe = modFile;

            System.out.println("\ncl0msyInternal: project e exists. sending registries\n");
            sendEMC(ModItems.WOAR.get(), 32L);
            sendEMC(ModItems.WOAR_RAW.get(), 32L);
            sendEMC(ModBlocks.WOAR_DEEPSLATE_ORE.get().asItem(), 32L);
            sendEMC(ModBlocks.WOAR_ORE.get().asItem(), 32L);

            sendEMC(ModItems.PYR.get(), 32L);
            sendEMC(ModItems.PYR_RAW.get(), 32L);
            sendEMC(ModBlocks.PYR_DEEPSLATE_ORE.get().asItem(), 32L);
            sendEMC(ModBlocks.PYR_ORE.get().asItem(), 32L);
            System.out.println("\ncl0msyInternal:success, thank fucking god");
        } catch (Exception killMySelf) {
            System.out.println("\ncl0msyInternal: what did you expect. Failed to register EMC: " + killMySelf.getMessage() + "\n");
        }

    }

    private static void sendEMC(ItemLike item, long value) {
        // still have no idea what nss is
        NSSItem nssItem = NSSItem.createItem(item);
        System.out.println("\ncl0msyInternal: Item " + item.toString() +  " created\n");

        // please work bro
        CustomEMCParser.addToFile(nssItem, value);
        System.out.println("\ncl0msyInternal: Item " + item.toString() +  " registered\n");


    }
}