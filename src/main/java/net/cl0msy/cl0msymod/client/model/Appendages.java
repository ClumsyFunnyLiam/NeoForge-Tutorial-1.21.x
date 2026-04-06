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
import net.minecraft.util.ColorRGBA;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

import java.awt.*;

public class Appendages<T extends LivingEntity> extends EntityModel<T> {
	public final ModelPart body, leftArm, rightArm, leftLeg, rightLeg;
	private final ModelPart lBreast, rBreast, lHand, rHand, lToes, rToes;

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Cl0msyMod.MODID, "appendages"), "main");
	public static final ModelLayerLocation SLIM_LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Cl0msyMod.MODID, "appendages_slim"), "main");

	public Appendages(ModelPart root) {
		super();
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
	}

	public static LayerDefinition createLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		// BODY & BREASTS
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		body.addOrReplaceChild("left_breast", CubeListBuilder.create().texOffs(23, 17).addBox(-1.75F, -2.0F, -2.5F, 3.75F, 4.0F, 3.6F), PartPose.ZERO);
		body.addOrReplaceChild("right_breast", CubeListBuilder.create().texOffs(16, 17).addBox(-2.0F, -2.0F, -2.5F, 3.75F, 4.0F, 3.6F), PartPose.ZERO);

		// ARMS - Hands attached directly to the arm's pivot logic
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		left_arm.addOrReplaceChild("hand", CubeListBuilder.create().texOffs(32, 48)
				.addBox(-2.0F, 10.0F, -2.0F, 4.0F, 2.5F, 4.0F), PartPose.ZERO);

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		right_arm.addOrReplaceChild("hand", CubeListBuilder.create().texOffs(40, 16)
				.addBox(-2.0F, 10.0F, -2.0F, 4.0F, 2.5F, 4.0F), PartPose.ZERO);

		// LEGS - Toes attached directly to the leg's pivot logic
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
		left_leg.addOrReplaceChild("toes", CubeListBuilder.create().texOffs(16, 48)
				.addBox(-2.0F, 11.0F, -4.0F, 4.0F, 1.0F, 2.0F), PartPose.ZERO);

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
		right_leg.addOrReplaceChild("toes", CubeListBuilder.create().texOffs(0, 16)
				.addBox(-2.0F, 11.0F, -4.0F, 4.0F, 1.0F, 2.0F), PartPose.ZERO);

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public static float lastRanL = 0;
	public static float lastRanR =0;

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float size = ModSettings.chestSize;

		this.rightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.leftArm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.rightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

		// --- 2. CROUCHING LOGIC ---
		boolean isCrouching = entity.isCrouching();
		float crouchYOffset = isCrouching ? 4.2F : 0F;
		float crouchZOffset = isCrouching ? 3.5F : 0F;
		float crouchXRot = isCrouching ? 0.5F : 0F;

		// Apply crouch to the main body and limbs
		this.body.y = crouchYOffset;
		this.body.z = crouchZOffset;
		this.body.xRot = crouchXRot;



		// Define the values from your 3 Pose Files
		// P1 = TestModel2 (Min), P2 = TestModel1 (Med), P3 = TestModel3 (Max)

		float rotX, rotY, rotZ, posX, posY, posZ, scaleX, scaleY, scaleZ;

		if (size <= 1.0F) {
			// TWEEN MIN TO MED (0.5 -> 1.0)
			float t = (size - 0.5F) / 0.5F; // Normalized 0 to 1
			rotX = lerp(t, -0.4363F, -0.3943F);
			rotY = lerp(t, 0, 0.0236F);
			rotZ = lerp(t, 0, -0.057F);

			posX = lerp(t, 2F, 2.2f);
			posY = lerp(t, 3F, 3.5F);
			posZ = lerp(t, -0.65F, -1.2F);


			scaleX = lerp(t, 0.8F, 1F); // Custom scale factor
			scaleY = lerp(t, 1F, 1F); // Custom scale factor
			scaleZ = lerp(t, 0.72F, 0.72F); // Custom scale factor


		} else {
			// TWEEN MED TO MAX (1.0 -> 2.0)
			float t = (size - 1.0F); // Normalized 0 to 1
			rotX = lerp(t, -0.3943F, -0.482F);
			rotY = lerp(t, 0.0236F, -0.0128F);
			rotZ = lerp(t, -0.057F, -0.1266F);

			posX = lerp(t, 2.2f, 2.4f);
			posY = lerp(t, 3.5F, 4.75F);
			posZ = lerp(t, -1.2F, 0F);


			scaleX = lerp(t, 1.0F, 1.2F); // Max scale factor
			scaleY = lerp(t, 1F, 1.15F); // Max scale factor
			scaleZ = lerp(t, 0.72F, 1.35F); // Max scale factor
		}

		// Physics
		float mass = Math.max(0.5F, size);
		float verticalVelocity = (float) entity.getDeltaMovement().y;
		if (isCrouching){
			verticalVelocity -= 0.5f;
		}
		float gravityLag = Math.max(-2.0F, Math.min(verticalVelocity * 2.0F, 2.0F)) * mass;
		float walkBounce = Math.abs((float)Math.cos(limbSwing * 0.6662F)) * 0.5F * limbSwingAmount * mass;
		float breathing = (float)Math.sin(ageInTicks * 0.1F) * 0.05F * mass;

		// Apply Breast Position (Body handles the crouch tilt automatically because breasts are children)
		this.lBreast.x = posX;
		this.rBreast.x = -posX;
		float bug = Math.max(Math.min(0.5f,gravityLag),-1.5f) / 2f;
		this.lBreast.y = posY + walkBounce + bug + breathing;
		this.rBreast.y = posY + walkBounce + bug + breathing;
		this.lBreast.z = posZ;
		this.rBreast.z = posZ;

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


		if (isCrouching) {
			this.lBreast.x -= mass * 0.3f;
			this.lBreast.y -= 1.5f + verticalVelocity;
			this.lBreast.z -= 3;
			this.lBreast.xRot -= .2f;
			this.lBreast.yRot = lerp((size-.5f)/1.5f, this.lBreast.yRot, 0.2f);
			this.lBreast.zRot = lerp(0.7f, this.lBreast.zRot, 0);

			this.rBreast.x += mass * 0.3f;
			this.rBreast.y -= 1.5f;
			this.rBreast.z -= 3;
			this.rBreast.xRot -= .2f;
			this.rBreast.yRot = lerp((size-.5f)/1.5f, this.rBreast.yRot, -0.2f);
			this.rBreast.zRot = lerp(0.7f, this.rBreast.zRot, 0);


			this.leftLeg.y = 12.0F + 3.2F;
			this.rightLeg.y = 12.0F + 3.2F;

		} else {
			this.leftLeg.y = 12.0F;
			this.rightLeg.y = 12.0F;

		}
		this.leftLeg.z = 0.0F;
		this.rightLeg.z = 0.0F;

		// --- 4. HANDS & TOES FIX ---
		// Ensure they stay attached and only rotate if holding an item
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
	}

	private float lerp(float pct, float start, float end) {
		return start + pct * (end - start);
	}

	@Override
	public void renderToBuffer(PoseStack stack, VertexConsumer buffer, int light, int overlay, int color) {
		// Child parts (hands, toes, breasts) render automatically when their parent is rendered.
		if (ModSettings.showChest) {
			body.render(stack, buffer, light, overlay, color);
		}
		if (ModSettings.showFingers) {
			leftArm.render(stack, buffer, light, overlay, color);
			rightArm.render(stack, buffer, light, overlay, color);
		}
		if (ModSettings.showFeet) {
			leftLeg.render(stack, buffer, light, overlay, color);
			rightLeg.render(stack, buffer, light, overlay, color);
		}
	}
}