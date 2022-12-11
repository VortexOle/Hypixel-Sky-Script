/*
package com.vortexole.skyscript.commands;

import java.util.concurrent.TimeUnit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class Netherwart extends CommandBase {


    public String getCommandName() {
        return "netherwart";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/netherwart";
    }

    @Override
    public void processCommand(ICommandSender EntityPlayer, String[] args) throws CommandException {

        try {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Thank you for using the script."));
            Thread.sleep(1000);
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Script will start in:"));
            Thread.sleep(1000);
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "3"));
            Thread.sleep(1000);
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "2"));
            Thread.sleep(1000);
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "1"));


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

class KeyInputHandler extends InputEvent {

            final GameSettings   gameSettings;
            final KeyBinding   forwardKey;
            final KeyBinding   backwardKey;
            final KeyBinding		rightKey;
            final KeyBinding		leftKey;


            public KeyInputHandler() {

                this.gameSettings = Minecraft.getMinecraft().gameSettings;
                forwardKey = gameSettings.keyBindForward;
                backwardKey = gameSettings.keyBindBack;
                rightKey = gameSettings.keyBindRight;
                leftKey = gameSettings.keyBindLeft;
            }

@SubscribeEvent(priority = EventPriority.HIGHEST)
public void onKeyInput(InputEvent.KeyInputEvent event) {

                KeyBinding.getKeybinds().add("A");
                KeyBinding.getKeybinds().add("S");
                KeyBinding.getKeybinds().add("D");
                KeyBinding.getKeybinds().add("W");
            }
        }

    }

}

*/