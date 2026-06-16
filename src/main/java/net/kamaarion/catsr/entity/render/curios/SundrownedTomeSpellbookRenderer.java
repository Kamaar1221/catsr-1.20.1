package net.kamaarion.catsr.entity.render.curios;

import mod.azure.azurelib.render.item.AzItemRenderer;
import mod.azure.azurelib.render.item.AzItemRendererConfig;
import net.kamaarion.catsr.CATSR;
import net.minecraft.resources.ResourceLocation;

public class SundrownedTomeSpellbookRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            CATSR.MODID,
            "geo/sundrowned_tome.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            CATSR.MODID,
            "textures/item/curio/sundrowned_tome.png"
    );

    public SundrownedTomeSpellbookRenderer() {
        super(
                AzItemRendererConfig.builder(GEO, TEX)
                        .build()
        );
    }
}