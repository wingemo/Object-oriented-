Client client = new Client();
Person person = client.receivePerson();
System.out.println("Received person: " + person);
client.close();

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Sender {
  public static void main(String[] args) {
    Socket socket = new Socket("localhost", 8000);
    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
    Person person = new Person("John", "Smith");
    oos.writeObject(person);
    oos.close();
    socket.close();
    
  }
}
