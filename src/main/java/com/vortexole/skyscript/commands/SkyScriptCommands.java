package com.vortexole.skyscript.commands;

import com.vortexole.skyscript.SkyScript;
import com.vortexole.skyscript.utils.Chat;
import com.google.common.base.CaseFormat;
import lombok.Getter;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.command.*;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.*;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

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

    private enum CommandOption {
        NETHERWART("Netherwart", "I like men!");

        @Getter
        private final String name;
        private final String description;

        CommandOption(String name, String description) {
            this.name = name;
            this.description = description;

    }

    private enum CommandSyntax {
        BASE("/sky"),
        HELP("/sky help");

        @Getter
        private final String syntax;

        CommandSyntax(String syntax) {
            this.syntax = syntax;
        }

        @Override
        public String toString() {
            return syntax;
        }
    }
    private enum SubCommandUsage {
        HELP(CommandSyntax.HELP, "I also like boys!", null);

        private final CommandSyntax syntax;
        private final String description;
        private final List<CommandOption> options;
        SubCommandUsage(CommandSyntax syntax, String descriptionTranslationKey, List<CommandOption> options) {
        this.syntax = syntax;
        this.description = descriptionTranslationKey;
        this.options = options;
    }

    @Override
    public String toString() {
        StringBuilder usageBuilder = new StringBuilder(
                "Usage: §b" + syntax + "§r" +
                        "\n" +
                        "\n§lDescription:" +
                        "\n§7" + Translations.getMessage(description));

}
