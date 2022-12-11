package com.vortexole.skyscript;

import com.vortexole.skyscript.commands.SkyScriptCommands;
import lombok.Getter;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Getter
@Mod(modid = "skyscript", name = "SkyScript", version = "1.0", clientSideOnly = true)

public class SkyScript {

	public static final String MOD_ID = "skyscript";
	public static final String VERSION = "1.0";

	@Getter private static SkyScript instance;

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
}

