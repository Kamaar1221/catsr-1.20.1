package net.kamaarion.catsr.items.armor;

import io.redspace.ironsspellbooks.api.spells.IPresetSpellContainer;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import net.minecraft.world.item.ItemStack;

import java.lang.reflect.Type;
import java.util.Properties;

public class ImbuableCataclysmArmor extends CATSRArmorItem implements IPresetSpellContainer {
    public ImbuableCataclysmArmor(CATSRArmorMaterials materialIn, Type slot, Properties settings) {
        super(materialIn, slot, settings);
    }

    @Override
    public void initializeSpellContainer(ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }

        if (itemStack.getItem() instanceof CATSRArmorItem armorItem)
        {
            if (armorItem.getType() == Type.CHESTPLATE || armorItem.getType() == Type.HELMET)
            {
                if (!ISpellContainer.isSpellContainer(itemStack)) {
                    var spellContainer = ISpellContainer.create(1, true, true);
                    spellContainer.save(itemStack);
                }
            }
        }
    }
}
