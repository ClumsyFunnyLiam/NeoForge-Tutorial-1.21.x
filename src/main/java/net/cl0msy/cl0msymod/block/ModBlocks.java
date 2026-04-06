package net.cl0msy.cl0msymod.block;

import net.cl0msy.cl0msymod.Cl0msyMod;
import net.cl0msy.cl0msymod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Cl0msyMod.MODID);

    // blocks

    public static final DeferredBlock<Block> WOAR_BLOCK = registerBlock("woar_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f, 8f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .instrument(NoteBlockInstrument.COW_BELL)
                    .mapColor(MapColor.GRASS)
                    ));
    public static final DeferredBlock<Block> WOAR_ORE = registerBlock("woar_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,20),
                    BlockBehaviour.Properties.of()
                    .strength(2f, 4f).requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
                    .mapColor(MapColor.STONE)
            ));



    // creates and registers the block, and the block item. so does everything together
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    // registering it
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    // adding it as an item
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


}
