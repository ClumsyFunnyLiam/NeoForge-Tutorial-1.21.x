package net.cl0msy.cl0msymod.item;

import net.cl0msy.cl0msymod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier WOAR = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_WOAR_TOOL,
            4500, 7.5F, -1.0F, 32, () -> Ingredient.of(ModItems.WOAR));

}