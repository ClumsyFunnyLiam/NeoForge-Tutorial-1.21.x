package net.cl0msy.cl0msymod.block;

import net.cl0msy.cl0msymod.Cl0msyMod;
import net.cl0msy.cl0msymod.block.custom.MagicBlock;
import net.cl0msy.cl0msymod.block.custom.WoarLampBlock;
import net.cl0msy.cl0msymod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Cl0msyMod.MODID);

    // blocks

    public static final DeferredBlock<Block> SLATE = registerBlock("slate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)
                    .mapColor(MapColor.COLOR_CYAN)));
    public static final DeferredBlock<Block> WOAR_SLATE = registerBlock("woar_slate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.LAPIS)));
    public static final DeferredBlock<Block> SCORIA = registerBlock("scoria",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(4f).mapColor(MapColor.COLOR_BROWN)));

    // WOAR MATERIALS
    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of().strength(2f).noLootTable()));


    public static final DeferredBlock<Block> WOAR_BLOCK = registerBlock("woar_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f, 8f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .instrument(NoteBlockInstrument.COW_BELL)
                    .mapColor(MapColor.GRASS)
                    ));
    public static final DeferredBlock<StairBlock> WOAR_STAIRS = registerBlock("woar_stairs",
            () -> new StairBlock(ModBlocks.WOAR_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .strength(1.5f, 8f).requiresCorrectToolForDrops()
                            .sound(SoundType.NETHERITE_BLOCK)
                            .instrument(NoteBlockInstrument.COW_BELL)
                            .mapColor(MapColor.GRASS)
            ));
    public static final DeferredBlock<SlabBlock> WOAR_SLAB = registerBlock("woar_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(1.5f, 9f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .instrument(NoteBlockInstrument.COW_BELL)
                    .mapColor(MapColor.GRASS)
            ));

    public static final DeferredBlock<Block> WOAR_BRICKS = registerBlock("woar_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)
                    .sound(SoundType.NETHERITE_BLOCK)
                    .instrument(NoteBlockInstrument.COW_BELL)
                    .mapColor(MapColor.GRASS)
            ));
    public static final DeferredBlock<StairBlock> WOAR_BRICK_STAIRS = registerBlock("woar_brick_stairs",
            () -> new StairBlock(ModBlocks.WOAR_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .strength(1.5f, 8f).requiresCorrectToolForDrops()
                            .sound(SoundType.NETHERITE_BLOCK)
                            .instrument(NoteBlockInstrument.COW_BELL)
                            .mapColor(MapColor.GRASS)
            ));
    public static final DeferredBlock<SlabBlock> WOAR_BRICK_SLAB = registerBlock("woar_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(1.5f, 9f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .instrument(NoteBlockInstrument.COW_BELL)
                    .mapColor(MapColor.GRASS)
            ));


    public static final DeferredBlock<PressurePlateBlock> WOAR_PRESSURE_PLATE = registerBlock("woar_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of()
                    .strength(1.5f, 8f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .instrument(NoteBlockInstrument.COW_BELL)
                    .mapColor(MapColor.GRASS)
            ));
    public static final DeferredBlock<ButtonBlock> WOAR_BUTTON = registerBlock("woar_button",
            () -> new ButtonBlock(BlockSetType.IRON, 30, BlockBehaviour.Properties.of()
                    .strength(1.5f, 8f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .instrument(NoteBlockInstrument.COW_BELL)
                    .mapColor(MapColor.GRASS)
            ));

    public static final DeferredBlock<FenceBlock> WOAR_FENCE = registerBlock("woar_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of()
                    .strength(1.5f, 8f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .instrument(NoteBlockInstrument.COW_BELL)
                    .mapColor(MapColor.GRASS)
            ));
    public static final DeferredBlock<FenceGateBlock> WOAR_FENCE_GATE = registerBlock("woar_fence_gate",
            () -> new FenceGateBlock(WoodType.DARK_OAK, BlockBehaviour.Properties.of()
                    .strength(1.5f, 8f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .instrument(NoteBlockInstrument.COW_BELL)
                    .mapColor(MapColor.GRASS)
            ));
    public static final DeferredBlock<TrapDoorBlock> WOAR_TRAPDOOR = registerBlock("woar_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.DARK_OAK, BlockBehaviour.Properties.of()
                    .strength(1.5f, 8f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .instrument(NoteBlockInstrument.COW_BELL)
                    .mapColor(MapColor.GRASS)

            ));
    public static final DeferredBlock<WallBlock> WOAR_WALL = registerBlock("woar_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                    .strength(1.5f, 8f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .instrument(NoteBlockInstrument.COW_BELL)
                    .mapColor(MapColor.GRASS)
            ));
    public static final DeferredBlock<DoorBlock> WOAR_DOOR = registerBlock("woar_door",
            () -> new DoorBlock(BlockSetType.DARK_OAK, BlockBehaviour.Properties.of()
                    .strength(1.5f, 8f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .instrument(NoteBlockInstrument.COW_BELL)
                    .mapColor(MapColor.GRASS)
            ));
    public static final DeferredBlock<Block> WOAR_LAMP = registerBlock("woar_lamp",
            () -> new WoarLampBlock(BlockBehaviour.Properties.of()
                    .strength(1.5f, 8f).requiresCorrectToolForDrops()
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

    public static final DeferredBlock<Block> WOAR_DEEPSLATE_ORE = registerBlock("woar_deepslate_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3.5f, 6f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_GOLD_ORE)
                    .mapColor(MapColor.STONE)
            ));

    public static final DeferredBlock<Block> POLISHED_WOAR_BRICKS = registerBlock("polished_woar_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(ModBlocks.WOAR_BRICKS.get())));

    public static final DeferredBlock<Block> WOAR_BRICK_TILES = registerBlock("woar_brick_tiles",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(ModBlocks.WOAR_BRICKS.get())));

    public static final DeferredBlock<RotatedPillarBlock> WOAR_BRICK_PILLAR = registerBlock("woar_brick_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.WOAR_BRICKS.get())));


    // special blocks

    public static final DeferredBlock<Block> WOAR_CORE = registerBlock("woar_core",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN).mapColor(MapColor.LAPIS).lightLevel(state -> 7)));

    // PYR MATERIALS
    public static final DeferredBlock<Block> PYR_ORE = registerBlock("pyr_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 5), BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_GOLD_ORE).mapColor(MapColor.COLOR_ORANGE)));

    public static final DeferredBlock<Block> PYR_DEEPSLATE_ORE = registerBlock("pyr_deepslate_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3.5f, 6f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_GOLD_ORE)
                    .mapColor(MapColor.STONE)
            ));

    public static final DeferredBlock<Block> PYR_BLOCK = registerBlock("pyr_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK).mapColor(MapColor.GOLD).lightLevel(state -> 10)));


    public static final DeferredBlock<StairBlock> PYR_STAIRS = registerBlock("pyr_stairs",
            () -> new StairBlock(ModBlocks.PYR_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .strength(1.5f, 8f).requiresCorrectToolForDrops()
                            .sound(SoundType.NETHERITE_BLOCK)
                            .instrument(NoteBlockInstrument.CHIME)
                            .mapColor(MapColor.GRASS)
            ));
    public static final DeferredBlock<SlabBlock> PYR_SLAB = registerBlock("pyr_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(1.5f, 9f).requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)
                    .instrument(NoteBlockInstrument.CHIME)
                    .mapColor(MapColor.GRASS)
            ));

    public static final DeferredBlock<Block> PYR_BRICKS = registerBlock("pyr_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)
                    .sound(SoundType.AMETHYST)
                    .instrument(NoteBlockInstrument.CHIME)
                    .mapColor(MapColor.GRASS)
            ));
    public static final DeferredBlock<StairBlock> PYR_BRICK_STAIRS = registerBlock("pyr_brick_stairs",
            () -> new StairBlock(ModBlocks.PYR_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .strength(1.5f, 8f).requiresCorrectToolForDrops()
                            .sound(SoundType.AMETHYST)
                            .instrument(NoteBlockInstrument.CHIME)
                            .mapColor(MapColor.GRASS)
            ));
    public static final DeferredBlock<SlabBlock> PYR_BRICK_SLAB = registerBlock("pyr_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(1.5f, 9f).requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)
                    .instrument(NoteBlockInstrument.CHIME)
                    .mapColor(MapColor.GRASS)
            ));
    public static final DeferredBlock<Block> POLISHED_PYR_BRICKS = registerBlock("polished_pyr_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(PYR_BRICKS.get())));

    public static final DeferredBlock<Block> PYR_BRICK_TILES = registerBlock("pyr_brick_tiles",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(PYR_BRICKS.get())));

    public static final DeferredBlock<RotatedPillarBlock> PYR_BRICK_PILLAR = registerBlock("pyr_brick_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(PYR_BRICKS.get())));

    public static final DeferredBlock<PressurePlateBlock> PYR_PRESSURE_PLATE = registerBlock("pyr_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of()
                    .strength(1.5f, 8f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .instrument(NoteBlockInstrument.COW_BELL)
                    .mapColor(MapColor.GRASS)
            ));
    public static final DeferredBlock<ButtonBlock> PYR_BUTTON = registerBlock("pyr_button",
            () -> new ButtonBlock(BlockSetType.IRON, 30, BlockBehaviour.Properties.of()
                    .strength(1.5f, 8f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .instrument(NoteBlockInstrument.COW_BELL)
                    .mapColor(MapColor.GRASS)
            ));

    public static final DeferredBlock<FenceBlock> PYR_FENCE = registerBlock("pyr_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of()
                    .strength(1.5f, 8f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .instrument(NoteBlockInstrument.COW_BELL)
                    .mapColor(MapColor.GRASS)
            ));
    public static final DeferredBlock<FenceGateBlock> PYR_FENCE_GATE = registerBlock("pyr_fence_gate",
            () -> new FenceGateBlock(WoodType.DARK_OAK, BlockBehaviour.Properties.of()
                    .strength(1.5f, 8f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .instrument(NoteBlockInstrument.COW_BELL)
                    .mapColor(MapColor.GRASS)
            ));
    public static final DeferredBlock<TrapDoorBlock> PYR_TRAPDOOR = registerBlock("pyr_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.DARK_OAK, BlockBehaviour.Properties.of()
                    .strength(1.5f, 8f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .instrument(NoteBlockInstrument.COW_BELL)
                    .mapColor(MapColor.GRASS)

            ));
    public static final DeferredBlock<WallBlock> PYR_WALL = registerBlock("pyr_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                    .strength(1.5f, 8f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .instrument(NoteBlockInstrument.COW_BELL)
                    .mapColor(MapColor.GRASS)
            ));
    public static final DeferredBlock<DoorBlock> PYR_DOOR = registerBlock("pyr_door",
            () -> new DoorBlock(BlockSetType.DARK_OAK, BlockBehaviour.Properties.of()
                    .strength(1.5f, 8f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .instrument(NoteBlockInstrument.COW_BELL)
                    .mapColor(MapColor.GRASS)
            ));


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
