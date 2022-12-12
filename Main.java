import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Sender {
  public static void main(String[] args) {
    // Create a socket to connect to the server
    Socket socket = new Socket("localhost", 8000);

    // Create an object output stream to send objects through the socket
    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

    // Create an object to send
    Person person = new Person("John", "Smith");

    // Send the object through the socket
    oos.writeObject(person);

    // Close the socket and the object output stream
    oos.close();
    socket.close();
  }
}

// A simple class to represent a person
class Person {
  private String firstName;
  private String lastName;

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
}
