package net.cl0msy.cl0msymod.datagen;

import net.cl0msy.cl0msymod.Cl0msyMod;
import net.cl0msy.cl0msymod.item.ModItems;
import net.cl0msy.cl0msymod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Cl0msyMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.WOAR.get())
                .add(ModItems.WOAR_RAW.get())
                .add(ModItems.PYR.get())
                .add(ModItems.PYR_RAW.get())
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.COMPASS);

        tag(ItemTags.SWORDS)
                .add(ModItems.WOAR_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.WOAR_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.WOAR_SHOVEL.get());
        tag(ItemTags.AXES)
                .add(ModItems.WOAR_AXE.get());
        tag(ItemTags.HOES)
                .add(ModItems.WOAR_HOE.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.WOAR_HELMET.get())
                .add(ModItems.WOAR_CHESTPLATE.get())
                .add(ModItems.WOAR_LEGGINGS.get())
                .add(ModItems.WOAR_BOOTS.get());

    }
}