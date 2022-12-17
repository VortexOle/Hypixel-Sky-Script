package com.vortexole.skyscript;

import com.vortexole.skyscript.commands.SkyScriptCommands;
import com.vortexole.skyscript.utils.Chat;
import lombok.Getter;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Getter
@Mod(modid = "skyscript", name = "SkyScript", version = "1.0")

public class SkyScript {

	@Getter
	private static SkyScript instance;

	public SkyScript() {
		instance = this;
	}

	public static final String MOD_ID = "skyscript";
	public static String VERSION = "1.0";

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		ClientCommandHandler.instance.registerCommand(new SkyScriptCommands());
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}

	static {
		if (VERSION.contains("@")) { // Debug environment...
			VERSION = "1.0";
		}
	}
}


