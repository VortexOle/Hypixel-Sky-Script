package com.vortexole.skyscript.utils;

import com.vortexole.skyscript.SkyScript;
import lombok.Getter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

import static com.vortexole.skyscript.SkyScript.MOD_NAME;

/*
Pretty much also just everything biscuits work
 */


@Getter
public class SkyScriptKeyBinding {
    private static final Logger LOGGER = SkyScript.getLogger();

    private final KeyBinding keyBinding;
    private final String name;
    private final int defaultKeyCode;
    private final String translationKey;
    private boolean registered = false;
    private boolean isFirstRegistration = true;
    private int previousKeyCode = 999;

    public SkyScriptKeyBinding(String name, int defaultKey, String translationKey) {
        this.name = name;
        this.defaultKeyCode = defaultKey;
        this.translationKey = translationKey;
        keyBinding = new KeyBinding("key.skyscript." + this.getName(), this.getDefaultKeyCode(), MOD_NAME);

    }

    /**
     * Returns the current key code for this key binding.
     *
     * @return the current key code for this key binding
     */
    public int getKeyCode() {
        return keyBinding.getKeyCode();
    }

    /**
     * Returns true if the key is pressed (used for continuous querying). Should be used in tickers.
     * JavaDoc is from linked method.
     *
     * @see KeyBinding#isKeyDown()
     */
    public boolean isKeyDown() {
        if (registered) {
            return keyBinding.isKeyDown();
        } else {
            return false;
        }
    }

    /**
     * Returns true on the initial key press. For continuous querying use {@link this#isKeyDown()}. Should be used in key
     * events.
     * JavaDoc is from linked method.
     *
     * @see KeyBinding#isPressed()
     */
    public boolean isPressed() {
        if (registered) {
            return keyBinding.isPressed();
        } else {
            return false;
        }
    }

    /**
     * Adds this keybinding to {@link Minecraft#gameSettings}. If the key binding is not being registered for the first
     * time, its previous keycode setting from before its last de-registration is restored.
     */
    public void register() {
        if (registered) {
            LOGGER.error("Tried to register a key binding with the name \"" + name + "\" which is already registered.");
            return;
        }

        ClientRegistry.registerKeyBinding(keyBinding);

        if (isFirstRegistration) {
            isFirstRegistration = false;
        } else if (previousKeyCode < Keyboard.KEYBOARD_SIZE) {
            keyBinding.setKeyCode(defaultKeyCode);
            KeyBinding.resetKeyBindingArrayAndHash();
        }
        registered = true;
    }
    public void deRegister() {
        if (registered) {
            int index = ArrayUtils.indexOf(Minecraft.getMinecraft().gameSettings.keyBindings, keyBinding);

            if (index == ArrayUtils.INDEX_NOT_FOUND) {
                LOGGER.error("Keybinding was registered but no longer exists in the registry. Something else must have removed it." +
                        " This shouldn't happen T.T");
                registered = false;
                return;
            }

            Minecraft.getMinecraft().gameSettings.keyBindings = ArrayUtils.remove(Minecraft.getMinecraft().gameSettings.keyBindings, index);

            /*
            The key binding still exists in the internal list even though it's removed from the settings menu.
            We have to set its key to KEY_NONE so it does not conflict with other key bindings.
             */
            previousKeyCode = keyBinding.getKeyCode();
            keyBinding.setKeyCode(Keyboard.KEY_NONE);
            KeyBinding.resetKeyBindingArrayAndHash();
            registered = false;
        } else {
            LOGGER.error("Tried to de-register a key binding with the name \"" + name + "\" which wasn't registered.");
        }
    }

}
