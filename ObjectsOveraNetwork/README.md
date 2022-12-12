# Objects Over a Network

This program demonstrates how to send and receive objects over a network using Java. Objects over a network is a way of organizing and managing data that is transmitted across a network. This approach is often used in distributed systems, where data is shared and accessed by multiple devices or computers that are connected to the network.

## Requirements

- Java 8 or later

## Running the program

To run the program, start the Main by running the following command:

```sh
Java Main
```
The server will send a `Person` object to the client. The names of the received and sent `Person` objects will be printed to the console.

## Code structure

The program consists of three classes: `Person`, `Server` and `Client`.

### Person

The `Person` class represents a person with a first and last name. It has constructors and accessor methods for initializing and retrieving the first and last names of the person. The `Person` class can be used in a program to represent a person and access their first and last names.

### Server

The `Server` class contains methods for creating a server socket, receiving a `Person` object from a client, sending a `Person` object to a client, and closing the server socket.

### Client

The `Client` class contains methods for creating a client socket, sending a `Person` object to a server, receiving a `Person` object from a server, and closing the client socket.

## Example output

Here is an example of the output when running the program:

```sh
Received person: John Doe
```

