/**
 * Represents a person with a first and last name, income, and net income after taxes.
 */
class Person {
  // The person's first name
  private String firstName;
  // The person's last name
  private String lastName;
  // The person's income
  private double income;
  //The person's net income after taxes.
  private double netIncome;

  /**
   * Constructs a new {@code Person} with the given first name, last name, income, and net income.
   * @param firstName the first name of the person
   * @param lastName the last name of the person
   * @param income the income of the person
   * @param netIncome the net income of the person
   */
  public Person(String firstName, String lastName, double income, double netIncome) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.income = income;
    this.netIncome = netIncome;
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

  /**
   * Returns the income of the person.
   *
   * @return the income of the person.
   */
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

  /**
   * Sets the net income of the person.
   *
   * @param netIncome the new net income of the person.
   */
  public void setNetIncome(double netIncome) {
    this.netIncome = netIncome;
  }

  /**
   * Returns a string representation of the `Person` object.
   *
   * @return a string representation of the `Person` object
   */
  @Override
  public String toString() {
    return "Person{" +
      "firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", income=" + income +
      ", netIncome=" + netIncome +
      '}';
  }
