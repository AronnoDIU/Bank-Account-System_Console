import java.util.ArrayList;
import java.util.List;

class BankAccount {
    private final String accountNumber;
    private final String accountHolder;
    private double accountBalance;
    private List<String> transactions;  // List to store account transactions

    public BankAccount(String accountNumber, String accountHolder, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.accountBalance = accountBalance;
        this.transactions = new ArrayList<>(); // Initialize the list of transactions
    }

    // Create a BankAccount from a CSV string
    public BankAccount(String csv) {
        String[] data = csv.split(",");
        this.accountNumber = data[0];
        this.accountHolder = data[1];
        this.accountBalance = Double.parseDouble(data[2]);
    }

    // Convert account data to a CSV string
    public String toCSVString() {
        return String.format("%s,%s,%.2f", accountNumber, accountHolder, accountBalance);
    }

    // Getters and setters for account data members
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    // Account operations
    public void deposit(double amount) {
        accountBalance += amount; // Add the amount to the account balance
        System.out.println("Deposited: $" + amount);

        // Add the transaction to the list of transactions
        transactions.add("Deposit: $" + amount);

        displayBalance(); // Display the new balance
    }

    // Withdraw money from the account balance and add it to the list of transactions
    public void withdraw(double amount) {

        // Check if the withdrawal amount is less than or equal to the account balance
        if (amount <= accountBalance) {
            accountBalance -= amount; // Subtract the amount from the account balance

            // Add the transaction to the list of transactions for withdrawal amount
            transactions.add("Withdrawal: $" + amount);
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds");
        }
        displayBalance(); // Display the new balance
    }

    // Display the account statement for the account number
    public void displayAccountStatement() {
        System.out.println("\n--- Account Statement for Account Number: " + accountNumber + " ---");

        // Display the list of transactions for the account
        for (String transaction : transactions) {
            System.out.println(transaction); // Print each transaction
        }
        System.out.println("--- End of Statement ---");
    }

    // Display the account balance for the account number
    public void displayBalance() {
        System.out.println("Current Balance: $" + accountBalance);
    }

    // Close the account by removing it from the list of accounts and displaying a message
    public void closeAccount() {
        System.out.println("Account number " + accountNumber
                + " has been closed successfully!");
        System.out.println("Goodbye!");
    }

    // Display the account information for the account number
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Balance: $" + accountBalance);
    }
}