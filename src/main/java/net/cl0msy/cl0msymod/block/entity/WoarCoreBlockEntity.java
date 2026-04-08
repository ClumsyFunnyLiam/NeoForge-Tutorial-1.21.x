package net.cl0msy.cl0msymod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class WoarCoreBlockEntity extends BlockEntity {
    // You will need to register this in a ModBlockEntities DeferredRegister
    public WoarCoreBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.WOAR_CORE.get(), pos, state);
    }

    // We can add persistent data here later, like "Core Tier" or "Stored Arcane Power"
}