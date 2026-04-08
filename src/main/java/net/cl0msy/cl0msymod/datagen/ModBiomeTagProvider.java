package net.cl0msy.cl0msymod.datagen;

import net.cl0msy.cl0msymod.Cl0msyMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagProvider extends TagsProvider<Biome> {
    public ModBiomeTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        // In 1.21.1, we must explicitly tell it we are using the BIOME registry
        super(output, Registries.BIOME, lookupProvider, Cl0msyMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Fix for "Cannot resolve symbol IS_HOT"
        // Vanilla uses BiomeTags.IS_HOT, but if that's missing in your version,
        // NeoForge provides a common "C" tag version:

        // WOAR: Generates in Cold/Snowy biomes
        tag(BiomeTags.IS_TAIGA)
                .add(Biomes.FROZEN_OCEAN)
                .add(Biomes.SNOWY_PLAINS)
                .add(Biomes.JAGGED_PEAKS);

        // PYR: Generates in Hot biomes
        // Using the common 'C' tag for 'is_hot' ensures Biomes O' Plenty works too!
        tag(Tags.Biomes.IS_HOT)
                .add(Biomes.DESERT)
                .add(Biomes.BADLANDS)
                .add(Biomes.ERODED_BADLANDS)
                .add(Biomes.SAVANNA);
    }
}