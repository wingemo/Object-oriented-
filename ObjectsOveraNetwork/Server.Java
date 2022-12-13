import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A simple server class that listens for incoming connections on port,
 * writes serialized {@link Person} objects to the connected client.
 *
 * @Philip Wingemo
 */
public class Server {
  /**
   * The `ServerSocket` used to listen for incoming connections on a specified port.
   */
  private ServerSocket serverSocket;
  
  /**
   * The `Socket` representing the connection to the client.
   */
  private Socket socket;
  
  /**
   * The `ObjectInputStream` used to receive objects from the client.
   */
  private ObjectInputStream ois;
  
  /**
   * The `ObjectOutputStream` used to send objects to the client.
   */
  private ObjectOutputStream oos;

  /**
   * Creates a new Server instance.
   *
   * @param config a Properties object containing the port to use for the server
   * @throws IOException if an error occurs while creating the server socket
   */
  public Server(Properties config) throws IOException {
    this.serverSocket = new ServerSocket(config.getProperty("port"));
    this.socket = serverSocket.accept();
    this.ois = new ObjectInputStream(socket.getInputStream());
    this.oos = new ObjectOutputStream(socket.getOutputStream());
  }

 /**
  * Sends a `Person` object to the client.
  *
  * @param person the `Person` object to be sent
  * @throws IOException if an I/O error occurs while sending the object
  */
  public void sendPerson(Person person) throws IOException {
    oos.writeObject(person);
  }

  
 /**
  * Closes the input and output streams and the `Socket` and `ServerSocket` used by this `Server`.
  *
  * @throws IOException if an I/O error occurs while closing the streams or sockets
  */
  public void close() throws IOException {
    ois.close();
    oos.close();
    socket.close();
    serverSocket.close();
  }
}
