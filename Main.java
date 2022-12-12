Client client = new Client();
Person person = client.receivePerson();
System.out.println("Received person: " + person);
client.close();

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Sender {
  public static void main(String[] args) {
   
  }
}
