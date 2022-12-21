package com.vortexole.skyscript.features.modules;

import java.util.ArrayList;

public class ModuleManager {
    public ArrayList<Module> modules;

    public ModuleManager() {
        (modules = new ArrayList<Module>()).clear();
    }

    public Module getModule(String name) {
        for (Module m : this.modules) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }

    public ArrayList<Module> getModuleList() {
        return this.modules;
    }

    public ArrayList<Module> getModulesInCategory(Category c) {
        ArrayList<Module> mods = new ArrayList<Module>();
        for (Module m : this.modules) {
            if (m.getCategory() == c) {
                mods.add(m);
            }
        }
        return mods;
    }

    public enum Category {
        MACRO;
    }
}