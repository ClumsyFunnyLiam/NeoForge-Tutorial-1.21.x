package net.cl0msy.cl0msymod.datagen;

import net.cl0msy.cl0msymod.Cl0msyMod;
import net.cl0msy.cl0msymod.block.ModBlocks;
import net.cl0msy.cl0msymod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Cl0msyMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.WOAR_BLOCK.get())
                .add(ModBlocks.WOAR_BRICKS.get())
                .add(ModBlocks.WOAR_ORE.get())
                .add(ModBlocks.WOAR_LAMP.get())
                .add(ModBlocks.WOAR_DEEPSLATE_ORE.get())

                .add(ModBlocks.PYR_BLOCK.get())
                .add(ModBlocks.PYR_BRICKS.get())
                .add(ModBlocks.PYR_BRICK_PILLAR.get())
                .add(ModBlocks.PYR_BRICK_TILES.get())
                .add(ModBlocks.PYR_ORE.get())
                .add(ModBlocks.PYR_DEEPSLATE_ORE.get())


                .add(ModBlocks.SCORIA.get())
                .add(ModBlocks.WOAR_SLATE.get())
                .add(ModBlocks.SLATE.get())




                .add(ModBlocks.POLISHED_WOAR_BRICKS.get())
                .add(ModBlocks.POLISHED_PYR_BRICKS.get());


        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.WOAR_DEEPSLATE_ORE.get())
                .add(ModBlocks.PYR_DEEPSLATE_ORE.get())
                .add(ModBlocks.WOAR_LAMP.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL);


        tag(BlockTags.FENCES).add(ModBlocks.WOAR_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.WOAR_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.WOAR_WALL.get());
        tag(BlockTags.WALL_POST_OVERRIDE).add(ModBlocks.WOAR_WALL.get());

        tag(ModTags.Blocks.NEEDS_WOAR_TOOL)
                .add(ModBlocks.WOAR_LAMP.get())
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_WOAR_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_WOAR_TOOL);
    }
}

