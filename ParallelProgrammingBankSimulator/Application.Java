/**
 * The main entry point for the application.
 */
public class Application {
  /**
   * Runs the bank simulation.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    Map<String, String> config = readConfig("/path/to/config/file");
    Bank bank = new Bank(config);
    bank.runTransactions();
  }
  
  /**
   * Reads the configuration from the specified file.
   *
   * @param configPath the path to the configuration file
   * @return a map containing the key-value pairs from the configuration file
   */
  public static Map<String, String> readConfig(String configPath) {
    Map<String, String> config = new HashMap<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(configPath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split("=");
        String key = parts[0];
        String value = parts[1];
        config.put(key, value);
      }
    } catch (IOException e) {
      System.err.println("Failed to read config file: " + e.getMessage());
    }
    return config;
  }
}

