package com.vortexole.skyscript.commands;

import com.vortexole.skyscript.SkyScript;
import com.vortexole.skyscript.utils.Chat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.EnumChatFormatting;

import java.util.Collections;
import java.util.List;

public class SkyScriptCommands extends CommandBase {

    private static final String[] SUBCOMMANDS = {"help", "netherwart"};

    @Override
    public String getCommandName() {
        return "skyscript";
    }

    public int getRequiredPermissionLevel() {
        return 0;
    }

    public List<String> getCommandAliases() {
        return Collections.singletonList("sky");
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/sky ";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        Chat.addToChat("Was geht bruda", EnumChatFormatting.GREEN);
    }

}