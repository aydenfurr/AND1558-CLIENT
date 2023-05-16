package uk.to.and1558.Mods;

import uk.to.and1558.Gui.HUD.ScreenPosition;
import uk.to.and1558.Mods.ModLoader.ModDraggable;

import java.awt.*;

public class HP extends ModDraggable {
    @Override
    public int getWidth() {
        return font.getStringWidth("HP: 20/20");
    }
    boolean veryLow = false;
    @Override
    public int getHeight() {
        return font.FONT_HEIGHT;
    }

    @Override
    public void render(ScreenPosition pos) {
        if(this.mc.thePlayer != null) {
            if (this.mc.thePlayer.getHealth() >= 15)
                font.drawStringWithShadow("HP: " + (int) this.mc.thePlayer.getHealth() + "/" + (int) this.mc.thePlayer.getMaxHealth(), pos.getAbsoluteX(), pos.getAbsoluteY(), Color.GREEN.getRGB());
            else if (this.mc.thePlayer.getHealth() <= 5)
                font.drawStringWithShadow("HP: " + (int) this.mc.thePlayer.getHealth() + "/" + (int) this.mc.thePlayer.getMaxHealth(), pos.getAbsoluteX(), pos.getAbsoluteY(), Color.RED.getRGB());
            else if (this.mc.thePlayer.getHealth() <= 15)
                font.drawStringWithShadow("HP: " + (int) this.mc.thePlayer.getHealth() + "/" + (int) this.mc.thePlayer.getMaxHealth(), pos.getAbsoluteX(), pos.getAbsoluteY(), Color.YELLOW.getRGB());
            else
                font.drawStringWithShadow("HP: " + (int) this.mc.thePlayer.getHealth() + "/" + (int) this.mc.thePlayer.getMaxHealth(), pos.getAbsoluteX(), pos.getAbsoluteY(), Color.YELLOW.getRGB());
        }
    }
}