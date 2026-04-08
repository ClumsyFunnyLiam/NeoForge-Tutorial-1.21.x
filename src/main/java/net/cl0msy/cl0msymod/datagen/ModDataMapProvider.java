package net.cl0msy.cl0msymod.datagen;

import net.cl0msy.cl0msymod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;


import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    // Note: Ensure the constructor is public if being called from your DataGenerator entry point
    public ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider lookupProvider) { // Use 'gather' instead of 'gatherDataMaps'
        this.builder(NeoForgeDataMaps.FURNACE_FUELS);
//                .add(ModItems.STARLIGHT_ASHES.getId(), new FurnaceFuel(1200), false)
//                .add(ModItems.FROSTFIRE_ICE.getId(), new FurnaceFuel(2400), false);
    }
}