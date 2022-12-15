package com.wingemo;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ServerTest {
  private Server server;
  private ServerSocket serverSocket;
  private Properties config;

  @Before
  public void setUp() throws Exception {
    // Create a properties object with the server's port number
    config = new Properties();
    config.setProperty("port", "10000");

    // Create a mock logger object
    Logger logger = new Logger() {
      @Override
      public void info(String message) {
        // Do nothing
      }

      @Override
      public void error(Exception e) {
        // Do nothing
      }
    };

    // Create a new Server instance with the config and logger objects
    server = new Server(config, logger);

    // Start the server
    new Thread(server).start();

    // Create a new ServerSocket instance to simulate a client
    serverSocket = new ServerSocket(10000);
  }

  @After
  public void tearDown() throws Exception {
    // Close the server and the simulated client
    server.close();
    serverSocket.close();
  }

  @Test
  public void testSendPerson() throws Exception {
    // Create a new Person object
    Person person = new Person("John", "Doe", 1000, 0.1);

    // Connect to the server and send the Person object
    Socket socket = serverSocket.accept();
    server.sendPerson(person);

    // Verify that the Person object was sent correctly
    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
    Person receivedPerson = (Person) ois.readObject();
    assertEquals(person, receivedPerson);
  }
}
