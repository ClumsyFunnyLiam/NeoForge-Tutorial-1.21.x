package net.cl0msy.cl0msymod.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.cl0msy.cl0msymod.Cl0msyMod;
import net.cl0msy.cl0msymod.ModSettings;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

public class Appendages<T extends LivingEntity> extends EntityModel<T> {
	public final ModelPart body, leftArm, rightArm, leftLeg, rightLeg;
	public final ModelPart lBreast, rBreast, lHand, rHand, lToes, rToes;
	public final ModelPart lBreast_outer, rBreast_outer, lHand_outer, rHand_outer, lToes_outer, rToes_outer;

	// Controlled by AppendagesLayer
	public float armorPush = 0.0F;

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(Cl0msyMod.MODID, "appendages"), "main");

	public Appendages(ModelPart root) {
		this.body = root.getChild("body");
		this.leftArm = root.getChild("left_arm");
		this.rightArm = root.getChild("right_arm");
		this.leftLeg = root.getChild("left_leg");
		this.rightLeg = root.getChild("right_leg");

		this.lBreast = this.body.getChild("left_breast");
		this.rBreast = this.body.getChild("right_breast");
		this.lHand = this.leftArm.getChild("hand");
		this.rHand = this.rightArm.getChild("hand");
		this.lToes = this.leftLeg.getChild("toes");
		this.rToes = this.rightLeg.getChild("toes");

		this.lBreast_outer = this.lBreast.getChild("outer");
		this.rBreast_outer = this.rBreast.getChild("outer");
		this.lHand_outer = this.lHand.getChild("outer");
		this.rHand_outer = this.rHand.getChild("outer");
		this.lToes_outer = this.lToes.getChild("outer");
		this.rToes_outer = this.rToes.getChild("outer");
	}

	public static LayerDefinition createLayer() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);

		// ================= LEFT BREAST =================
		PartDefinition lb = body.addOrReplaceChild("left_breast",
				CubeListBuilder.create()
						.texOffs(23, 17)
						.addBox(-1.75F, -2.0F, -2.5F, 3.75F, 3.9F, 3.6F)

						// bottom face (HAS THICKNESS)
						.texOffs(20, 28)
						.addBox(-1.75F, 1.95F, -2.5F, 3.75F, 0.02F, 3.6F),
				PartPose.ZERO
		);

		lb.addOrReplaceChild("outer",
				CubeListBuilder.create()
						.texOffs(23, 33)
						.addBox(-1.75F, -2.0F, -2.5F,
								3.75F, 3.9F, 3.6F,
								new CubeDeformation(0.3F))

						// compensated bottom face
						.texOffs(23, 35)
						.addBox(
								-1.75F,
								1.95F - 0.3F,
								-2.5F,
								3.75F,
								0.02F,
								3.6F,
								new CubeDeformation(0.3F)
						),
				PartPose.ZERO
		);

		// ================= RIGHT BREAST (NOW MATCHES LEFT) =================
		PartDefinition rb = body.addOrReplaceChild("right_breast",
				CubeListBuilder.create()
						// SAME VALUES AS LEFT (IMPORTANT)
						.texOffs(16, 17)
						.addBox(-1.75F, -2.0F, -2.5F, 3.75F, 3.9F, 3.6F)

						.texOffs(20, 28)
						.addBox(-1.75F, 1.95F, -2.5F, 3.75F, 0.02F, 3.6F),
				PartPose.ZERO
		);

		rb.addOrReplaceChild("outer",
				CubeListBuilder.create()
						.texOffs(16, 33)
						.addBox(-1.75F, -2.0F, -2.5F,
								3.75F, 3.9F, 3.6F,
								new CubeDeformation(0.3F))

						.texOffs(16, 35)
						.addBox(
								-1.75F,
								1.95F - 0.3F,
								-2.5F,
								3.75F,
								0.02F,
								3.6F,
								new CubeDeformation(0.3F)
						),
				PartPose.ZERO
		);
		// --- ARMS & LEGS (Keeping your working structure) ---
		PartDefinition left_arm = root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		PartDefinition lHand = left_arm.addOrReplaceChild("hand", CubeListBuilder.create().texOffs(32, 48).addBox(-2.0F, 10.0F, -2.0F, 4.0F, 2.5F, 4.0F), PartPose.ZERO);
		lHand.addOrReplaceChild("outer", CubeListBuilder.create().texOffs(48, 48).addBox(-2.0F, 10.0F, -2.0F, 4.0F, 2.5F, 4.0F, new CubeDeformation(0.25F)), PartPose.ZERO);

		PartDefinition right_arm = root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		PartDefinition rHand = right_arm.addOrReplaceChild("hand", CubeListBuilder.create().texOffs(40, 16).addBox(-2.0F, 10.0F, -2.0F, 4.0F, 2.5F, 4.0F), PartPose.ZERO);
		rHand.addOrReplaceChild("outer", CubeListBuilder.create().texOffs(40, 32).addBox(-2.0F, 10.0F, -2.0F, 4.0F, 2.5F, 4.0F, new CubeDeformation(0.25F)), PartPose.ZERO);

		PartDefinition left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition lToes = left_leg.addOrReplaceChild("toes", CubeListBuilder.create().texOffs(16, 48).addBox(-2.0F, 11.0F, -4.0F, 4.0F, 1.0F, 2.0F), PartPose.ZERO);
		lToes.addOrReplaceChild("outer", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0F, 11.0F, -4.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.ZERO);

		PartDefinition right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
		PartDefinition rToes = right_leg.addOrReplaceChild("toes", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 11.0F, -4.0F, 4.0F, 1.0F, 2.0F), PartPose.ZERO);
		rToes.addOrReplaceChild("outer", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, 11.0F, -4.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.ZERO);

		return LayerDefinition.create(mesh, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float size = ModSettings.chestSize;

		this.rightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.leftArm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.rightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

		// --- YOUR ORIGINAL CROUCHING LOGIC ---
		boolean isCrouching = entity.isCrouching();
		float crouchYOffset = isCrouching ? 4.2F : 0F;
		float crouchZOffset = isCrouching ? 3.5F : 0F;
		float crouchXRot = isCrouching ? 0.5F : 0F;

		this.body.y = crouchYOffset;
		this.body.z = crouchZOffset;
		this.body.xRot = crouchXRot;

		float rotX, rotY, rotZ, posX, posY, posZ, scaleX, scaleY, scaleZ;

		if (size <= 1.0F) {
			float t = (size - 0.5F) / 0.5F;
			rotX = lerp(t, -0.4363F, -0.3943F);
			rotY = lerp(t, 0, 0.0236F);
			rotZ = lerp(t, 0, -0.057F);
			posX = lerp(t, 2F, 2.2f);
			posY = lerp(t, 3F, 3.5F);
			posZ = lerp(t, -0.65F, -1.2F);
			scaleX = lerp(t, 0.8F, 1F);
			scaleY = lerp(t, 1F, 1F);
			scaleZ = lerp(t, 0.72F, 0.72F);
		} else {
			float t = (size - 1.0F);
			rotX = lerp(t, -0.3943F, -0.482F);
			rotY = lerp(t, 0.0236F, -0.0128F);
			rotZ = lerp(t, -0.057F, -0.1266F);
			posX = lerp(t, 2.2f, 2.4f);
			posY = lerp(t, 3.5F, 5.25F);
			posZ = lerp(t, -1.2F, -1F);
			scaleX = lerp(t, 1.0F, 1.2F);
			scaleY = lerp(t, 1F, 1.2F);
			scaleZ = lerp(t, 0.72F, 1.0F);
		}

		float mass = Math.max(0.5F, size);
		float verticalVelocity = (float) entity.getDeltaMovement().y;
		if (isCrouching) {
			verticalVelocity -= 0.5f;
		}

		float gravityLag =  Math.max(-2.0F, Math.min(verticalVelocity * 2.0F, 2.0F)) * mass;

		float walkBounce = Math.abs((float)Math.cos(limbSwing * 0.6662F)) * 0.5F * limbSwingAmount * mass;
		float breathing = (float)Math.sin(ageInTicks * 0.1F) * 0.05F * mass;

		// REDUCED GRAVITY WHEN WEARING CHESTPLATE
		if (armorPush > 0) {
			gravityLag = 0.05f * gravityLag;
			walkBounce = 0.05f * gravityLag;
			breathing = 0;
		}

		this.lBreast.x = posX;
		this.rBreast.x = -posX;
		float bug = Math.max(Math.min(0.5f, gravityLag), -1.5f) / 2f;
		this.lBreast.y = posY + walkBounce + bug + breathing;
		this.rBreast.y = posY + walkBounce + bug + breathing;

		// PUSH OUTWARD WHEN WEARING ARMOR
		this.lBreast.z = posZ - armorPush;
		this.rBreast.z = posZ - armorPush;

		this.lBreast.xRot = rotX;
		this.rBreast.xRot = rotX;
		this.lBreast.yRot = rotY;
		this.rBreast.yRot = -rotY;
		this.lBreast.zRot = rotZ;
		this.rBreast.zRot = -rotZ;

		this.lBreast.xScale = scaleX;
		this.lBreast.yScale = scaleY;

		this.lBreast.zScale = scaleZ;
		this.rBreast.xScale = scaleX;
		this.rBreast.yScale = scaleY;
		this.rBreast.zScale = scaleZ;

		// YOUR ORIGINAL CROUCH ADJUSTMENTS
		if (isCrouching) {
			this.lBreast.x -= mass * 0.3f;
			this.lBreast.y -= 1.5f + verticalVelocity;
			this.lBreast.z -= 3;
			this.lBreast.xRot -= .2f;
			this.lBreast.yRot = lerp((size - .5f) / 1.5f, this.lBreast.yRot, 0.2f);
			this.lBreast.zRot = lerp(0.7f, this.lBreast.zRot, 0);

			this.rBreast.x += mass * 0.3f;
			this.rBreast.y -= 1.5f;
			this.rBreast.z -= 3;
			this.rBreast.xRot -= .2f;
			this.rBreast.yRot = lerp((size - .5f) / 1.5f, this.rBreast.yRot, -0.2f);
			this.rBreast.zRot = lerp(0.7f, this.rBreast.zRot, 0);

			this.leftLeg.y = 12.0F + 3.2F;
			this.rightLeg.y = 12.0F + 3.2F;
		} else {
			this.leftLeg.y = 12.0F;
			this.rightLeg.y = 12.0F;
		}

		this.leftLeg.z = 0.0F;
		this.rightLeg.z = 0.0F;

		if (!entity.getMainHandItem().isEmpty()) {
			this.rHand.xRot = -0.5F;
		} else {
			this.rHand.xRot = 0;
		}

		if (!entity.getOffhandItem().isEmpty()) {
			this.lHand.xRot = -0.5F;
		} else {
			this.lHand.xRot = 0;
		}

		// LAG-FREE OUTER LAYER SYNC
		this.lBreast_outer.x = 0; this.lBreast_outer.y = 0; this.lBreast_outer.z = 0;
		this.rBreast_outer.x = 0; this.rBreast_outer.y = 0; this.rBreast_outer.z = 0;

		this.lBreast_outer.xRot = 0; this.lBreast_outer.yRot = 0; this.lBreast_outer.zRot = 0;
		this.rBreast_outer.xRot = 0; this.rBreast_outer.yRot = 0; this.rBreast_outer.zRot = 0;

// Scales should still match to maintain the shape
		this.lBreast_outer.setPos(0, 0.05f, 0);
		this.rBreast_outer.setPos(0, 0.05f, 0);


	}

	private float lerp(float pct, float start, float end) {
		return start + pct * (end - start);
	}

	@Override
	public void renderToBuffer(PoseStack stack, VertexConsumer buffer, int light, int overlay, int color) {
		if (ModSettings.showChest) body.render(stack, buffer, light, overlay, color);
		if (ModSettings.showFingers) { leftArm.render(stack, buffer, light, overlay, color); rightArm.render(stack, buffer, light, overlay, color); }
		if (ModSettings.showFeet) { leftLeg.render(stack, buffer, light, overlay, color); rightLeg.render(stack, buffer, light, overlay, color); }
	}
}