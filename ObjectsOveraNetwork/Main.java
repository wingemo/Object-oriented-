public class Main {
  public static void main(String[] args) {
    Server server = new Server();
    Client client = new Client();
    
    Person personToSend = new Person("John Doe");
    server.sendPerson(personToSend);
    Person person = client.receivePerson();
    System.out.println("Received person: " + person);
    
    client.close();
    server.close();
  }
}
