package net.cl0msy.cl0msymod.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.cl0msy.cl0msymod.Cl0msyMod;
import net.cl0msy.cl0msymod.client.model.Appendages;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class AppendagesLayer extends RenderLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Cl0msyMod.MODID, "textures/entity/appendages.png");
    private final Appendages<AbstractClientPlayer> appendagesModel;

    public AppendagesLayer(RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> parent, EntityModelSet modelSet, boolean slim) {
        super(parent);
        // Use the correct LayerLocation based on whether the player is Slim or Wide
        var loc = slim ? Appendages.SLIM_LAYER_LOCATION : Appendages.LAYER_LOCATION;
        this.appendagesModel = new Appendages<>(modelSet.bakeLayer(loc));
    }

    @Override
    public void render(PoseStack matrixStack, MultiBufferSource buffer, int packedLight, AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        // Only render if the player isn't invisible (like with a potion)
        if (player.isInvisible()) return;

        PlayerModel<AbstractClientPlayer> playerModel = this.getParentModel();

        ResourceLocation skinTexture = player.getSkin().texture();
        VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucent(skinTexture));

        this.getParentModel().copyPropertiesTo(this.appendagesModel);
        this.appendagesModel.prepareMobModel(player, limbSwing, limbSwingAmount, partialTicks);
        this.appendagesModel.setupAnim(player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

        this.appendagesModel.renderToBuffer(matrixStack, vertexConsumer, packedLight, LivingEntityRenderer.getOverlayCoords(player, 0.0F));
    }
}