package com.vortexole.skyscript.commands;

import com.vortexole.skyscript.SkyScript;
import com.vortexole.skyscript.utils.Chat;
import lombok.Getter;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.EnumChatFormatting;

import java.util.Collections;
import java.util.List;

public class SkyScriptCommands extends CommandBase {

    private final SkyScript main = SkyScript.getInstance();

    private static final String[] SUBCOMMANDS = {"help", "netherwart"};

    //Command Name
    public String getCommandName() {
        return "skyscript";
    }

    //Pemission level
    public int getRequiredPermissionLevel() {
        return 0;
    }

    //Command aliases
    public List<String> getCommandAliases() {
        return Collections.singletonList("sky");
    }

    //Command Usage
    public String getCommandUsage(ICommandSender sender) {
        return "/sky ";
    }

    //What the command does
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        Chat.addToChat("Was geht bruda", EnumChatFormatting.GREEN); //Just to test if its working
    }
}