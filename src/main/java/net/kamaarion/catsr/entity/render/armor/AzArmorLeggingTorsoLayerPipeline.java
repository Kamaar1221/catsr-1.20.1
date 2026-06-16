package net.kamaarion.catsr.entity.render.armor;

import mod.azure.azurelib.model.AzBakedModel;
import mod.azure.azurelib.model.AzBone;
import mod.azure.azurelib.render.AzRendererPipeline;
import mod.azure.azurelib.render.armor.AzArmorRendererPipelineContext;
import mod.azure.azurelib.render.armor.bone.AzArmorBoneContext;
import mod.azure.azurelib.render.armor.bone.AzArmorBoneProvider;
import mod.azure.azurelib.util.client.RenderUtils;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import java.util.UUID;

public class AzArmorLeggingTorsoLayerPipeline extends AzArmorRendererPipelineContext {

    public AzArmorLeggingTorsoLayerPipeline(AzRendererPipeline<UUID, ItemStack> rendererPipeline) {
        super(rendererPipeline);
    }

    @Override
    public AzArmorBoneContext boneContext() {
        return new AzArmorBoneContext() {
            protected AzBone armorLeggingTorsoBone;

            public AzBone getArmorLeggingTorsoBone(AzBakedModel model) {
                return model.getBone("armorLeggingTorsoLayer").orElse(null);
            }

            @Override
            public void grabRelevantBones(AzBakedModel model, AzArmorBoneProvider boneProvider) {
                super.grabRelevantBones(model, boneProvider);
                this.armorLeggingTorsoBone = this.getArmorLeggingTorsoBone(model);
            }

            @Override
            public void applyBoneVisibilityBySlot(EquipmentSlot currentSlot) {
                // 1. Let AzureLib handle all standard minecraft armor visibility first
                super.applyBoneVisibilityBySlot(currentSlot);

                // 2. Control your custom torso layer safely without breaking parent bones
                if (this.armorLeggingTorsoBone != null) {
                    // Show it ONLY when the LEGS slot is active, otherwise hide it
                    this.setBoneVisible(this.armorLeggingTorsoBone, currentSlot == EquipmentSlot.LEGS);
                }
            }

            @Override
            public void applyBaseTransformations(HumanoidModel<?> baseModel) {
                super.applyBaseTransformations(baseModel);

                if (this.armorLeggingTorsoBone != null) {
                    ModelPart modelPart = baseModel.body;
                    RenderUtils.matchModelPartRot(modelPart, this.armorLeggingTorsoBone);
                    this.armorLeggingTorsoBone.updatePosition(modelPart.x, -modelPart.y, modelPart.z);
                }
            }
        };
    }
}
