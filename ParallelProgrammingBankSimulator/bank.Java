import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.concurrent.*;

/**
 * A class representing a bank.
 */
public class Bank {
  List < Transaction > transactions = new ArrayList < > ();
  Map < Integer, Account > accounts = new HashMap < > ();
  Scanner scanner = new Scanner(System.in);
  Random rand = new Random();

  /**
   * Constructs a new Bank with 10 accounts with random initial balances.
   */
  public Bank() {
    for (int i = 0; i < 10; i++) {
      Account account = new Account(i, rand.nextInt(1000));
      accounts.put(i, account);
    }
  }

  /**
   * Runs the bank simulation by prompting the user for the number of transactions,
   * processing the transactions using multiple threads, and shutting down the thread
   * executor when finished.
   */
  public void runTransactions() {
    System.out.println("Enter the number of transactions: ");
    int numTransactions = scanner.nextInt();

    for (int i = 0; i < numTransactions; i++) {
      System.out.println("Enter the transaction details (id, type, amount): ");
      String id = scanner.next();
      int idAsInt = Integer.parseInt(id);
      String type = scanner.next();
      double amount = scanner.nextDouble();
      transactions.add(new Transaction(type, amount, accounts.get(idAsInt)));
    }

    ExecutorService executor = Executors.newFixedThreadPool(4);
    for (Transaction transaction: transactions) {
      executor.submit(transaction);
    }

    executor.Shutdown();
  }
}
