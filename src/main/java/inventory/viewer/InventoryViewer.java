package inventory.viewer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import inventory.viewer.command.InventoryToggleCommand;
import inventory.viewer.configuration.ConfigurationManager;
import inventory.viewer.hud.InventoryHUDElement;
public class InventoryViewer implements ModInitializer, ClientModInitializer {
	public static final String MOD_ID = "inventoryviewer";
	public static Minecraft mc = Minecraft.getInstance();
	public static final Identifier HUD_ELEMENT_IDENTIFIER = id(MOD_ID);
	public static final File resourceLocation = mc.gameDirectory;
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitialize() {
		load();
	}
	public static void load() {
		LOGGER.info("Loading InventoryViewer for 1.21.11\n\n");
		InventoryToggleCommand.init();
		ConfigurationManager.init();
	}
	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	@Override
	public void onInitializeClient() {
		HudElementRegistry.addLast(HUD_ELEMENT_IDENTIFIER, new InventoryHUDElement());
	}
}
