package net.cl0msy.cl0msymod.datagen;

import net.cl0msy.cl0msymod.Cl0msyMod;
import net.cl0msy.cl0msymod.block.ModBlocks;
import net.cl0msy.cl0msymod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> WOAR_SMELTABLES = List.of(ModItems.WOAR_RAW,
                ModBlocks.WOAR_ORE, ModBlocks.WOAR_DEEPSLATE_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WOAR_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.WOAR.get())
                .unlockedBy("has_woar", has(ModItems.WOAR)).save(recipeOutput);

        // 4 Woar -> 1 Woar Brick (2x2)
        twoByTwoPacker(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WOAR_BRICKS.get(), ModItems.WOAR.get(), 1);

        // 4 Woar Blocks -> 36 Woar Bricks
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WOAR_BRICKS.get(), 36)
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.WOAR_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.WOAR_BLOCK.get()), has(ModBlocks.WOAR_BLOCK.get()))
                .save(recipeOutput, Cl0msyMod.MODID + ":woar_bricks_from_blocks");

        // 1 Woar Brick -> 4 Woar (Unpacking)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WOAR.get(), 4)
                .requires(ModBlocks.WOAR_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.WOAR_BRICKS.get()), has(ModBlocks.WOAR_BRICKS.get()))
                .save(recipeOutput, Cl0msyMod.MODID + ":woar_from_bricks");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WOAR.get(), 9)
                .requires(ModBlocks.WOAR_BLOCK)
                .unlockedBy("has_woar_block", has(ModBlocks.WOAR_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WOAR.get(), 18)
                .requires(ModBlocks.MAGIC_BLOCK)
                .unlockedBy("has_magic_block", has(ModBlocks.MAGIC_BLOCK))
                .save(recipeOutput, "cl0msymod:woar_from_magic_block");

        oreSmelting(recipeOutput, WOAR_SMELTABLES, RecipeCategory.MISC, ModItems.WOAR.get(), 0.25f, 200, "woar");
        oreBlasting(recipeOutput, WOAR_SMELTABLES, RecipeCategory.MISC, ModItems.WOAR.get(), 0.25f, 100, "woar");

        stairBuilder(ModBlocks.WOAR_STAIRS.get(), Ingredient.of(ModItems.WOAR)).group("woar")
                .unlockedBy("has_woar", has(ModItems.WOAR)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WOAR_SLAB.get(), ModItems.WOAR.get());

        stairBuilder(ModBlocks.WOAR_BRICK_STAIRS.get(), Ingredient.of(ModBlocks.WOAR_BRICKS)).group("woar")
                .unlockedBy("has_woar", has(ModBlocks.WOAR_BRICKS)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WOAR_BRICK_SLAB.get(), ModBlocks.WOAR_BRICKS.get());

        buttonBuilder(ModBlocks.WOAR_BUTTON.get(), Ingredient.of(ModItems.WOAR.get())).group("woar")
                .unlockedBy("has_woar", has(ModItems.WOAR.get())).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.WOAR_PRESSURE_PLATE.get(), ModItems.WOAR.get());

        fenceBuilder(ModBlocks.WOAR_FENCE.get(), Ingredient.of(ModItems.WOAR.get())).group("woar")
                .unlockedBy("has_woar", has(ModItems.WOAR.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.WOAR_FENCE_GATE.get(), Ingredient.of(ModItems.WOAR.get())).group("woar")
                .unlockedBy("has_woar", has(ModItems.WOAR.get())).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WOAR_WALL.get(), ModItems.WOAR.get());

        doorBuilder(ModBlocks.WOAR_DOOR.get(), Ingredient.of(ModItems.WOAR.get())).group("woar")
                .unlockedBy("has_woar", has(ModItems.WOAR.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.WOAR_TRAPDOOR.get(), Ingredient.of(ModItems.WOAR.get())).group("woar")
                .unlockedBy("has_woar", has(ModItems.WOAR.get())).save(recipeOutput);

        // Woar Helmet
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.WOAR_HELMET.get())
                .pattern("WWW")
                .pattern("W W")
                .define('W', ModItems.WOAR.get())
                .unlockedBy(getHasName(ModItems.WOAR.get()), has(ModItems.WOAR.get()))
                .save(recipeOutput);

        // Woar Chestplate
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.WOAR_CHESTPLATE.get())
                .pattern("W W")
                .pattern("WWW")
                .pattern("WWW")
                .define('W', ModItems.WOAR.get())
                .unlockedBy(getHasName(ModItems.WOAR.get()), has(ModItems.WOAR.get()))
                .save(recipeOutput);

        // Woar Leggings
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.WOAR_LEGGINGS.get())
                .pattern("WWW")
                .pattern("W W")
                .pattern("W W")
                .define('W', ModItems.WOAR.get())
                .unlockedBy(getHasName(ModItems.WOAR.get()), has(ModItems.WOAR.get()))
                .save(recipeOutput);

        // Woar Boots
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.WOAR_BOOTS.get())
                .pattern("W W")
                .pattern("W W")
                .define('W', ModItems.WOAR.get())
                .unlockedBy(getHasName(ModItems.WOAR.get()), has(ModItems.WOAR.get()))
                .save(recipeOutput);

        // --- PYR ORE SMELTING ---
        List<ItemLike> PYR_SMELTABLES = List.of(ModItems.PYR_RAW.get(),
                ModBlocks.PYR_ORE.get(), ModBlocks.PYR_DEEPSLATE_ORE.get());

        // Smelting (Furnace)
        oreSmelting(recipeOutput, PYR_SMELTABLES, RecipeCategory.MISC, ModItems.PYR.get(), 0.7f, 200, "pyr");
        // Blasting (Blast Furnace)
        oreBlasting(recipeOutput, PYR_SMELTABLES, RecipeCategory.MISC, ModItems.PYR.get(), 0.7f, 100, "pyr");

        // --- PYR CRAFTING ---
        // Pyr Block (9 Ingots)
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModItems.PYR.get(), RecipeCategory.MISC, ModBlocks.PYR_BLOCK.get());

        // Pyr Bricks (4 Pyr Blocks in a 2x2)
        twoByTwoPacker(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PYR_BRICKS.get(), ModBlocks.PYR_BLOCK.get(), 1);

        // Polished Pyr Bricks (Smelt Pyr Bricks)
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.PYR_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.POLISHED_PYR_BRICKS.get(), 0.1f, 200)
                .unlockedBy(getHasName(ModBlocks.PYR_BRICKS.get()), has(ModBlocks.PYR_BRICKS.get()))
                .save(recipeOutput);

        // Pyr Brick Tiles (2x2 Polished Bricks)
        twoByTwoPacker(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PYR_BRICK_TILES.get(), ModBlocks.POLISHED_PYR_BRICKS.get(), 1);

        // Pyr Brick Pillar (Vertical 1x2 or 1x3 depending on your preference)
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PYR_BRICK_PILLAR.get(), 2)
                .pattern("#")
                .pattern("#")
                .define('#', ModBlocks.PYR_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.PYR_BRICKS.get()), has(ModBlocks.PYR_BRICKS.get()))
                .save(recipeOutput);

        // --- POWER CORE RECIPE ---
        // Example: A Power Core made from 4 Pyr Ingots and a Diamond (adjust to your liking)
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WOAR_CORE.get())
                .pattern(" P ")
                .pattern("PDP")
                .pattern(" P ")
                .define('P', ModItems.PYR.get())
                .define('D', Items.DIAMOND)
                .unlockedBy(getHasName(ModItems.PYR.get()), has(ModItems.PYR.get()))
                .save(recipeOutput);


        /*
        createStonecuttingRecipe(recipeOutput, ModBlocks.POLISHED_WOAR_BRICKS, ModBlocks.WOAR_BRICKS);
        createStonecuttingRecipe(recipeOutput, ModBlocks.WOAR_BRICK_TILES, ModBlocks.WOAR_BRICKS);
        createStonecuttingRecipe(recipeOutput, ModBlocks.WOAR_BRICK_PILLAR, ModBlocks.WOAR_BRICKS);


         */

    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Cl0msyMod.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

    protected static void twoByTwoPacker(RecipeOutput recipeOutput, RecipeCategory category, ItemLike packed, ItemLike unpacked, int count) {
        ShapedRecipeBuilder.shaped(category, packed, count)
                .define('#', unpacked)
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(unpacked), has(unpacked))
                .save(recipeOutput);
    }

    private void createStonecuttingRecipe(RecipeOutput output, DeferredBlock<Block> result, DeferredBlock<Block> ingredient) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient.get()), RecipeCategory.BUILDING_BLOCKS, result.get())
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get()))
                .save(output, Cl0msyMod.MODID + ":" + getItemName(result.get()) + "_stonecutting");
    }
}