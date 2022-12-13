# Parallel Programming a Bank Simulator

This is a simple Java application that simulates a bank with multiple transactions.

## Running the application

To run the application, you need to have the Java Development Kit (JDK) installed on your system. You can then compile and run the `Application` class, which will create a `Bank` object and run the transactions.

javac Application.java
java Application

When the application starts, it will ask you to enter the number of transactions you want to run. After that, you will be prompted to enter the details of each transaction (ID, type, and amount). The transactions will be processed in parallel using a fixed-size thread pool with 4 threads.

## Code structure

The code consists of three classes: `Application`, `Bank`, and `Account`. The `Application` class is the main class that creates a `Bank` object and runs the transactions. The `Bank` class represents the bank and contains a list of `Transaction` objects, a map of `Account` objects, and a `Scanner` and `Random` object for user input and random number generation, respectively. The `Account` class represents a bank account and has methods for depositing and withdrawing money.

The `Transaction` class implements the `Runnable` interface, which means that it can be executed by a thread. The `run` method of the `Transaction` class processes the transaction by calling the `deposit` or `withdraw` method of the `Account` object, depending on the type of the transaction. It also prints the ID, amount, and new balance of the account after the transaction is processed.

## Limitations

This is a simple simulation of a bank and is not intended for use in a real-world banking system. It does not include features such as authentication, security, or error handling. It is intended for educational purposes only.

## Configuration file

This is a configuration file it contains several parameters that control the behavior of the system.

The `promptNumTransactions` parameter specifies the message that should be displayed to the user when the system prompts for the number of transactions that will be processed.

The `promptTransactionDetails` parameter specifies the message that should be displayed to the user when the system prompts for the details of each transaction, such as the transaction ID, type, and amount.

The `newFixedThreadPool` parameter specifies the number of threads that should be used in the thread pool for processing transactions.

The `accounts` parameter specifies the number of accounts that are being tracked by the system.
