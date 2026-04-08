package net.cl0msy.cl0msymod.util;

import net.cl0msy.cl0msymod.Cl0msyMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_WOAR_TOOL = createTag("needs_woar_tool");
        public static final TagKey<Block> INCORRECT_FOR_WOAR_TOOL = createTag("incorrect_for_woar_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Cl0msyMod.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Cl0msyMod.MODID, name));
        }
    }
}