package net.kamaarion.catsr.items.curios.sundrowned_tome;

import net.kamaarion.catsr.CATSR;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SundrownedTomeModel extends GeoModel<SundrownedTome> {

  public SundrownedTomeModel() {
  }

  @Override
  public ResourceLocation getModelResource(SundrownedTome object) {
    return ResourceLocation.fromNamespaceAndPath(CATSR.MODID, "geo/item/curio/sundrowned_tome.geo.json");
  }

  @Override
  public ResourceLocation getTextureResource(SundrownedTome object) {
    return ResourceLocation.fromNamespaceAndPath(CATSR.MODID, "textures/item/curio/sundrowned_tome.png");
  }


  @Override
  public ResourceLocation getAnimationResource(SundrownedTome animatable) {
    return ResourceLocation.fromNamespaceAndPath(CATSR.MODID, "animations/remnant_paladin_armor.animation.json");
  }
}
