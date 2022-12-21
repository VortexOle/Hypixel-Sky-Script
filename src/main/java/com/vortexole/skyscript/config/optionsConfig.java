package com.vortexole.skyscript.config;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors
import com.vortexole.skyscript.SkyScript;

public class WriteToFile {

  private static final Logger LOGGER = SkyScript.getLogger();

  public static void main(String[] args) {
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
}
