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
                        output.accept(ModItems.WOAR.get());
                        output.accept(ModItems.WOAR_RAW.get());

                        output.accept(ModItems.WOAR_HAMMER.get());

                        output.accept(ModItems.WOAR_SWORD.get());
                        output.accept(ModItems.WOAR_AXE.get());
                        output.accept(ModItems.WOAR_PICKAXE.get());
                        output.accept(ModItems.WOAR_SHOVEL.get());
                        output.accept(ModItems.WOAR_HOE.get());


                        output.accept(ModItems.WOAR_HELMET.get());
                        output.accept(ModItems.WOAR_CHESTPLATE.get());
                        output.accept(ModItems.WOAR_LEGGINGS.get());
                        output.accept(ModItems.WOAR_BOOTS.get());


                        output.accept(ModItems.PYR.get());
                        output.accept(ModItems.PYR_RAW.get());



                    }).build());

    public static final Supplier<CreativeModeTab> CUSTOM_BLOCK_TAB = CREATIVE_MODE_TAB.register("cl0msy_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.WOAR_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Cl0msyMod.MODID, "cl0msy_items_tab"))
                    .title(Component.translatable("creativetab.cl0msymod.cl0msy_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.WOAR_ORE.get());
                        output.accept(ModBlocks.WOAR_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.WOAR_BLOCK.get());
                        output.accept(ModBlocks.WOAR_STAIRS.get());
                        output.accept(ModBlocks.WOAR_SLAB.get());
                        output.accept(ModBlocks.WOAR_BRICKS.get());
                        output.accept(ModBlocks.WOAR_BRICK_STAIRS.get());
                        output.accept(ModBlocks.WOAR_BRICK_SLAB.get());
                        output.accept(ModBlocks.WOAR_BRICK_PILLAR.get());
                        output.accept(ModBlocks.WOAR_BRICK_TILES.get());
                        output.accept(ModBlocks.POLISHED_WOAR_BRICKS.get());



                        output.accept(ModBlocks.WOAR_DOOR.get());
                        output.accept(ModBlocks.WOAR_TRAPDOOR.get());
                        output.accept(ModBlocks.WOAR_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.WOAR_LAMP.get());
                        output.accept(ModBlocks.WOAR_BUTTON.get());
                        output.accept(ModBlocks.WOAR_WALL.get());
                        output.accept(ModBlocks.WOAR_FENCE.get());
                        output.accept(ModBlocks.WOAR_FENCE_GATE.get());

                        output.accept(ModBlocks.PYR_ORE.get());
                        output.accept(ModBlocks.PYR_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.PYR_BLOCK.get());
                        output.accept(ModBlocks.PYR_BRICKS.get());
                        output.accept(ModBlocks.PYR_BRICK_PILLAR.get());
                        output.accept(ModBlocks.PYR_BRICK_TILES.get());
                        output.accept(ModBlocks.POLISHED_PYR_BRICKS.get());


                        output.accept(ModBlocks.WOAR_SLATE.get());
                        output.accept(ModBlocks.SLATE.get());
                        output.accept(ModBlocks.SCORIA.get());





                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}