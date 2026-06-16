package net.kamaarion.catsr.items.armor;

import net.minecraft.world.item.ItemStack;

public class RemnantPaladinArmorItem extends ImbuableCataclysmArmor {
    public RemnantPaladinArmorItem(Type slot, Properties settings) {
        super(CATSRArmorMaterials.REMNANT_PALADIN_ARMOR, slot, settings);
    }

    // Durability
    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }
}
