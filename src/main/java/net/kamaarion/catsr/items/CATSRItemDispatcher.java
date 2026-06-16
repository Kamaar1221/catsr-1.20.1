package net.kamaarion.catsr.items;

import mod.azure.azurelib.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.animation.play_behavior.AzPlayBehaviors;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class CATSRItemDispatcher {
    private static final AzCommand EQUIP_COMMAND = AzCommand.create(
            "base_controller",
            "equipping",
            AzPlayBehaviors.PLAY_ONCE
    );

    private static final AzCommand IDLE_COMMAND = AzCommand.create(
            "base_controller",
            "idle",
            AzPlayBehaviors.LOOP
    );

    private static final AzCommand CASTING_SPELL_COMMAND = AzCommand.create(
            "base_controller",
            "casting",
            AzPlayBehaviors.LOOP
    );

    public void equip(Entity entity, ItemStack itemStack) {
        EQUIP_COMMAND.sendForItem(entity, itemStack);
    }

    public void idle(Entity entity, ItemStack itemStack) {
        IDLE_COMMAND.sendForItem(entity, itemStack);
    }

    public void casting(Entity entity, ItemStack itemStack) {
        CASTING_SPELL_COMMAND.sendForItem(entity, itemStack);
    }
}
