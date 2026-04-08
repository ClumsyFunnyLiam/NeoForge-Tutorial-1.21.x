package net.cl0msy.cl0msymod.block.entity;

import net.cl0msy.cl0msymod.Cl0msyMod;
import net.cl0msy.cl0msymod.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    // Create the DeferredRegister for Block Entities
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Cl0msyMod.MODID);

    // Register the Woar Core
    public static final Supplier<BlockEntityType<WoarCoreBlockEntity>> WOAR_CORE =
            BLOCK_ENTITIES.register("woar_core", () ->
                    BlockEntityType.Builder.of(WoarCoreBlockEntity::new, ModBlocks.WOAR_CORE.get()).build(null));

    // Don't forget to call this in your main Cl0msyMod constructor!
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}