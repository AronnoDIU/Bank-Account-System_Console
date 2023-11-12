import java.util.Scanner;

public class BankSystemMain {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.println("\n*** Welcome to the Bank Account System! ***");
            System.out.println("\nSelect an option from the menu below:");
            System.out.println("1. Create Account");
            System.out.println("2. Display Account Information");
            System.out.println("3. Deposit Amount");
            System.out.println("4. Withdraw Amount");
            System.out.println("5. Check Balance");
            System.out.println("6. Close Account");
            System.out.println("7. Exit");
            System.out.print("\nEnter your desired choice: ");

            int choice = userInput.nextInt();
            userInput.nextLine();  // Consume the newline character after reading the choice

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accNumber = userInput.nextLine();

                    if (bank.findAccount(accNumber) != null) {
                        System.out.println("Account already exists!");
                        break;
                    }

                    System.out.print("Enter account holder name: ");
                    String accHolder = userInput.nextLine();

                    boolean accountExists = false;
                    for (BankAccount account : bank.getAccounts()) {
                        if (account.getAccountHolder().equals(accHolder)) {
                            accountExists = true;
                            break;
                        }
                    }

                    if (accountExists) {
                        System.out.println("Account holder name already exists!");
                        break;
                    }

                    System.out.print("Enter initial balance: $");
                    double initialBalance = userInput.nextDouble();
                    userInput.nextLine();  // Consume the newline character
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

                case 2:
                    System.out.print("Enter account number: ");
                    String displayAccNumber = userInput.nextLine();
                    BankAccount displayAccount = bank.findAccount(displayAccNumber);

                    if (displayAccount != null) {
                        displayAccount.displayAccountInfo();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    String depositAccNumber = userInput.nextLine();
                    BankAccount depositAccount = bank.findAccount(depositAccNumber);

                    if (depositAccount != null) {
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = userInput.nextDouble();
                        userInput.nextLine();  // Consume the newline character
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    String withdrawAccNumber = userInput.nextLine();
                    BankAccount withdrawAccount = bank.findAccount(withdrawAccNumber);

                    if (withdrawAccount != null) {
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawAmount = userInput.nextDouble();
                        userInput.nextLine();  // Consume the newline character
                        withdrawAccount.withdraw(withdrawAmount);

                        if (withdrawAmount > withdrawAccount.getAccountBalance()) {
                            System.out.println("Insufficient funds!");
                            withdrawAccount.withdraw(withdrawAmount - withdrawAccount.getAccountBalance());
                            break;
                        }
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    String balanceAccNumber = userInput.nextLine();
                    BankAccount balanceAccount = bank.findAccount(balanceAccNumber);

                    if (balanceAccount != null) {
                        balanceAccount.displayBalance();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 6:
                    System.out.print("Enter account number: ");
                    String closeAccNumber = userInput.nextLine();
                    BankAccount closeAccount = bank.findAccount(closeAccNumber);

                    if (closeAccount != null) {
                        closeAccount.closeAccount();
                        bank.removeAccount(closeAccount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 7:
                    System.out.println("Exiting the system. Thank you for using the Bank!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

/* Expected output:

Class BankAccount:
The BankAccount class represents a bank account with attributes such as account number,
account holder name, and balance.It provides methods for depositing and withdrawing funds,
as well as retrieving the account information and displaying the account balance.

Class BankSystemMain:
The BankSystemMain class serves as the main entry point for the bank account system.
It contains the main method and handles user interactions, such as creating a new account,
depositing and withdrawing funds, checking the account balance, and exiting the system.
It utilizes the Bank class to perform account-related operations.

Class Bank:
The Bank class is responsible for managing a collection of bank accounts.
It maintains an ArrayList of BankAccount objects and provides methods for adding new accounts,
finding accounts by account number, and retrieving all accounts.
It is used by the BankSystemMain class to perform various operations on bank accounts.

*/