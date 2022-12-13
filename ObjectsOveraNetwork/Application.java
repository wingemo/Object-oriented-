package com.wingemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This program demonstrates how to send and receive 
 * objects over a network using Java.
 *
 * @author Philip Wingemo
 */
public class Application {
  /**
   * Represents the path to the configuration properties file.
   */
  public static final String CONFIG_PATH = "src/com/wingemo/config.properties";

  /**
   * The entry point of the application.
   *
   * @param args command-line arguments
   * @throws IOException if an error occurs while reading the configuration file
   */
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    Properties config = readConfig(CONFIG_PATH);
    executorService.submit(new Server(config));
    executorService.submit(new Client(config));
  }

  /**
   * Reads the configuration properties from the specified file.
   * 
   * @param configPath the path to the configuration file
   * @return a {@code Properties} object containing the configuration properties
   * @throws IOException if an error occurs while reading the file
   */
  public static Properties readConfig(String configPath) throws IOException {
    try (InputStream input = new FileInputStream(configPath)) {
      Properties prop = new Properties();
      prop.load(input);
      return prop;
    }
  }
}
