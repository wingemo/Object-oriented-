/**
 * Represents a person with a first and last name and income.
 */
class Person {
  // The person's first name
  private String firstName;
  // The person's last name
  private String lastName;
  // The person's income
  private double income;

  /**
   * Constructs a new `Person` with the given first and last name and income.
   *
   * @param firstName the person's first name
   * @param lastName the person's last name
   * @param income the person's income
   */
  public Person(String firstName, String lastName, double income) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.income = income;
  }

  /**
   * Returns the person's first name.
   *
   * @return the person's first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the person's last name.
   *
   * @return the person's last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Returns the person's income.
   *
   * @return the person's income
   */
  public double getIncome() {
    return income;
  }
}
