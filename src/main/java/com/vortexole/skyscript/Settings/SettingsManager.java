package com.vortexole.skyscript.settings;

import java.util.ArrayList;

import com.vortexole.skyscript.features.modules.Module;

/**
 *  Made by HeroCode Skidded By Throwing
 *  it's free to use
 *  but you have to credit him
 *
 *  @author HeroCode
 */
public class SettingsManager {

    private static final Logger LOGGER = SkyScript.getLogger();

    private ArrayList<Setting> settings;

    public SettingsManager(){
        this.settings = new ArrayList<Setting>();
    }

    public void rSetting(Setting in){
        this.settings.add(in);
    }

    public ArrayList<Setting> getSettings(){
        return this.settings;
    }

    public ArrayList<Setting> getSettingsByMod(Module mod){
        ArrayList<Setting> out = new ArrayList<Setting>();
        for(Setting s : getSettings()){
            if(s.getParentMod().equals(mod)){
                out.add(s);
            }
        }
        if(out.isEmpty()){
            return null;
        }
        return out;
    }

    public Setting getSettingByName(Module mod, String name){
        for(Setting set : getSettings()){
            if(set.getName().equalsIgnoreCase(name) && set.getParentMod() == mod){
                return set;
            }
        }
        LOGGER.error("[SKYSCRIPT] Error Setting NOT found: '" + name +"'!");
        return null;
    }

}