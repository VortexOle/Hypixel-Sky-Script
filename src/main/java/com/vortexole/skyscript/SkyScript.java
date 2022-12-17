package com.vortexole.skyscript;

import com.vortexole.skyscript.commands.SkyScriptCommands;
import com.vortexole.skyscript.utils.Chat;
import com.vortexole.skyscript.utils.SkyScriptKeyBinding;
import com.vortexole.skyscript.utils.SkyblockAddonsMessageFactory;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

@Getter
@Mod(modid = "skyscript", name = "SkyScript", version = "1.0")
@SideOnly(Side.CLIENT)

public class SkyScript {

	@Getter
	private static SkyScript instance;

	public SkyScript() {
		instance = this;
	}

	public static final String MOD_ID = "skyscript";
	public static final String MOD_NAME = "SkyScript";
	public static String VERSION = "1.0";

	@Setter
	private boolean devMode;
	private final List<SkyScriptKeyBinding> keyBindings = new LinkedList<>();

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		ClientCommandHandler.instance.registerCommand(new SkyScriptCommands());
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}

	static {
		if (VERSION.contains("@")) { // Debug environment...
			VERSION = "1.0";
		}
	}
	public void registerKeyBindings(List<SkyScriptKeyBinding> keyBindings) {
		for (SkyScriptKeyBinding keybinding : keyBindings) {
			keybinding.register();
		}
	}

	public static Logger getLogger() {
		String fullClassName = new Throwable().getStackTrace()[1].getClassName();
		String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);

		return LogManager.getLogger(fullClassName, new SkyblockAddonsMessageFactory(simpleClassName));
	}
}


