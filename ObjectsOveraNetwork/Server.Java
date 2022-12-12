import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A simple server class that listens for incoming connections on port 8000,
 * reads and writes serialized {@link Person} objects to and from the connected
 * client.
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
   * Creates a new `Server` instance that listens for incoming connections on port 8000,
   * and creates input and output streams for sending and receiving objects.
   *
   * @throws IOException if an I/O error occurs while creating the `ServerSocket` or the streams
   */
  public Server() throws IOException {
    this.serverSocket = new ServerSocket(8000);
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
