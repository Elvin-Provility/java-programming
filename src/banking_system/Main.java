package banking_system;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        BankingApplication bankingApp = new BankingApplication();

        // Create accounts
        bankingApp.createAccount("A1", "John Doe", 1000.0);
        bankingApp.createAccount("A2", "Jane Smith", 5000.0);

        // Get account details
        bankingApp.getAccountDetails("A1");

        // Check available balance
        double balance = bankingApp.checkAvailableBalance("A1");
        System.out.println("Available balance: " + balance);

        // Withdraw by ATM
        bankingApp.withdrawByATM("A1", 500.0);

        // Transfer funds
        bankingApp.transferFunds("A1", "A2", 300.0);

        // Print order history
        bankingApp.printOrderHistory("A1");

        // Select account
        bankingApp.selectAccount("A2");
    }
}
