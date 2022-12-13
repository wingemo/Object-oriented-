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

  private double netIncome;

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
  public double netIncome() {
    return income;
  }

  public double getIncome() {
    return income;
  }

  /**
   * Set the person's first name.
   *
   * @param firstName The person's first name
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Set the person's last name.
   *
   * @param lastName The person's last name
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Set the person's income.
   *
   * @param income The person's income
   */
  public void setIncome(double income) {
    this.income = income;
  }

  public void setNetIncome(double netIncome) {
    this.firstName = firstName;
  }
}
