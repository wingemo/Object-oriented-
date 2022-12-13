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
  String promptNumTransactions = "Enter the number of transactions: ";
  String promptTransactionDetails = "Enter the transaction details (id, type, amount): ";
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

  public void runTransactions() {
    int numTransactions = promptNumTransactions();
    List < Transaction > transactions = processTransactions(numTransactions);
    executeTransactions(transactions);
  }

  private int promptNumTransactions() {
    System.out.println(promptNumTransactions);
    return scanner.nextInt();
  }

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

  private void executeTransactions(List < Transaction > transactions) {
    ExecutorService executor = Executors.newFixedThreadPool(4);
    for (Transaction transaction: transactions) {
      executor.submit(transaction);
    }

    executor.Shutdown();
  }
