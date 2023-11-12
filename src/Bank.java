import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
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
        loadAccountsFromCSV(); // Load accounts from CSV file on startup
    }

    // Add a new account to the bank by adding it to the list of accounts
    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Account created successfully!");
    }

    // Find an account in the list of accounts by its account number
    public BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    // Get the list of accounts in the bank
    public BankAccount[] getAccounts() {
        return accounts.toArray(new BankAccount[0]);
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
        } catch (FileNotFoundException e) {
            System.out.println("CSV file not found. Creating an empty file.");
            saveAccountsToCSV("accounts.csv", ""); // Create an empty CSV file
        } catch (IOException | CsvValidationException e) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, "Error loading accounts from CSV file.", e);
        }
    }

    // Save accounts to a CSV file// bank.saveAccountsToCSV("accounts.csv", csvString);
    // Updated saveAccountsToCSV method to accept filename and data
    public void saveAccountsToCSV(String filename, String data) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(data);
            System.out.println("Data saved to CSV successfully.");
        } catch (IOException e) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE,
                    "Error saving data to CSV file.", e);
        }
    }
}
