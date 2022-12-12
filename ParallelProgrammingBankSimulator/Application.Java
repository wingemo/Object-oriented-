/**
 * The main entry point for the application.
 */
public class Application {
  /**
   * Runs the bank simulation.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    Bank bank = new Bank();
    bank.runTransactions();
  }
}
