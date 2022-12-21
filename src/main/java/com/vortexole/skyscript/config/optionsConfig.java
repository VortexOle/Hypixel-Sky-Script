package com.vortexole.skyscript.config;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors
import com.vortexole.skyscript.SkyScript;

import static com.vortexole.skyscript.SkyScript.MOD_NAME;

public class WriteToFile {

  private static final Logger LOGGER = SkyScript.getLogger();

  private final FileWriter fileWriter;
  private final String name;
  private boolean registered = false;

  public static void FileWriter(String[] args) {
    try {
      SkyScript main = SkyScript.getInstance();

      FileWriter myWriter = new FileWriter(getSRCFolder + "options.txt");
      myWriter.write("pauseOnLostFocus:false");
      myWriter.close();
      LOGGER.error("[SKYSCRIPT] Successfully wrote to the file.");
    } catch (IOException e) {
      LOGGER.error("[SKYSCRIPT] Couldnt write to file!");
      e.printStackTrace();
    }
  }
  public optionsConfig(String name) {
    this.name = name
    fileWriter = new FileWriter("writer.skyscript" + this.getName(),) MOD_NAME)

  }
  public void register() {
    if(registered) {
      LOGGER.error("Is already registered.");
      return;
    }
  }
}
