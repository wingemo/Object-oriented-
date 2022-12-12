import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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

  public Person receivePerson() throws IOException, ClassNotFoundException {
    return (Person) ois.readObject();
  }

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
