import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class Bank {
  public static void main(String[] args) {
    List<Transaction> transactions = new ArrayList<>();
    Map<Integer, Account> accounts = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();

    System.out.println("Enter the number of transactions: ");
    int numTransactions = scanner.nextInt();
    
    for (int i = 0; i < 10; i++) {
      Account account = new Account(i, rand.nextInt(1000));
      accounts.put(i, account);
    }

    for (int i = 0; i < numTransactions; i++) {
      System.out.println("Enter the transaction details (id, type, amount): ");
      String id = scanner.next();
      int idAsInt = Integer.parseInt(id);
      String type = scanner.next();
      double amount = scanner.nextDouble();
      transactions.add(new Transaction(type, amount, accounts.get(idAsInt)));
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
  private Account account;
  private double amount;

  public Transaction(String type, double amount, Account account) {
  	this.type = type;
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
    System.out.println(account.getId() + " Amount: " + amount + " New balance: " + account.getBalance());
  }
}

class Account {
  private int id;
  private double balance;

  public Account(int id, double balance) {
    this.id = id;
    this.balance = balance;
  }

  public void deposit(double amount) {
    balance += amount;
  }

  public void withdraw(double amount) {
    balance -= amount;
  }

  public int getId() {
    return id;
  }

  public double getBalance() {
    return balance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Account account = (Account) o;
    return id == account.id &&
           Double.compare(account.balance, balance) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, balance);
  }
}

