package inventory.viewer.hud;

import inventory.viewer.InventoryViewer;
import inventory.viewer.command.InventoryToggleCommand;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

public class InventoryHUDElement implements HudElement {
    @Override
    public void render(GuiGraphics graphics, DeltaTracker tickCounter) {
        if(!InventoryToggleCommand.isToggled) {
            return;
        }
        LocalPlayer mcPlayer = InventoryViewer.mc.player;
        Inventory playerInventory = mcPlayer.getInventory();
        Identifier inventoryBackgroundIdentifier = Identifier.fromNamespaceAndPath(InventoryViewer.MOD_ID, "textures/gui/inventory.png");
        graphics.blit(RenderPipelines.GUI_TEXTURED, inventoryBackgroundIdentifier, 90, 90, 0, 0, 167, 59, 167, 59); //graphics.blit(constDefByGameEng, x,y, posSkipU, posSkipV, borderWidth, borderHeight, textureWidth, textureHeight);
        for(int i = 9; i < Inventory.INVENTORY_SIZE;i++) {
            ItemStack itemObj = playerInventory.getItem(i);
            int index = i - 9;
            int col = index % 9;
            int row = index / 9;
            int x = 94 + (col * 18);
            int y = 94 + (row * 18);
            // System.out.println("X: " + x + ", Y: " + y);
            graphics.renderItem(itemObj, x, y);
            graphics.renderItemDecorations(InventoryViewer.mc.font, itemObj, x, y);

        }
    }
}
