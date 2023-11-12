import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class Bank {
    private final ArrayList<BankAccount> accounts; // List of bank accounts in the bank

    public Bank() {
        // Initialize the list of bank accounts as an empty arraylist.
        this.accounts = new ArrayList<>();
        loadAccountsFromCSV();  // Load accounts from CSV file on startup
    }

    // Add a new account to the bank by adding it to the list of accounts
    public void addAccount(BankAccount account) {
        accounts.add(account); // Add the new account to the list
        System.out.println("Account created successfully!");
    }

    // Find an account in the list of accounts by its account number
    public BankAccount findAccount(String accountNumber) {

        // Iterate through the list of accounts
        for (BankAccount accountList : accounts) {
            if (accountList.getAccountNumber().equals(accountNumber)) {
                return accountList;
            }
        }
        return null;
    }

    // Get the list of accounts in the bank
    public BankAccount[] getAccounts() {
        return new BankAccount[0];
    }

    // Remove an account from the list of accounts
    public void removeAccount(BankAccount closeAccount) {
        accounts.remove(closeAccount);
    }

    // Load accounts from a CSV file on startup
    public void loadAccountsFromCSV() {
        try (CSVReader reader = new CSVReader(new FileReader("accounts.csv"))) {
            String[] nextRecord;
            while ((nextRecord = reader.readNext()) != null) {
                accounts.add(new BankAccount(String.join(",", nextRecord)));
            }
        } catch (IOException | CsvValidationException e) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, "Error loading accounts from CSV file.", e);
        }
    }

    // Save accounts to a CSV file
    public void saveAccountsToCSV() {
        try (CSVWriter writer = new CSVWriter(new FileWriter("accounts.csv"))) {
            for (BankAccount account : accounts) {
                // Convert each BankAccount object to a string array and write to CSV
                String[] data = {account.getAccountNumber(), account.getAccountHolder(),
                        Double.toString(account.getBalance())};
                writer.writeNext(data);
            }
            System.out.println("Accounts saved to CSV successfully.");
        } catch (IOException e) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, "Error saving accounts to CSV file.", e);
        }
    }
}
