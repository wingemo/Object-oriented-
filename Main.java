public class Main {
  public static void main(String[] args) {
    Server server = new Server();
    Client client = new Client();
    
    Person person = client.receivePerson();
    Person personToSend = new Person("John Doe");
    server.sendPerson(personToSend);
    System.out.println("Received person: " + person);
    
    client.close();
    server.close();
  }
}
