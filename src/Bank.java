import com.opencsv.CSVReader; // Import the CSVReader class from the opencsv library
// Import the CsvValidationException class from the opencsv library
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level; // Import the Level class from the java.util.logging package for logging
import java.util.logging.Logger; // Import the Logger class from the java.util.logging package for logging

class Bank {
    private final ArrayList<BankAccount> accounts; // List of bank accounts in the bank

    public Bank() {
        // Initialize the list of bank accounts as an empty arraylist.
        this.accounts = new ArrayList<>();
        loadAccountsFromCSV(); // Load accounts from CSV file on startup
    }

    // Add a new account to the bank by adding it to the list of accounts
    public void addAccount(BankAccount account) {
        accounts.add(account); // Add the account to the list of accounts
        System.out.println("Account created successfully!");
    }

    // Find an account in the list of accounts by its account number
    public BankAccount findAccount(String accountNumber) {

        // Loop through the list of accounts and find the account with the matching account number
        for (BankAccount account : accounts) {

            // If the account number matches, return the account object to the caller
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null; // Return null if the account is not found
    }

    // Get the list of accounts in the bank
    public BankAccount[] getAccounts() {

        // Convert the list of accounts to an array and return it to the caller
        return accounts.toArray(new BankAccount[0]);
    }

    // Remove an account from the list of accounts
    public void removeAccount(BankAccount closeAccount) {

        // Remove the account from the list of accounts if it exists
        accounts.remove(closeAccount);
    }

    // Load accounts from a CSV file on startup
    public void loadAccountsFromCSV() {

        // Create a CSVReader object with the CSV file name as an argument
        try (CSVReader reader = new CSVReader(new FileReader("accounts.csv"))) {
            String[] nextRecord; // Array to store the next record from the CSV file

            // Read the CSV file line by line and add each account to
            // the list of accounts using the BankAccount constructor with the CSV data
            while ((nextRecord = reader.readNext()) != null) { // Read the next record from the CSV file

                // Add the account to the list of accounts using the BankAccount constructor with the CSV data
                accounts.add(new BankAccount(String.join(",", nextRecord)));
            }
        } catch (FileNotFoundException e) { // If the CSV file is not found
            System.out.println("CSV file not found. Creating an empty file.");
            saveAccountsToCSV("accounts.csv", ""); // Create an empty CSV file
        } catch (IOException | CsvValidationException e) { // If there is an error reading the CSV file

            // Log the error to the console and exit the program with an error message
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, "Error loading accounts from CSV file.", e);
        }
    }

    // Save accounts to a CSV file// bank.saveAccountsToCSV("accounts.csv", csvString);
    // Updated saveAccountsToCSV method to accept filename and data
    public void saveAccountsToCSV(String filename, String data) {

        // Create a FileWriter object with the filename as an argument
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(data); // Write the data to the CSV file using the FileWriter object
            System.out.println("Data saved to CSV successfully.");
        } catch (IOException e) { // If there is an error writing to the CSV file

            // Log the error to the console and exit the program with an error message
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE,
                    "Error saving data to CSV file.", e);
        }
    }
}
