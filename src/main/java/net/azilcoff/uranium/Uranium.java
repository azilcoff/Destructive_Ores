package net.azilcoff.uranium;

import net.azilcoff.uranium.block.ModBlocks;
import net.azilcoff.uranium.component.ModDataComponentTypes;
import net.azilcoff.uranium.entity.effect.ModStatusEffects;
import net.azilcoff.uranium.item.ModItems;
import net.azilcoff.uranium.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Uranium implements ModInitializer {
	public static final String MOD_ID = "uranium";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModDataComponentTypes.registerDataComponentTypes();
        ModStatusEffects.registerModStatusEffects();
        ModWorldGeneration.generateModWorldGen();

        ServerEntityEvents.EQUIPMENT_CHANGE.register((serverEntity, equipmentSlot, previousStack, newStack) -> {
            if (newStack.isOf(ModItems.URANIUM) && serverEntity.getStatusEffects().stream().noneMatch(statusEffectInstance -> statusEffectInstance.getEffectType() == ModStatusEffects.HIGH_RADIATION.value())){
                serverEntity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.HIGH_RADIATION, 160));
            }
        });
	}
}