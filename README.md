# Example Networking Program

This program demonstrates how to send and receive objects over a network using Java.

## Requirements

- Java 8 or later

## Running the program

To run the program, start the Main by running the following command:

-- Java Main --

The client will send a `Person` object to the server, and the server will respond by sending a different `Person` object back to the client. The names of the received and sent `Person` objects will be printed to the console.

## Code structure

The program consists of two classes: `Server` and `Client`.

### Server

The `Server` class contains methods for creating a server socket, receiving a `Person` object from a client, sending a `Person` object to a client, and closing the server socket.

### Client

The `Client` class contains methods for creating a client socket, sending a `Person` object to a server, receiving a `Person` object from a server, and closing the client socket.

## Example output

Here is an example of the output when running the program:



