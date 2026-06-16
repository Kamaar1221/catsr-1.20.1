package net.kamaarion.catsr;

import com.mojang.logging.LogUtils;
import io.redspace.ironsspellbooks.item.SpellBook;
import io.redspace.ironsspellbooks.render.SpellBookCurioRenderer;
import mod.azure.azurelib.render.armor.AzArmorRendererRegistry;
import mod.azure.azurelib.render.item.AzItemRendererRegistry;
import net.kamaarion.catsr.entity.render.armor.RemnantPaladinArmorRenderer;
import net.kamaarion.catsr.entity.render.curios.MonstrousManualSpellbookRenderer;
import net.kamaarion.catsr.entity.render.curios.SundrownedTomeSpellbookRenderer;
import net.kamaarion.catsr.entity.render.staff.MagmaAtlatlStaffRenderer;
import net.kamaarion.catsr.registries.CATSRCreativeTab;
import net.kamaarion.catsr.registries.CATSRItemRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod(CATSR.MODID)
public class CATSR {

    public static final String MODID = "catsr";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CATSR() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CATSRItemRegistry.register(modEventBus);
        CATSRCreativeTab.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        // Rendering armor
        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.AddLayers event)
        {
            //GeoArmorRenderer.registerArmorRenderer(IgnisWizardArmorItem.class, () -> new GenericCustomArmorRenderer(new IgnisWizardArmorModel()));
        }

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // curios
            event.enqueueWork(() -> {
                CATSRItemRegistry.getCATSRItems().stream().filter(item -> item.get() instanceof SpellBook).forEach((item) -> CuriosRendererRegistry.register(item.get(), SpellBookCurioRenderer::new));
            });


            // Armor Rendering Registry
            AzArmorRendererRegistry.register(RemnantPaladinArmorRenderer::new,
                    CATSRItemRegistry.REMNANT_PALADIN_HELMET.get(),
                    CATSRItemRegistry.REMNANT_PALADIN_CHESTPLATE.get(),
                    CATSRItemRegistry.REMNANT_PALADIN_LEGGINGS.get(),
                    CATSRItemRegistry.REMNANT_PALADIN_BOOTS.get());

            AzItemRendererRegistry.register(SundrownedTomeSpellbookRenderer::new, CATSRItemRegistry.SUNDROWNED_TOME.get());
            AzItemRendererRegistry.register(MonstrousManualSpellbookRenderer::new, CATSRItemRegistry.MONSTROUS_MANUAL.get());

            AzItemRendererRegistry.register(MagmaAtlatlStaffRenderer::new, CATSRItemRegistry.MAGMA_ATLATL.get());
        }
    }

    public static ResourceLocation id(@NotNull String path) {
        return ResourceLocation.fromNamespaceAndPath(CATSR.MODID, path);
    }

}
