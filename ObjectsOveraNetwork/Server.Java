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

  /**
   * Creates a new Server instance.
   *
   * @param config a Properties object containing the port to use for the server
   * @throws IOException if an error occurs while creating the server socket
   */
  public Server(Properties config) throws IOException {
    this.serverSocket = new ServerSocket(parseInt(config.getProperty("port")));
    this.socket = serverSocket.accept();
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
   * Closes the output streams and the `ServerSocket` used by this `Server`.
   *
   * @throws IOException if an I/O error occurs while closing the stream or socket
   */
  public void close() throws IOException {
    oos.close();
    serverSocket.close();
  }

  public void run() {
    Person personToSend = new Person(
      config.getProperty("firstName", ""),
      config.getProperty("lastName", ""),
      config.getProperty("income", ""),
      config.getProperty("netIncome", "")
    );
    server.sendPerson(personToSend);
  }
}
