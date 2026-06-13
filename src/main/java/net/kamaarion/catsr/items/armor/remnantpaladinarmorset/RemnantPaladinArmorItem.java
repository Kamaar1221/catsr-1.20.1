package net.kamaarion.catsr.items.armor.remnantpaladinarmorset;

import io.redspace.ironsspellbooks.item.armor.ImbuableChestplateArmorItem;
import net.kamaarion.catsr.items.armor.CATSRArmorMaterials;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class RemnantPaladinArmorItem extends ImbuableChestplateArmorItem {

    public RemnantPaladinArmorItem(Type type, Properties settings) {
        super(CATSRArmorMaterials.REMNANT_PALADIN_ARMOR, type, settings, withManaAndSpellPowerAttribute(125, 0.05));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new RemnantPaladinArmorRenderer();
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private RemnantPaladinArmorRenderer renderer;

            @Override
            public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (this.renderer == null) {
                    this.renderer = new RemnantPaladinArmorRenderer();
                }

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (pLevel != null && pLevel.isClientSide()) {
            Font font = Minecraft.getInstance().font;
            int maxTooltipWidth = 240;

            Component loreText = Component.translatable("item.roacw.auric_tesla_cuirass.desc").withStyle(ChatFormatting.GOLD);
            font.getSplitter().splitLines(loreText, maxTooltipWidth, loreText.getStyle()).forEach(formattedText -> {
                pTooltipComponents.add(Component.literal(formattedText.getString()).withStyle(loreText.getStyle()));
            });

            pTooltipComponents.add(Component.empty());

            Component tooltipText = Component.translatable("item.roacw.auric_tesla_cuirass.tooltip1").withStyle(ChatFormatting.GRAY);
            font.getSplitter().splitLines(tooltipText, maxTooltipWidth, tooltipText.getStyle()).forEach(formattedText -> {
                pTooltipComponents.add(Component.literal(formattedText.getString()).withStyle(tooltipText.getStyle()));
            });

            pTooltipComponents.add(Component.empty());

            Component setBonusText = Component.translatable("item.roacw.auric_tesla_cuirass.tooltip2").withStyle(ChatFormatting.GRAY);
            font.getSplitter().splitLines(setBonusText, maxTooltipWidth, setBonusText.getStyle()).forEach(formattedText -> {
                pTooltipComponents.add(Component.literal(formattedText.getString()).withStyle(setBonusText.getStyle()));
            });
        } else {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }
}
