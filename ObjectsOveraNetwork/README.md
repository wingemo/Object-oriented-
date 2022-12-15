
# Objects Over a Network

This program demonstrates how to send and receive objects over a network using Java. Objects over a network is a way of organizing and managing data that is transmitted across a network. This approach is often used in distributed systems, where data is shared and accessed by multiple devices or computers that are connected to the network.

## Requirements

- Java 8 or later

## Usage

To run the example, start the server by running the following command:

```sh
java com.wingemo.Application
```

The server will start listening on the host and port specified in the config.properties file. You can modify the host and port by editing the config.properties file. This will also start the client, which will connect to the server and send and receive a Person object. The client will also apply a tax rate to the person's income, and then send the modified Person object back to the server.

## Files

- `Application.java`: The main entry point of the application. This file contains the `main()` method, which starts the server and client.
- `Server.java`: A Java class that represents the server. The server listens for incoming connections and sends a `Person` object to the client.
- `Client.java`: A Java class that represents the client. The client connects to the server, receives a `Person` object, modifies the object, and then sends it back to the server.
- `Person.java`: A Java class that represents a person. This class is used for sending and receiving objects over the network.
- `config.properties`: A configuration file that contains the host, port, and tax rate to use for the server and client.
