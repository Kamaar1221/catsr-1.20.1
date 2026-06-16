package net.kamaarion.catsr.registries;

import net.kamaarion.catsr.CATSR;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CATSRCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CATSR.MODID);

    public static final RegistryObject<CreativeModeTab> CATSR_EQUIPMENT = CREATIVE_MODE_TAB.register("catsr_equipment",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(CATSRItemRegistry.REMNANT_PALADIN_HELMET.get()))
                    .title(Component.translatable("creativetab.roacw.equipment"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(CATSRItemRegistry.REMNANT_PALADIN_HELMET.get());
                        output.accept(CATSRItemRegistry.REMNANT_PALADIN_CHESTPLATE.get());
                        output.accept(CATSRItemRegistry.REMNANT_PALADIN_LEGGINGS.get());
                        output.accept(CATSRItemRegistry.REMNANT_PALADIN_BOOTS.get());
                        output.accept(CATSRItemRegistry.SUNDROWNED_TOME.get());
                        output.accept(CATSRItemRegistry.MONSTROUS_MANUAL.get());
                        output.accept(CATSRItemRegistry.MAGMA_ATLATL.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
