import java.util.Scanner;

public class BankSystemMain {
    public static void main(String[] args) {
        Bank bank = new Bank(); // Create a new bank object
        Scanner userInput = new Scanner(System.in); // Create a new scanner object

        while (true) { // Loop until the user chooses to exit
            System.out.println("\n*** Welcome to the Bank Account System! ***");
            System.out.println("\nSelect an option from the menu below:");
            System.out.println("1. Create Account");
            System.out.println("2. Account Information");
            System.out.println("3. Deposit Amount");
            System.out.println("4. Withdraw Amount");
            System.out.println("5. Account Balance");
            System.out.println("6. Close Account");
            System.out.println("7. Fund Transfer");
            System.out.println("8. Account Statement");
            System.out.println("9. Help");
            System.out.println("10. Exit");
            System.out.print("\nEnter your desired choice: ");

            int choice = userInput.nextInt(); // Read the user's choice
            userInput.nextLine();  // Consume the newline character after reading the choice

            switch (choice) { // Switch on the user's choice
                case 1: // For Create Account option
                    System.out.print("Enter account number: ");
                    String accNumber = userInput.nextLine();

                    // Check if the account number already exists
                    if (bank.findAccount(accNumber) != null) {
                        System.out.println("Account already exists!");
                        break;
                    }

                    System.out.print("Enter account holder name: ");
                    String accHolder = userInput.nextLine();

                    boolean accountExists = false;

                    for (BankAccount account : bank.getAccounts()) {

                        // Check if the account holder name already exists
                        if (account.getAccountHolder().equals(accHolder)) {
                            accountExists = true; // Set the flag to true
                            break;
                        }
                    }

                    // Check if the account holder name already exists
                    if (accountExists) {
                        System.out.println("Account holder name already exists!");
                        break;
                    }

                    System.out.print("Enter initial balance: $");
                    double initialBalance = userInput.nextDouble(); // Read the initial balance
                    userInput.nextLine();  // Consume the newline character

                    // Create a new account
                    BankAccount newAccount = new BankAccount(accNumber, accHolder, initialBalance);

                    // Add the new account to the bank list
                    bank.addAccount(newAccount);

                    // Use the toCSVString method to get the CSV representation
                    String csvString = newAccount.toCSVString();

                    // Print or save the CSV string as needed
                    System.out.println("CSV Representation: " + csvString);

                    // Save the CSV string to a file
                    bank.saveAccountsToCSV("accounts.csv", csvString);
                    break;

                case 2: // For Account Information
                    System.out.print("Enter account number: ");
                    String displayAccNumber = userInput.nextLine();
                    BankAccount displayAccount = bank.findAccount(displayAccNumber);

                    // Check if the account exists
                    if (displayAccount != null) {
                        displayAccount.displayAccountInfo(); // Display the account information
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3: // For Deposit Amount
                    System.out.print("Enter account number: ");
                    String depositAccNumber = userInput.nextLine();

                    BankAccount depositAccount = bank.findAccount(depositAccNumber);

                    // Check if the account exists
                    if (depositAccount != null) {
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = userInput.nextDouble();
                        userInput.nextLine();  // Consume the newline character

                        // Deposit the amount into the account balance
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4: // For Withdraw Amount
                    System.out.print("Enter account number: ");
                    String withdrawAccNumber = userInput.nextLine();

                    BankAccount withdrawAccount = bank.findAccount(withdrawAccNumber);

                    // Check if the account exists
                    if (withdrawAccount != null) {
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawAmount = userInput.nextDouble();
                        userInput.nextLine();  // Consume the newline character

                        // Withdraw the amount from the account balance
                        withdrawAccount.withdraw(withdrawAmount);

                        // Check if the withdrawal amount exceeds the account balance
                        if (withdrawAmount > withdrawAccount.getAccountBalance()) {
                            System.out.println("Insufficient funds!");

                            // Withdraw the difference from the account balance
                            withdrawAccount.withdraw(withdrawAmount
                                        - withdrawAccount.getAccountBalance());
                            break;
                        }
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5: // For Account Balance
                    System.out.print("Enter account number: ");
                    String balanceAccNumber = userInput.nextLine();

                    BankAccount balanceAccount = bank.findAccount(balanceAccNumber);

                    // Check if the account exists
                    if (balanceAccount != null) {
                        balanceAccount.displayBalance(); // Display the account balance
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 6: // For Close Account
                    System.out.print("Enter account number: ");
                    String closeAccNumber = userInput.nextLine();

                    BankAccount closeAccount = bank.findAccount(closeAccNumber);

                    // Check if the account exists
                    if (closeAccount != null) {

                        // Close the account
                        closeAccount.closeAccount();

                        // Remove the account from the list
                        bank.removeAccount(closeAccount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 7: // For Fund Transfer
                    System.out.print("Enter your account number: ");
                    String fromAccountNumber = userInput.nextLine();

                    BankAccount fromAccount = bank.findAccount(fromAccountNumber);

                    // Check if an account exists
                    if (fromAccount != null) {
                        System.out.print("Enter recipient's account number: ");
                        String toAccountNumber = userInput.nextLine();

                        // Find the recipient's account in the list of accounts
                        BankAccount toAccount = bank.findAccount(toAccountNumber);

                        // Check if the recipient's account exists
                        if (toAccount != null) {
                            System.out.print("Enter transfer amount: $");
                            double transferAmount = userInput.nextDouble();
                            userInput.nextLine();  // Consume the newline character

                            // Check if the sender has sufficient funds for the transfer
                            if (fromAccount.getAccountBalance() >= transferAmount) {

                                // Perform the fund transfer
                                // Withdraw from the sender's account
                                fromAccount.withdraw(transferAmount);

                                // Add the transfer amount to the recipient's account
                                toAccount.deposit(transferAmount);

                                System.out.println("Fund transfer successful!");
                            } else {
                                System.out.println("Insufficient funds for transfer.");
                            }
                        } else {
                            System.out.println("Recipient's account not found!");
                        }
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 8:
                    System.out.print("Enter account number: ");
                    String statementAccNumber = userInput.nextLine();

                    // Find the account in the list of accounts
                    BankAccount statementAccount = bank.findAccount(statementAccNumber);

                    // Check if the account exists
                    if (statementAccount != null) {

                        // Display the account statement
                        statementAccount.displayAccountStatement();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 9: // For Help Feature
                    displayHelp(); // Display the help message
                    break;

                case 10:
                    System.out.println("Exiting the system. Thank you for using the Bank!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to display the help message for the user
    private static void displayHelp() {
        System.out.println("\n--- Help ---");
        System.out.println("1. Create Account: Create a new bank account.");
        System.out.println("2. Account Information: View details of an existing account.");
        System.out.println("3. Deposit Amount: Add funds to your account.");
        System.out.println("4. Withdraw Amount: Take money from your account.");
        System.out.println("5. Account Balance: View the current balance of your account.");
        System.out.println("6. Close Account: Close an existing account.");
        System.out.println("7. Fund Transfer: Transfer money between accounts.");
        System.out.println("8. Account Statement: View a statement of recent transactions.");
        System.out.println("9. Help: Display this help message.");
        System.out.println("10. Exit: Close the bank system.");
        System.out.println("--- End of Help ---");
    }
}