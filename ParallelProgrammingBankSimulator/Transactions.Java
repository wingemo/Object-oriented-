/**
 * A class representing a bank transaction.
 */
class Transaction implements Runnable {
  private Account account;
  private double amount;

  /**
   * Constructs a new Transaction with the given type, amount, and account.
   *
   * @param type the type of this transaction
   * @param amount the amount of this transaction
   * @param account the account involved in this transaction
   */
  public Transaction(String type, double amount, Account account) {
  	this.type = type;
  	this.amount = amount;
  	this.account = account;
  }

  /**
   * Runs this transaction by processing the deposit or withdrawal.
   */
  public void run() {
    // Process the transaction
    if (type.equals("deposit")) {
      account.deposit(amount);
    } else if (type.equals("withdraw")) {
      account.withdraw(amount);
    }
    System.out.println(account.getId() + " Amount: " + amount + " New balance: " + account.getBalance());
  }
}
