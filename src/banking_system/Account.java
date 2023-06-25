package banking_system;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private List<String> orderHistory;

    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.orderHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getOrderHistory() {
        return orderHistory;
    }

    public void withdraw(double amount) {
        balance -= amount;
        orderHistory.add("Withdrawal: " + amount);
    }

    public void deposit(double amount) {
        balance += amount;
        orderHistory.add("Deposit: " + amount);
    }
}
