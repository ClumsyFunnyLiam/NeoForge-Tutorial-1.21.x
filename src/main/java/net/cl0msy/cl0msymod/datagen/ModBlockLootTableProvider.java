package net.cl0msy.cl0msymod.datagen;

import net.cl0msy.cl0msymod.block.ModBlocks;
import net.cl0msy.cl0msymod.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.WOAR_BLOCK.get());
        dropSelf(ModBlocks.WOAR_BRICKS.get());
        // dropSelf(ModBlocks.MAGIC_BLOCK.get());

        add(ModBlocks.WOAR_ORE.get(),
                block -> createOreDrop(ModBlocks.WOAR_ORE.get(), ModItems.WOAR_RAW.get()));
        add(ModBlocks.WOAR_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.WOAR_DEEPSLATE_ORE.get(), ModItems.WOAR_RAW.get(), 2, 5));

        dropSelf(ModBlocks.WOAR_STAIRS.get());
        add(ModBlocks.WOAR_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.WOAR_SLAB.get()));

        dropSelf(ModBlocks.WOAR_BRICK_STAIRS.get());
        add(ModBlocks.WOAR_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.WOAR_BRICK_SLAB.get()));

        dropSelf(ModBlocks.WOAR_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.WOAR_BUTTON.get());

        dropSelf(ModBlocks.WOAR_FENCE.get());
        dropSelf(ModBlocks.WOAR_FENCE_GATE.get());
        dropSelf(ModBlocks.WOAR_WALL.get());
        dropSelf(ModBlocks.WOAR_TRAPDOOR.get());

        add(ModBlocks.WOAR_DOOR.get(),
                block -> createDoorTable(ModBlocks.WOAR_DOOR.get()));

        dropSelf(ModBlocks.WOAR_LAMP.get());

        dropSelf(ModBlocks.POLISHED_WOAR_BRICKS.get());
        dropSelf(ModBlocks.WOAR_BRICK_TILES.get());
        dropSelf(ModBlocks.WOAR_BRICK_PILLAR.get());

        add(ModBlocks.PYR_ORE.get(),
                block -> createOreDrop(ModBlocks.WOAR_ORE.get(), ModItems.PYR_RAW.get()));
        add(ModBlocks.PYR_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.WOAR_DEEPSLATE_ORE.get(), ModItems.PYR_RAW.get(), 2, 5));

        dropSelf(ModBlocks.PYR_BLOCK.get());
        dropSelf(ModBlocks.PYR_STAIRS.get());
        add(ModBlocks.PYR_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PYR_SLAB.get()));

        dropSelf(ModBlocks.PYR_BRICKS.get());
        dropSelf(ModBlocks.PYR_BRICK_STAIRS.get());
        add(ModBlocks.PYR_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PYR_BRICK_SLAB.get()));
        dropSelf(ModBlocks.POLISHED_PYR_BRICKS.get());
        dropSelf(ModBlocks.PYR_BRICK_TILES.get());
        dropSelf(ModBlocks.PYR_BRICK_PILLAR.get());

        dropSelf(ModBlocks.PYR_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.PYR_BUTTON.get());

        dropSelf(ModBlocks.PYR_FENCE.get());
        dropSelf(ModBlocks.PYR_FENCE_GATE.get());
        dropSelf(ModBlocks.PYR_WALL.get());
//      add(ModBlocks.PYR_DOOR.get(),
//                block -> createDoorTable(ModBlocks.PYR_DOOR.get()));
//        dropSelf(ModBlocks.PYR_TRAPDOOR.get());

        dropSelf(ModBlocks.SLATE.get());
        dropSelf(ModBlocks.WOAR_SLATE.get());
        dropSelf(ModBlocks.SCORIA.get());
        dropSelf(ModBlocks.WOAR_CORE.get());

    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}