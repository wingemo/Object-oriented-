import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {
  @Test
  void testPerson() {
    Person person = new Person("John", "Doe", "30000", "27000");
    assertEquals("John", person.getFirstName());
    assertEquals("Doe", person.getLastName());
    assertEquals(30000, person.getIncome());
    assertEquals(27000, person.getNetIncome());

    person.setFirstName("Jane");
    person.setLastName("Smith");
    person.setIncome(40000);
    person.setNetIncome(36000);

    assertEquals("Jane", person.getFirstName());
    assertEquals("Smith", person.getLastName());
    assertEquals(40000, person.getIncome());
    assertEquals(36000, person.getNetIncome());
  }
}
