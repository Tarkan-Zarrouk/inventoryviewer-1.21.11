package inventory.viewer.command;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;

public class InventoryToggleCommand {
    public static boolean isToggled = false;
    public static void init() {
        ClientCommandRegistrationCallback.EVENT.register((dispatch, __) -> {
            dispatch.register(ClientCommandManager.literal("toggleHudViewer").executes(ctx -> {
                isToggled = !isToggled;
                return 1;
            }));
        });
    }
}
