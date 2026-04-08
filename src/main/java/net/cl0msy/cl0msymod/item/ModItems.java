package net.cl0msy.cl0msymod.item;

// fualatogan or jitulyang, man idk
// by cl0msy April 5th, Sunday, 2026,
// start time: 6:04 PM.
// end time:

import net.cl0msy.cl0msymod.Cl0msyMod;
import net.cl0msy.cl0msymod.item.custom.ChiselItem;
import net.cl0msy.cl0msymod.item.custom.FuelItem;
import net.cl0msy.cl0msymod.item.custom.HammerItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;



public class ModItems {

    // Mod structures
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Cl0msyMod.MODID);


    // Mod Tabs



    // Mod Items

    public static final DeferredItem<Item> WOAR = ITEMS.register("woar",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> WOAR_RAW = ITEMS.register("woar_raw",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PYR = ITEMS.register("pyr",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PYR_RAW = ITEMS.register("pyr_raw",
            () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    public static final DeferredItem<Item> RADISH = ITEMS.register("radish",
            () -> new Item(new Item.Properties().food(ModFoodProperties.RADISH)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.tutorialmod.radish.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

//    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.register("frostfire_ice",
//            () -> new FuelItem(new Item.Properties(), 800));
//    public static final DeferredItem<Item> STARLIGHT_ASHES = ITEMS.register("starlight_ashes",
//            () -> new Item(new Item.Properties()));

    public static final DeferredItem<SwordItem> WOAR_SWORD = ITEMS.register("woar_sword",
            () -> new SwordItem(ModToolTiers.WOAR, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.WOAR, 5, -2.4f))));
    public static final DeferredItem<PickaxeItem> WOAR_PICKAXE = ITEMS.register("woar_pickaxe",
            () -> new PickaxeItem(ModToolTiers.WOAR, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.WOAR, 1.0F, -2.8f))));
    public static final DeferredItem<ShovelItem> WOAR_SHOVEL = ITEMS.register("woar_shovel",
            () -> new ShovelItem(ModToolTiers.WOAR, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.WOAR, 1.5F, -3.0f))));
    public static final DeferredItem<AxeItem> WOAR_AXE = ITEMS.register("woar_axe",
            () -> new AxeItem(ModToolTiers.WOAR, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.WOAR, 6.0F, -3.2f))));
    public static final DeferredItem<HoeItem> WOAR_HOE = ITEMS.register("woar_hoe",
            () -> new HoeItem(ModToolTiers.WOAR, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.WOAR, 0F, -3.0f))));

    public static final DeferredItem<HammerItem> WOAR_HAMMER = ITEMS.register("woar_hammer",
            () -> new HammerItem(ModToolTiers.WOAR, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.WOAR, 7F, -3.5f))));



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
