package net.kamaarion.catsr.entity.render.armor;

import mod.azure.azurelib.render.armor.AzArmorRenderer;
import mod.azure.azurelib.render.armor.AzArmorRendererConfig;
import net.kamaarion.catsr.CATSR;
import net.minecraft.resources.ResourceLocation;

public class RemnantPaladinArmorRenderer extends AzArmorRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            CATSR.MODID,
            "geo/item/armor/remnant_paladin_armor.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            CATSR.MODID,
            "textures/item/armor/remnant_paladin_armor.png"
    );

    public RemnantPaladinArmorRenderer() {
        super(
                AzArmorRendererConfig.builder(GEO, TEX)
                        .setPipelineContext(AzArmorLeggingTorsoLayerPipeline::new)
                        .build()
        );
    }
}