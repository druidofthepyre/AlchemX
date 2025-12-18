package net.druidofthepyre.alchemx;

import net.druidofthepyre.alchemx.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlchemX implements ModInitializer {
	public static final String MOD_ID = "alchemx";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}