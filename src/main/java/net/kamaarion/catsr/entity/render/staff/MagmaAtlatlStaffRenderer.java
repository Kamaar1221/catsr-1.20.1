package net.kamaarion.catsr.entity.render.staff;

import mod.azure.azurelib.render.item.AzItemRenderer;
import mod.azure.azurelib.render.item.AzItemRendererConfig;
import mod.azure.azurelib.render.layer.AzAutoGlowingLayer;
import net.kamaarion.catsr.CATSR;
import net.minecraft.resources.ResourceLocation;

public class MagmaAtlatlStaffRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            CATSR.MODID,
            "geo/magma_atlatl.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            CATSR.MODID,
            "textures/item/staff/magma_atlatl.png"
    );

    public MagmaAtlatlStaffRenderer() {
        super(
                AzItemRendererConfig.builder(GEO, TEX)
                        .addRenderLayer(new AzAutoGlowingLayer<>())
                        .build()
        );
    }
}