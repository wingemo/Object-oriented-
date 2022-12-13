/**
 * This program demonstrates how to send and receive 
 * objects over a network using Java.
 *
 * @author Philip Wingemo
 */
public class Application {
  /**
   * The entry point of the application.
   *
   * @param args command-line arguments
   * @throws IOException if an error occurs while reading the configuration file
   */
  public static void main(String[] args) throws IOException {
    // Read the configuration file
    public static final String CONFIG_PATH = "config.properties";
    Properties config = readConfig(configPath);

    // Create a new server and client
    Server server = new Server(config);
    Client client = new Client(config);

    // Create a new person and send it from the server to the client
    Person personToSend = new Person("John Doe");
    server.sendPerson(personToSend);
    Person person = client.receivePerson();
    System.out.println(config.getProperty("ReceivedPersonMessage") + person);

    // Close the client and server connections
    client.close();
    server.close();
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
