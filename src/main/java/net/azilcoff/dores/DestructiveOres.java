package net.azilcoff.dores;

import net.azilcoff.dores.component.ModDataComponentTypes;
import net.azilcoff.dores.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DestructiveOres implements ModInitializer {
	public static final String MOD_ID = "dores";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();
        ModDataComponentTypes.registerDataComponentTypes();
	}
}