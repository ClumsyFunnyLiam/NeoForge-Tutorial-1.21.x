package net.cl0msy.cl0msymod.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.cl0msy.cl0msymod.ModSettings;
import net.cl0msy.cl0msymod.client.model.Appendages;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class AppendagesLayer<T extends AbstractClientPlayer, M extends PlayerModel<T>> extends RenderLayer<T, M> {
    private final Appendages<T> appendagesModel;

    public AppendagesLayer(RenderLayerParent<T, M> parent, EntityModelSet modelSet) {
        super(parent);

        this.appendagesModel = new Appendages<>(modelSet.bakeLayer(Appendages.LAYER_LOCATION));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, T player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (player.isInvisible()) return;

        this.getParentModel().copyPropertiesTo(this.appendagesModel);

        boolean hasChestplate = !player.getItemBySlot(EquipmentSlot.CHEST).isEmpty();
        this.appendagesModel.armorPush = hasChestplate ? 1.25f : 0.0f;


        this.appendagesModel.setupAnim(player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);


        boolean showJacket = player.isModelPartShown(PlayerModelPart.JACKET);
        this.appendagesModel.lBreast_outer.visible = showJacket && !hasChestplate;
        this.appendagesModel.rBreast_outer.visible = showJacket && !hasChestplate;

        this.appendagesModel.lHand_outer.visible = player.isModelPartShown(PlayerModelPart.LEFT_SLEEVE);
        this.appendagesModel.rHand_outer.visible = player.isModelPartShown(PlayerModelPart.RIGHT_SLEEVE);
        this.appendagesModel.lToes_outer.visible = player.isModelPartShown(PlayerModelPart.LEFT_PANTS_LEG);
        this.appendagesModel.rToes_outer.visible = player.isModelPartShown(PlayerModelPart.RIGHT_PANTS_LEG);

        // RENDER SKIN
        ResourceLocation skinTexture = player.getSkin().texture();
        VertexConsumer skinConsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(skinTexture));
        this.appendagesModel.renderToBuffer(poseStack, skinConsumer, packedLight, LivingEntityRenderer.getOverlayCoords(player, 0.0F), 0xFFFFFFFF);

        // RENDER ARMOR (Chest and Feet)
        renderArmorSlot(poseStack, buffer, player, EquipmentSlot.CHEST, packedLight);
        renderArmorSlot(poseStack, buffer, player, EquipmentSlot.FEET, packedLight);
    }

    private void renderArmorSlot(PoseStack poseStack, MultiBufferSource buffer, T player, EquipmentSlot slot, int packedLight) {
        ItemStack stack = player.getItemBySlot(slot);
        if (!stack.isEmpty() && stack.getItem() instanceof ArmorItem armorItem) {
            ResourceLocation armorResource = getArmorResource(stack, slot);
            VertexConsumer armorConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(armorResource));

            if (slot == EquipmentSlot.CHEST && ModSettings.showChest) {
                this.appendagesModel.body.render(poseStack, armorConsumer, packedLight, LivingEntityRenderer.getOverlayCoords(player, 0.0F), 0xFFFFFFFF);
            } else if (slot == EquipmentSlot.FEET && ModSettings.showFeet) {
                this.appendagesModel.leftLeg.render(poseStack, armorConsumer, packedLight, LivingEntityRenderer.getOverlayCoords(player, 0.0F), 0xFFFFFFFF);
                this.appendagesModel.rightLeg.render(poseStack, armorConsumer, packedLight, LivingEntityRenderer.getOverlayCoords(player, 0.0F), 0xFFFFFFFF);
            }
        }
    }

    private ResourceLocation getArmorResource(ItemStack stack, EquipmentSlot slot) {
        ArmorItem item = (ArmorItem) stack.getItem();
        ArmorMaterial material = item.getMaterial().value();
        int layer = (slot == EquipmentSlot.LEGS) ? 2 : 1;


        ResourceLocation baseLoc = material.layers().get(0).texture(false);
        return ResourceLocation.fromNamespaceAndPath(baseLoc.getNamespace(), baseLoc.getPath());
    }
}