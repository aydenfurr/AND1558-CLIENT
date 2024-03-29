package owo.aydendevy.Mods;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetworkPlayerInfo;
import owo.aydendevy.Gui.HUD.ScreenPosition;
import owo.aydendevy.Mods.ModLoader.ModDraggable;
import owo.aydendevy.DevyClient;

public class ModPing extends ModDraggable {
	DevyClient client = DevyClient.getInstance();
	public String Ping = "0";
	@Override
	public int getWidth() {
		return font.getStringWidth("Ping: error");
	}
	@Override
	public int getHeight() {
		return font.FONT_HEIGHT;
	}
	@Override
	public void render(ScreenPosition pos) {
		if (this.mc.theWorld != null && !this.mc.theWorld.isRemote) {
			return;
		}
		if(this.mc.gameSettings.showDebugInfo){
			return;
		}
		EntityPlayerSP thePlayer = this.mc.thePlayer;

		if(!this.mc.isSingleplayer()) {
			if (thePlayer != null) {
				NetworkPlayerInfo playerInfo = this.mc.getNetHandler().getPlayerInfo(this.mc.thePlayer.getUniqueID());
				String string = "Ping: " + (playerInfo == null ? "error" : playerInfo.getResponseTime() + "ms (Not RealTime)");;
				if(string.equals("Ping: 0ms (Not RealTime)")) {
					string = "Ping: 243ms (Uncalculated)";
				}
				font.drawStringWithShadow(string, pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
			}
		}else {
			font.drawStringWithShadow("Ping: -1ms (RealTime)", pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
		}
	}
	@Override
	public void renderDummy(ScreenPosition pos) {
		// TODO Auto-generated method stub
		font.drawStringWithShadow("Ping: (Edit Mode)", pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
	}
}