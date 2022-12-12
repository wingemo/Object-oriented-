class Person {
  // The person's first name
  private String firstName;
  // The person's last name
  private String lastName;

  /**
   * Constructs a new `Person` with the given first and last name.
   *
   * @param firstName the person's first name
   * @param lastName the person's last name
   */
  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
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
}
