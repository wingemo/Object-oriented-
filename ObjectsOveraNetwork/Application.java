/**
 * This program demonstrates how to send and receive 
 * objects over a network using Java
 *
 * @Philip Wingemo
 */
public class Application {
  /**
   * The entry point of the application.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    // Create a new server and client
    Server server = new Server();
    Client client = new Client();
    
    // Create a new person and send it from the server to the client
    Person personToSend = new Person("John Doe");
    server.sendPerson(personToSend);
    Person person = client.receivePerson();
    System.out.println("Received person: " + person);
    
    // Close the client and server connections
    client.close();
    server.close();
  }
}

