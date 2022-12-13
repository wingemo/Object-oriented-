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
    Properties prop = readConfig("/path/to/config/file");
    Bank bank = new Bank(prop);
    bank.runTransactions();
  }

  /**
   * Reads the configuration from the specified file.
   *
   * @param configPath the path to the configuration file
   * @return a map containing the key-value pairs from the configuration file
   */
  public static Properties readConfig(String configPath) {

    try (InputStream input = new FileInputStream("config.properties")) {
      Properties prop = new Properties();
      prop.load(input);
      return prop;
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

