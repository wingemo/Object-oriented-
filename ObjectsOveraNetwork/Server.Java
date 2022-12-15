package com.wingemo;

import static java.lang.Integer.parseInt;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

/**
 * A simple server class that listens for incoming connections on port,
 * writes serialized {@link Person} objects to the connected client.
 *
 * @Philip Wingemo
 */
public class Server implements Runnable {
  /**
   * The `ServerSocket` used to listen for incoming connections on a specified port.
   */
  private ServerSocket serverSocket;

  /**
   * The `Socket` representing the connection to the client.
   */
  private Socket socket;

  /**
   * The `ObjectOutputStream` used to send objects to the client.
   */
  private ObjectOutputStream oos;

  private Properties config;

  /**
   * Creates a new Server instance.
   *
   * @param config a Properties object containing the port to use for the server
   * @throws IOException if an error occurs while creating the server socket
   */
  public Server(Properties config) throws IOException {
    this.config = config;
    this.serverSocket = new ServerSocket(parseInt(config.getProperty("port")));
  }

  /**
   * Sends a `Person` object to the client.
   *
   * @param person the `Person` object to be sent
   * @throws IOException if an I/O error occurs while sending the object
   */
  public void sendPerson(Person person) throws IOException {
    this.oos = new ObjectOutputStream(socket.getOutputStream());
    oos.writeObject(person);
  }

  /**
   * Closes the output streams and the `ServerSocket` used by this `Server`.
   *
   * @throws IOException if an I/O error occurs while closing the stream or socket
   */
  public void close() throws IOException {
    oos.close();
    serverSocket.close();
  }

 /**
  * Runs the server socket in a loop and accepts incoming connections.
  * If a connection is established, a new {@link Person} is created using the
  * configuration properties "firstName", "lastName", "income", and "taxRate",
  * and the person is sent using the {@link #sendPerson(Person)} method.
  * If an IOException occurs, it is printed to the standard error output.
 */
 public void run() {
  while (true) {
    try {
      this.socket = serverSocket.accept();
      if (this.socket.isConnected()) {
        Person personToSend = new Person(
          config.getProperty("firstName"),
          config.getProperty("lastName"),
          config.getProperty("income"),
          config.getProperty("taxRate"));
        sendPerson(personToSend);
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Person receivedPerson = (Person) ois.readObject();
        System.out.println(receivedPerson);
        break;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
}
