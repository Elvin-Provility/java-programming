package banking_system;

import java.util.HashMap;
import java.util.Map;

public class BankingApplication {
    private Map<String, Account> accounts;

    public BankingApplication() {
        this.accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, String accountHolder, double balance) {
        Account account = new Account(accountNumber, accountHolder, balance);
        accounts.put(accountNumber, account);
    }

    public void getAccountDetails(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Holder: " + account.getAccountHolder());
            System.out.println("Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public double checkAvailableBalance(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            return account.getBalance();
        } else {
            System.out.println("Account not found.");
            return 0.0;
        }
    }

    public void withdrawByATM(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            if (account.getBalance() >= amount) {
                account.withdraw(amount);
                System.out.println("Withdrawal successful. Remaining balance: " + account.getBalance());
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount) {
        if (accounts.containsKey(fromAccountNumber) && accounts.containsKey(toAccountNumber)) {
            Account fromAccount = accounts.get(fromAccountNumber);
            Account toAccount = accounts.get(toAccountNumber);
            if (fromAccount.getBalance() >= amount) {
                fromAccount.withdraw(amount);
                toAccount.deposit(amount);
                System.out.println("Transfer successful. Remaining balance in " + fromAccount.getAccountNumber() +
                        ": " + fromAccount.getBalance());
            } else {
                System.out.println("Insufficient funds in " + fromAccount.getAccountNumber());
            }
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    // Additional functionality to track order history and selected account

    public void printOrderHistory(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            System.out.println("Order History for Account: " + account.getAccountNumber());
            for (String order : account.getOrderHistory()) {
                System.out.println(order);
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void selectAccount(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            // Set the selected account in your application
            // For example, you can store it in a variable or use it for subsequent operations
            System.out.println("Account " + accountNumber + " selected.");
        } else {
            System.out.println("Account not found.");
        }
    }
}
