package net.kamaarion.catsr;

import com.mojang.logging.LogUtils;
import io.redspace.ironsspellbooks.render.SpellBookCurioRenderer;
import net.kamaarion.catsr.registries.CATSRCreativeTab;
import net.kamaarion.catsr.registries.CATSRItemRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
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
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            CuriosRendererRegistry.register(CATSRItemRegistry.SUNDROWNED_TOME.get(), SpellBookCurioRenderer::new);
        }
    }
    public static ResourceLocation id(@NotNull String path) {
        return ResourceLocation.fromNamespaceAndPath(CATSR.MODID, path);
    }

}
