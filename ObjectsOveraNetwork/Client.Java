package com.wingemo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Properties;

/**
 * A Java client that connects to a server and receives a {@link Person} object from the server.
 * The client then applies a tax rate to the person's income, and then send back the {@link Person} object.
 *
 * @author Philip Wingemo
 */
public class Client implements Runnable {
  /**
   * The `Socket` used for connecting to the server.
   */
  private Socket socket;

  /**
   * The `ObjectInputStream` used for reading a `Person` object from the server.
   */
  private ObjectInputStream ois;

  /**
   * The tax rate to use for calculating taxes.
   */
  private double taxRate;

  /**
   * The `Properties` object containing the server's configuration.
   */
  private Properties config;

  /**
   * The `Logger` object used to log messages from the server.
   */
  private Logger logger;

  /**
   * Creates a new Client instance.
   *
   * @param config a Properties object containing the host, port, and taxRate to use for the client
   * @throws IOException if there is an error creating the socket or initializing the object input stream
   */
  public Client(Properties config, Logger logger) throws IOException {
    this.logger = logger;
    this.config = config;
    this.socket = new Socket(config.getProperty("host"), Integer.parseInt(config.getProperty("port")));
    this.taxRate = Double.parseDouble(config.getProperty("taxRate"));
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
    logger.info(person);
    return person;
  }

  /**
   * Writes a {@link Person} object to an {@link ObjectOutputStream}.
   *
   * @param person the {@link Person} object to write
   * @throws IOException if there is an error writing to the {@link ObjectOutputStream}
   */
  public void sendPerson(Person person) throws IOException {
    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
    oos.writeObject(person);
    oos.flush();
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

  /**
   * Returns a string representation of the `Client` object.
   *
   * @return a string representation of the `Client` object
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Client[host=").append(config.getProperty("host"))
      .append(",port=").append(config.getProperty("port"))
      .append(",taxRate=").append(taxRate)
      .append("]");
    return sb.toString();
  }

  /**
   * Receives a person object, prints it to the standard output.
   *
   * @throws IOException if an I/O error occurs while receiving the person object
   * @throws ClassNotFoundException if the class of the serialized person object cannot be found
   */
  public void run() {
    try {
      logger.info(toString());
      sendPerson(receivePerson());
    } catch (IOException e) {
      logger.error(e);
    }
  }
}
