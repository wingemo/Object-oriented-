import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {
  private Socket socket;
  private ObjectInputStream ois;

  public Client() {
    this.socket = new Socket("localhost", 8000);
    this.ois = new ObjectInputStream(socket.getInputStream());
  }

  public Person receivePerson() throws IOException, ClassNotFoundException {
    return (Person) ois.readObject();
  }

  public void close() throws IOException {
    ois.close();
    socket.close();
  }
}
