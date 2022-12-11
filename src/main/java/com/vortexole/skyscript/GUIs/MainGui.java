package com.vortexole.skyscript.GUIs;

import net.minecraft.client.gui.GuiScreen;

public class MainGui extends GuiScreen{
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		fontRendererObj.drawString("Menu", width / 2 - 100, height / 2 - 100, 16777215);
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
}
