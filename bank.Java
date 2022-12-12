import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;

public class Bank {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number of transactions: ");
    int numTransactions = scanner.nextInt();
    
    Random rand = new Random();
    for (int i = 0; i <= 10; i = i + 1) {
      Account account = new Account(i, rand.nextInt(1000))
    }
    
    // Create a list of transactions
    List<Transaction> transactions = new ArrayList<>();
    for (int i = 0; i < numTransactions; i++) {
      System.out.println("Enter the transaction details (id, type, amount): ");
      String id = scanner.next();
      String type = scanner.next();
      double amount = scanner.nextDouble();
      transactions.add(new Transaction(id, type, amount));
    }

    // Process the transactions in parallel
    ExecutorService executor = Executors.newFixedThreadPool(4);
    for (Transaction transaction : transactions) {
      executor.submit(transaction);
    }

    // Shutdown the executor service
    executor.shutdown();
  }
}

class Transaction implements Runnable {
  private String id;
  private Account account;
  private double amount;

  public Transaction(String id, String type, double amount, Account account) {
  	this.id = id;
  	ttis.type = type;
  	this.amount = amount;
  	this.account = account;
  }

  public void run() {
    // Process the transaction
    if (type.equals("deposit")) {
      account.deposit(amount);
    } else if (type.equals("withdraw")) {
      account.withdraw(amount);
    }
    System.out.println("Processed transaction " + id + " for account " + account.getId() + " for the amount of " + amount + ". New balance: " + account.getBalance());
  }
}

class Account {
  private String id;
  private double balance;

  public Account(String id, double balance) {
    this.id = id;
    this balance = balance;
  }

  public void deposit(double amount) {
    balance += amount;
  }

  public void withdraw(double amount) {
    balance -= amount;
  }

  public String getId() {
    return id;
  }

  public double getBalance() {
    return balance;
  }
}
