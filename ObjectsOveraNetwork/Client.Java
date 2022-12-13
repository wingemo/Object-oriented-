package com.wingemo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Properties;

/**
 * A Java client that connects to a server at "localhost" on port 8000, receives
 * a {@link Person} object from the server, and closes the connection.
 *
 * @Philip Wingemo
 */
public class Client {
  // The socket for connecting to the server
  private Socket socket;
  // The object input stream for reading the `Person` object from the server
  private ObjectInputStream ois;
  // The tax rate to use for calculating taxes.
  private int taxRate;

  /**
   * Creates a new Client instance.
   *
   * @param config a Properties object containing the host, port, and taxRate to use for the client
   */
  public Client(Properties config) throws IOException {
    this.socket = new Socket(config.getProperty("host"), Integer.parseInt(config.getProperty("port")));
    this.taxRate = Integer.parseInt(config.getProperty("taxRate"));
    this.ois = new ObjectInputStream(socket.getInputStream());
  }

  /**
   * Reads a {@link Person} object from an {@link ObjectInputStream} and applies a tax rate to the person's income.
   *
   * @return the modified {@link Person} object
   * @throws IOException if there is an error reading from the {@link ObjectInputStream}
   * @throws ClassNotFoundException if the {@link Person} class cannot be found
   */
  public Person receivePerson() throws IOException, ClassNotFoundException {
      Person person = (Person) ois.readObject();
      person.setNetIncome(taxRate * person.getIncome());
      return person;
  }

  /**
   * Closes the connection to the server.
   *
   * @throws IOException if an I/O error occurs
   */
  public void close() throws IOException {
    ois.close();
    socket.close();
  }
 
  receivePerson();
    System.out.println(String.format(config.getProperty("receivedPersonMessage"), person));
  
}
