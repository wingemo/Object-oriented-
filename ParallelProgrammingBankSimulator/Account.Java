/**
 * A class representing a bank account.
 */
class Account {
  private int id;
  private double balance;

  /**
   * Constructs a new Account with the given id and initial balance.
   *
   * @param id the unique id of this account
   * @param balance the initial balance of this account
   */
  public Account(int id, double balance) {
    this.id = id;
    this.balance = balance;
  }

  /**
   * Deposits the given amount into this account.
   *
   * @param amount the amount to deposit
   */
  public void deposit(double amount) {
    balance += amount;
  }

  /**
   * Withdraws the given amount from this account.
   *
   * @param amount the amount to withdraw
   */
  public void withdraw(double amount) {
    balance -= amount;
  }

  /**
   * Returns the unique id of this account.
   *
   * @return the id of this account
   */
  public int getId() {
    return id;
  }

  /**
   * Returns the current balance of this account.
   *
   * @return the current balance of this account
   */
  public double getBalance() {
    return balance;
  }

  /**
 * Returns true if the given object is equal to this account, false otherwise.
 *
 * @param o the object to compare with this account
 * @return true if the given object is equal to this account, false otherwise
 */
@Override
public boolean equals(Object o) {
  if (this == o) return true;
  if (o == null || getClass() != o.getClass()) return false;
  Account account = (Account) o;
  return id == account.id &&
         Double.compare(account.balance, balance) == 0;
}

/**
 * Returns the hash code value for this account.
 *
 * @return the hash code value for this account
 */
@Override
public int hashCode() {
  return Objects.hash(id, balance);
}

}

