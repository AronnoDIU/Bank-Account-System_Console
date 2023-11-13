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
        this.transactions = new ArrayList<>();
    }

    // New method to convert account data to a CSV string
    public String toCSVString() {
        return String.format("%s,%s,%.2f", accountNumber, accountHolder, accountBalance);
    }

    // New constructor to create a BankAccount from a CSV string
    public BankAccount(String csv) {
        String[] data = csv.split(",");
        this.accountNumber = data[0];
        this.accountHolder = data[1];
        this.accountBalance = Double.parseDouble(data[2]);
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void deposit(double amount) {
        accountBalance += amount;
        System.out.println("Deposited: $" + amount);
        transactions.add("Deposit: $" + amount);
        displayBalance();
    }

    public void withdraw(double amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            transactions.add("Withdrawal: $" + amount);
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds");
        }
        displayBalance();
    }

    public void displayAccountStatement() {
        System.out.println("\n--- Account Statement for Account Number: " + accountNumber + " ---");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println("--- End of Statement ---");
    }

    public void displayBalance() {
        System.out.println("Current Balance: $" + accountBalance);
    }

    public void closeAccount() {
        System.out.println("Account number " + accountNumber
                + " has been closed successfully!");
        System.out.println("Goodbye!");
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Balance: $" + accountBalance);
    }
}