package com.vortexole.skyscript.utils;

import com.vortexole.skyscript.utils.Chat;

import com.google.common.collect.Sets;
import com.vortexole.skyscript.SkyScript;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.EnumChatFormatting;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.Loader;

import java.util.Set;
import java.util.regex.Pattern;

@Getter
@Setter
public class Utils {

    private boolean onSkyblock;

    private static final SkyScript main = SkyScript.getInstance();

    private static final Logger logger = SkyScript.getLogger();

    private static final Set<String> SKYBLOCK_IN_ALL_LANGUAGES = Sets.newHashSet("SKYBLOCK", "\u7A7A\u5C9B\u751F\u5B58", "\u7A7A\u5CF6\u751F\u5B58");

    public void sendErrorMessage(String errorText) {
        Chat.addToChat(errorText, EnumChatFormatting.GREEN);
    }

    public File getSRCFolder() {
        return Loader.instance().activeModContainer().getSource().getParentFile();
}
