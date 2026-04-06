package net.cl0msy.cl0msymod.item;

// fualatogan or jitulyang, man idk
// by cl0msy April 5th, Sunday, 2026,
// start time: 6:04 PM.
// end time:

import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.cl0msy.cl0msymod.Cl0msyMod.MODID;

public class ModItems {

    // Mod structures
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);


    // Mod Tabs



    // Mod Items

    public static final DeferredItem<Item> WOAR = ITEMS.register("woar",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> WOAR_RAW = ITEMS.register("woar_raw",
            () -> new Item(new Item.Properties()));


    // Mod Armors

    public static final DeferredItem<ArmorItem> WOAR_HELMET = ITEMS.register("woar_helmet",
            () -> new ArmorItem(ModArmorMaterials.WOAR_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
            new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> WOAR_CHESTPLATE = ITEMS.register("woar_chestplate",
            () -> new ArmorItem(ModArmorMaterials.WOAR_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredItem<ArmorItem> WOAR_LEGGINGS = ITEMS.register("woar_leggings",
            () -> new ArmorItem(ModArmorMaterials.WOAR_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> WOAR_BOOTS = ITEMS.register("woar_boots",
            () -> new ArmorItem(ModArmorMaterials.WOAR_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
