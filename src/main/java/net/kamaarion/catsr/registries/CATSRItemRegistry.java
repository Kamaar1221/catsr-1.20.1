package net.kamaarion.catsr.registries;

import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.kamaarion.catsr.CATSR;
import net.kamaarion.catsr.items.armor.RemnantPaladinArmorItem;
import net.kamaarion.catsr.items.curios.MonstrousManualSpellbook;
import net.kamaarion.catsr.items.curios.SundrownedTomeSpellbook;
import net.kamaarion.catsr.items.staff.MagmaAtlatlStaff;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;

public class CATSRItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CATSR.MODID);

    // Armor Sets
    public static final RegistryObject<Item> REMNANT_PALADIN_HELMET = ITEMS.register("remnant_paladin_helmet", () -> new RemnantPaladinArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).fireResistant()));
    public static final RegistryObject<Item> REMNANT_PALADIN_CHESTPLATE = ITEMS.register("remnant_paladin_chestplate", () -> new RemnantPaladinArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).fireResistant()));
    public static final RegistryObject<Item> REMNANT_PALADIN_LEGGINGS = ITEMS.register("remnant_paladin_leggings", () -> new RemnantPaladinArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).fireResistant()));
    public static final RegistryObject<Item> REMNANT_PALADIN_BOOTS = ITEMS.register("remnant_paladin_boots", () -> new RemnantPaladinArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).fireResistant()));

    // Spellbooks
    public static final RegistryObject<Item> SUNDROWNED_TOME = ITEMS.register("sundrowned_tome", () -> new SundrownedTomeSpellbook(new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> MONSTROUS_MANUAL = ITEMS.register("monstrous_manual", () -> new MonstrousManualSpellbook(new Item.Properties().rarity(Rarity.EPIC)));

    //Staffs
    public static final RegistryObject<Item> MAGMA_ATLATL = ITEMS.register
            ("magma_atlatl", MagmaAtlatlStaff::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static Collection<RegistryObject<Item>> getCATSRItems() {
        return ITEMS.getEntries();
    }
}

