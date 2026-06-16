package net.kamaarion.catsr.entity.render.curios;

import mod.azure.azurelib.render.item.AzItemRenderer;
import mod.azure.azurelib.render.item.AzItemRendererConfig;
import net.kamaarion.catsr.CATSR;
import net.minecraft.resources.ResourceLocation;

public class MonstrousManualSpellbookRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            CATSR.MODID,
            "geo/monstrous_manual.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            CATSR.MODID,
            "textures/item/curio/monstrous_manual.png"
    );

    public MonstrousManualSpellbookRenderer() {
        super(
                AzItemRendererConfig.builder(GEO, TEX)
                        .build()
        );
    }
}