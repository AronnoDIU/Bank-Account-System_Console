import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accNumber = scanner.nextLine();
                    System.out.print("Enter account holder name: ");
                    String accHolder = scanner.nextLine();
                    System.out.print("Enter initial balance: $");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine();  // Consume the newline character
                    BankAccount newAccount = new BankAccount(accNumber, accHolder, initialBalance);
                    bank.addAccount(newAccount);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    String depositAccNumber = scanner.nextLine();
                    BankAccount depositAccount = bank.findAccount(depositAccNumber);
                    if (depositAccount != null) {
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine();  // Consume the newline character
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    String withdrawAccNumber = scanner.nextLine();
                    BankAccount withdrawAccount = bank.findAccount(withdrawAccNumber);
                    if (withdrawAccount != null) {
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine();  // Consume the newline character
                        withdrawAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    String balanceAccNumber = scanner.nextLine();
                    BankAccount balanceAccount = bank.findAccount(balanceAccNumber);
                    if (balanceAccount != null) {
                        balanceAccount.displayBalance();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the system. Thank you!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}