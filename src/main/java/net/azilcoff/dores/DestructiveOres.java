package net.azilcoff.dores;

import net.azilcoff.dores.block.ModBlocks;
import net.azilcoff.dores.component.ModDataComponentTypes;
import net.azilcoff.dores.entity.effect.ModStatusEffects;
import net.azilcoff.dores.item.ModItems;
import net.azilcoff.dores.world.gen.ModOreGeneration;
import net.azilcoff.dores.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DestructiveOres implements ModInitializer {
	public static final String MOD_ID = "dores";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModDataComponentTypes.registerDataComponentTypes();
        ModStatusEffects.registerModStatusEffects();
        ModWorldGeneration.generateModWorldGen();
	}
}