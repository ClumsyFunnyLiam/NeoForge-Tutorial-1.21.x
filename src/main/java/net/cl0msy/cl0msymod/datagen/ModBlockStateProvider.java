package net.cl0msy.cl0msymod.datagen;



import net.cl0msy.cl0msymod.Cl0msyMod;
import net.cl0msy.cl0msymod.block.ModBlocks;
import net.cl0msy.cl0msymod.block.custom.WoarLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Cl0msyMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // --- WOAR BLOCKS ---
        blockWithItem(ModBlocks.WOAR_BLOCK);
        blockWithItem(ModBlocks.WOAR_BRICKS);
        blockWithItem(ModBlocks.WOAR_ORE);
        blockWithItem(ModBlocks.WOAR_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.MAGIC_BLOCK);
        blockWithItem(ModBlocks.WOAR_BRICK_TILES);
        blockWithItem(ModBlocks.POLISHED_WOAR_BRICKS);
        blockWithItem(ModBlocks.WOAR_BRICK_PILLAR);
        blockWithItem(ModBlocks.WOAR_CORE);

        // --- PYR BLOCKS ---
        blockWithItem(ModBlocks.PYR_BLOCK);
        blockWithItem(ModBlocks.PYR_BRICKS);

        blockWithItem(ModBlocks.POLISHED_PYR_BRICKS);
        blockWithItem(ModBlocks.PYR_BRICK_TILES);
        blockWithItem(ModBlocks.PYR_BRICK_PILLAR);
        blockWithItem(ModBlocks.PYR_ORE);
        blockWithItem(ModBlocks.PYR_DEEPSLATE_ORE);

        // --- WORLD BLOCKS ---
        blockWithItem(ModBlocks.SLATE);
        blockWithItem(ModBlocks.WOAR_SLATE);
        blockWithItem(ModBlocks.SCORIA);

        // --- SPECIAL BLOCKS ---
        stairsBlock(ModBlocks.WOAR_STAIRS.get(), blockTexture(ModBlocks.WOAR_BLOCK.get()));
        slabBlock(ModBlocks.WOAR_SLAB.get(), ModBlocks.WOAR_BLOCK.getId(), blockTexture(ModBlocks.WOAR_BLOCK.get()));

        stairsBlock(ModBlocks.PYR_STAIRS.get(), blockTexture(ModBlocks.PYR_BLOCK.get()));
        slabBlock(ModBlocks.PYR_SLAB.get(), ModBlocks.PYR_BLOCK.getId(), blockTexture(ModBlocks.PYR_BLOCK.get()));

        stairsBlock(ModBlocks.PYR_BRICK_STAIRS.get(), blockTexture(ModBlocks.PYR_BRICKS.get()));
        slabBlock(ModBlocks.PYR_BRICK_SLAB.get(), ModBlocks.PYR_BRICKS.getId(), blockTexture(ModBlocks.PYR_BRICKS.get()));

        buttonBlock(ModBlocks.WOAR_BUTTON.get(), blockTexture(ModBlocks.WOAR_BLOCK.get()));
        pressurePlateBlock(ModBlocks.WOAR_PRESSURE_PLATE.get(), blockTexture(ModBlocks.WOAR_BLOCK.get()));

        fenceBlock(ModBlocks.WOAR_FENCE.get(), blockTexture(ModBlocks.WOAR_BLOCK.get()));
        fenceGateBlock(ModBlocks.WOAR_FENCE_GATE.get(), blockTexture(ModBlocks.WOAR_BLOCK.get()));
        wallBlock(ModBlocks.WOAR_WALL.get(), blockTexture(ModBlocks.WOAR_BLOCK.get()));

        trapdoorBlockWithRenderType(ModBlocks.WOAR_TRAPDOOR.get(), blockTexture(ModBlocks.WOAR_TRAPDOOR.get()), true, "cutout");
        doorBlockWithRenderType(ModBlocks.WOAR_DOOR.get(), modLoc("block/woar_door_bottom"), modLoc("block/woar_door_top"), "cutout");

        stairsBlock(ModBlocks.WOAR_BRICK_STAIRS.get(), blockTexture(ModBlocks.WOAR_BRICKS.get()));
        slabBlock(ModBlocks.WOAR_BRICK_SLAB.get(), ModBlocks.WOAR_BRICKS.getId(), blockTexture(ModBlocks.WOAR_BRICKS.get()));

        customLamp();
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.WOAR_LAMP.get()).forAllStates(state -> {
            if(state.getValue(WoarLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("woar_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(Cl0msyMod.MODID, "block/" + "woar_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("woar_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(Cl0msyMod.MODID, "block/" + "woar_lamp_off")))};
            }
        });

        simpleBlockItem(ModBlocks.WOAR_LAMP.get(), models().cubeAll("woar_lamp_on",
                ResourceLocation.fromNamespaceAndPath(Cl0msyMod.MODID, "block/" + "woar_lamp_on")));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("cl0msymod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem2(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("cl0msymod:block/" + deferredBlock.getId().getPath() + appendix));
    }
}