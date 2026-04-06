package net.cl0msy.cl0msymod.item;

import net.cl0msy.cl0msymod.item.ModItems;
import net.cl0msy.cl0msymod.Cl0msyMod;
import net.cl0msy.cl0msymod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Cl0msyMod.MODID);

    public static final Supplier<CreativeModeTab> CUSTOM_ITEMS_TAB = CREATIVE_MODE_TAB.register("cl0msy_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.WOAR.get()))
                    .title(Component.translatable("creativetab.cl0msymod.cl0msy_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.WOAR);
                        output.accept(ModItems.WOAR_RAW);
                    }).build());

    public static final Supplier<CreativeModeTab> CUSTOM_BLOCK_TAB = CREATIVE_MODE_TAB.register("cl0msy_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.WOAR_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Cl0msyMod.MODID, "cl0msy_items_tab"))
                    .title(Component.translatable("creativetab.cl0msymod.modblocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.WOAR_BLOCK);
                        output.accept(ModBlocks.WOAR_ORE);

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}