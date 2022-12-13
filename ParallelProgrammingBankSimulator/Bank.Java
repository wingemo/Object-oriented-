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
  /**
   * Prompts the user to enter the number of transactions.
   */
  String promptNumTransactions = "Enter the number of transactions: ";

  /**
   * Prompts the user to enter the details of a transaction.
   */
  String promptTransactionDetails = "Enter the transaction details (id, type, amount): ";

  /**
   * A list of transactions.
   */
  List < Transaction > transactions = new ArrayList < > ();

  /**
   * A map of accounts, with the account id as the key.
   */
  Map < Integer, Account > accounts = new HashMap < > ();

  /**
   * A scanner for reading user input.
   */
  Scanner scanner = new Scanner(System.in);

  /**
   * A random number generator.
   */
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
   * Prompts the user for the number of transactions to process,
   * processes the transactions, and executes them.
   */
  public void runTransactions() {
    int numTransactions = promptNumTransactions();
    List < Transaction > transactions = processTransactions(numTransactions);
    executeTransactions(transactions);
  }

  /**
   * Prompts the user for the number of transactions to process.
   * @return The number of transactions to process.
   */
  private int promptNumTransactions() {
    System.out.println(promptNumTransactions);
    return scanner.nextInt();
  }

  /**
   * Processes the given number of transactions.
   * @param numTransactions The number of transactions to process.
   * @return A list of processed transactions.
   */
  private List < Transaction > processTransactions(int numTransactions) {
    List < Transaction > transactions = new ArrayList < > ();
    for (int i = 0; i < numTransactions; i++) {
      System.out.println(promptTransactionDetails);
      String id = scanner.next();
      int idAsInt = Integer.parseInt(id);
      String type = scanner.next();
      double amount = scanner.nextDouble();
      transactions.add(new Transaction(type, amount, accounts.get(idAsInt)));
    }
    return transactions;
  }

  /**
   * Executes a given list of transactions concurrently using a thread pool.
   *
   * @param transactions The list of transactions to be executed.
   */
  private void executeTransactions(List < Transaction > transactions) {
    ExecutorService executor = Executors.newFixedThreadPool(4);
    for (Transaction transaction: transactions) {
      executor.submit(transaction);
    }

    executor.Shutdown();
  }
