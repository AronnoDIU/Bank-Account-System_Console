# Banking System

A simple console-based bank account system that allows users to perform basic banking operations.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Author](#author)
- [Installation](#installation)
- [Classes](#classes)
    - [BankSystemMain](#banksystemmain)
    - [BankAccount](#bankaccount)
    - [Bank](#bank)
- [Usage](#usage)
- [Contributions](#contributions)
- [Contribution Guidelines](#contribution-guidelines)
- [Acknowledgements](#acknowledgements)
- [Contact](#contact)
- [Conclusion](#conclusion)
- [License](#license)

## Introduction

The Bank Account System Console is a command-line application 
built using Java that allows users to manage their bank accounts. 
It provides a set of features to perform operations 
such as creating a new account, depositing and withdrawing funds, 
checking account balance, and transferring funds between accounts.

This project was developed as a learning exercise 
to understand the fundamentals of object-oriented 
programming and basic banking operations. 
It demonstrates the use of classes, inheritance, and file handling in Java.

## Features

The Bank Account System Console offers the following features:

- **Account Creation**: Users can create a new bank account by providing their name, initial deposit amount, and account type (e.g., savings or checking).
- **Account Information**: Users can view their account information by entering their account number.
- **Deposit Amount**: Account holders can deposit funds into their accounts by specifying the account number and the amount to be deposited.
- **Withdrawal Amount**: Users can withdraw funds from their accounts by entering the account number and the amount to be withdrawn. The system verifies if the account has sufficient balance before allowing the withdrawal.
- **Account Balance**: Account holders can check their account balance by entering their account number.
- **Fund Transfer**: Users can transfer funds from one account to another by specifying the source account number, destination account number, and the transfer amount. The system verifies the account balances before processing the transfer.
- **Account Close**: Users can close their accounts by entering their account number.
- **Account Statement**: Users can view their account statement by entering the account number.
- **Help**: Users can view the list of available features and commands by entering the help command.
- **Exit**: Users can exit the system by entering the exit command.

## Author

The Bank Account System Console was created by [AronnoDIU](https://github.com/AronnoDIU).

## Installation

To run the Bank Account System Console, follow these steps:

1. Clone the repository:

   ```shell
   git clone https://github.com/AronnoDIU/Bank-Account-System_Console.git

## Classes

### BankSystemMain

The `BankSystemMain` class is the entry point of the application. It contains the main method that starts the banking system.

#### Methods

- `main(String[] args)`: The main method of the `BankSystemMain` class.
- `readInput()`: Reads user input.
- `showMenu()`: Displays the main menu.
- `createAccount()`: Creates a new bank account.
- `displayAccountInfo()`: Displays account information.
- `depositFunds()`: Deposits funds into an account.
- `withdrawFunds()`: Withdraws funds from an account.
- `checkBalance()`: Checks the balance of an account.
- `transferFunds()`: Transfers funds between accounts.
- `closeAccount()`: Closes an account.
- `displayAccountStatement()`: Displays an account statement.
- `help()`: Displays the list of available commands.
- `exit()`: Exits the system.

### BankAccount

The `BankAccount` class represents a bank account. It has the following attributes and methods:

#### Constructors

- `BankAccount(String name, double initialDeposit, String accountType)`: Creates a new bank account with the specified name, initial deposit amount, and account type.
- `BankAccount(String csv)`: Creates a new bank account from a CSV string.

#### Methods

- `getName()`: Returns the name of the bank account.
- `getAccountType()`: Returns the type of the bank account.
- `getAccountNumber()`: Returns the account number of the bank account.
- `getAccountHolderName()`: Returns the account holder name of the bank account.
- `getAccountBalance()`: Returns the current balance of the bank account.
- `deposit(double amount)`: Deposits the specified amount into the bank account.
- `withdraw(double amount)`: Withdraws the specified amount from the bank account.
- `checkBalance()`: Checks the current balance of the bank account.
- `transferFunds(BankAccount destinationAccount, double amount)`: Transfers the specified amount from the bank account to the specified destination account.
- `displayAccountInfo()`: Displays the account information.
- `displayAccountStatement()`: Displays the account statement.
- `closeAccount()`: Closes the bank account.
- `displayBalance()`: Displays the current balance of the bank account.
- `displayAccountInfo()`: Displays the account information.
- `toString()`: Returns a string representation of the bank account.
- `equals(Object obj)`: Checks if the specified object is equal to the current bank account.
- `compareTo(BankAccount otherAccount)`: Compares the current bank account with the specified bank account.


### Bank

The `Bank` class represents a bank. It has the following attributes and methods:

#### Constructors

- `Bank()`: Creates a new bank with the specified bank accounts.

#### Attributes

- `accounts`: A list of bank accounts associated with the bank.


#### Methods

- `add_account(account)`: Adds a bank account to the bank.
- `findAccount(accountNumber)`: Finds a bank account with the specified account number.
- `get_account(accountNumber)`: Returns a bank account with the specified account number.
- `remove_account(account)`: Removes a bank account from the bank.
- `loadAccountsFromCSV()`: Loads bank accounts from a CSV file.
- `saveAccountsToCSV()`: Saves bank accounts to a CSV file.

## Usage

To use the banking system, you can follow these steps:

1. Create an instance of the `Bank` class.
2. Create instances of the `BankAccount` class for each bank account.
3. Add the bank accounts to the bank using the `add_account` method.
4. Use the methods of the `BankAccount` class to perform operations such as depositing and withdrawing money.
5. Use the methods of the `Bank` class to manage the bank accounts and get the total balance.
6. Use the methods of the `Bank` class to get the account history and summary.
7. Close the bank account and remove it from the bank using the `remove_account` method.
8. Exit the system.
9. Use the `get_total_balance` method to get the total balance of all bank accounts in the bank.
10. Use the `get_history` method to get the account history of the bank.
11. Use the `get_summary` method to get the account summary of the bank.
12. Use the `get_name` method to get the name of the bank.
13. Use the `get_accounts` method to get the list of bank accounts associated with the bank.
14. Use the `display_account_history` method to display the account history of the bank.

## Contributions

If you have any contributions or suggestions, please feel free to open an issue or pull request on GitHub.

## Contribution Guidelines

please read the [CONTRIBUTING.md](CONTRIBUTING.md) file for more details.

## Acknowledgements

The following people have contributed to this project:

- [Yasir Arafat Aronno](https://github.com/AronnoDIU)

## Contact

If you have any questions or comments, 
please feel free to contact us at <br>
[https://www.linkedin.com/in/yeasirarafataronno/].

## Conclusion

Thank you for using the Bank System. I hope you enjoy using it. Happy coding!

## License

This project is licensed under the MIT License.