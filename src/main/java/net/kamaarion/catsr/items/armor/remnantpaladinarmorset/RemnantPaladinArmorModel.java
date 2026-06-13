package net.kamaarion.catsr.items.armor.remnantpaladinarmorset;

import net.kamaarion.catsr.CATSR;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RemnantPaladinArmorModel extends GeoModel<RemnantPaladinArmorItem> {

    public RemnantPaladinArmorModel() {
    }

    @Override
    public ResourceLocation getModelResource(RemnantPaladinArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(CATSR.MODID, "geo/item/armor/remnant_paladin_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RemnantPaladinArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(CATSR.MODID, "textures/item/armor/remnant_paladin_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RemnantPaladinArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CATSR.MODID, "animations/remnant_paladin_armor.animation.json");
    }
}