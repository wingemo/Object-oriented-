import org.junit.Test;
import static org.junit.Assert.*;

public class ClientTest {
  @Test
  public void testClientReceivePerson() throws IOException, ClassNotFoundException {
    // Create a test `Properties` object with the necessary configuration
    Properties config = new Properties();
    config.setProperty("host", "localhost");
    config.setProperty("port", "9090");
    config.setProperty("taxRate", "0.25");

    // Create a mock `Logger` object
    Logger logger = mock(Logger.class);

    // Create a new `Client` instance
    Client client = new Client(config, logger);

    // Use the `receivePerson` method to receive a `Person` object from the server
    Person person = client.receivePerson();

    // Assert that the person's income has been modified by the tax rate
    assertEquals(0.25 * person.getIncome(), person.getNetIncome(), 0.001);
  }
}
