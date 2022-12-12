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
  private ServerSocket serverSocket;
  private Socket socket;
  private ObjectInputStream ois;
  private ObjectOutputStream oos;

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

  public void close() throws IOException {
    ois.close();
    oos.close();
    socket.close();
    serverSocket.close();
  }
}
