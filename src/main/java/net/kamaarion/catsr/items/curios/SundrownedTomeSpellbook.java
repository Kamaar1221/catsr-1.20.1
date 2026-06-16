package net.kamaarion.catsr.items.curios;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.SpellBook;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

public class SundrownedTomeSpellbook extends SpellBook {
    public SundrownedTomeSpellbook(Properties rarity) {
        super(12, ItemPropertiesHelper.equipment().fireResistant().stacksTo(1));
        withSpellbookAttributes(
                new AttributeContainer(AttributeRegistry.MAX_MANA, 300, AttributeModifier.Operation.ADDITION),
                new AttributeContainer(AttributeRegistry.HOLY_SPELL_POWER, 0.30F, AttributeModifier.Operation.MULTIPLY_BASE)
        );
    }
}