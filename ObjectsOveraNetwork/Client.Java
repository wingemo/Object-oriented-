import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * A Java client that connects to a server at "localhost" on port 8000, receives
 * a {@link Person} object from the server, and closes the connection.
 *
 * @Philip Wingemo
 */
public class Client {
  // The socket for connecting to the server
  private Socket socket;
  // The object input stream for reading the `Person` object from the server
  private ObjectInputStream ois;
  
  private int taxRate;

  /**
   * Constructs a new `Client` and connects to the server.
   */
  public Client(Properties config) {
    this.socket = new Socket(config.getProperty("host"), config.getProperty("port"));
    this.taxRate = config.getProperty("taxRate");
    this.ois = new ObjectInputStream(socket.getInputStream());
  }

  /**
   * Receives a `Person` object from the server.
   *
   * @return the `Person` object received from the server
   * @throws IOException if an I/O error occurs
   * @throws ClassNotFoundException if the class of the serialized object cannot be found
   */
  public double receivePerson() throws IOException, ClassNotFoundException {
    return (Person) ois.readObject();
  }

  /**
   * Closes the connection to the server.
   *
   * @throws IOException if an I/O error occurs
   */
  public void close() throws IOException {
    ois.close();
    socket.close();
  }
}
