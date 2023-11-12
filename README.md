# Banking System

A simple console-based bank account system that allows users to perform basic banking operations.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Classes](#classes)
    - [BankSystemMain](#banksystemmain)
    - [BankAccount](#bankaccount)
    - [Bank](#bank)
- [Usage](#usage)
- [Contributing](#contributing)
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
- **Deposit**: Account holders can deposit funds into their accounts by specifying the account number and the amount to be deposited.
- **Withdrawal**: Users can withdraw funds from their accounts by entering the account number and the amount to be withdrawn. The system verifies if the account has sufficient balance before allowing the withdrawal.
- **Account Balance**: Account holders can check their account balance by entering their account number.
- **Fund Transfer**: Users can transfer funds from one account to another by specifying the source account number, destination account number, and the transfer amount. The system verifies the account balances before processing the transfer.
- **Account Close**: Users can close their accounts by entering their account number.
- **Account Information**: Users can view their account information by entering their account number.
- **Account History**: Users can view their account history by entering their account number.
- **Account Summary**: Users can view a summary of their accounts by entering their name.
- **Exit**: Users can exit the application by entering the exit command.
- **Help**: Users can view the list of available features and commands by entering the help command.

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
- `createAccount()`: Creates a new bank account.
- `depositFunds()`: Deposits funds into an account.
- `withdrawFunds()`: Withdraws funds from an account.
- `checkBalance()`: Checks the balance of an account.
- `transferFunds()`: Transfers funds between accounts.
- `closeAccount()`: Closes an account.
- `displayAccountInfo()`: Displays account information.
- `displayAccountHistory()`: Displays account history.
- `displayAccountSummary()`: Displays account summary.
- `exit()`: Exits the application.
- `help()`: Displays the list of available commands.
- `showMenu()`: Displays the main menu.
- `readInput()`: Reads user input.
- `displayErrorMessage(String message)`: Displays an error message.
- `displaySuccessMessage(String message)`: Displays a success message.
- `displayInfoMessage(String message)`: Displays an information message.
- `displayWarningMessage(String message)`: Displays a warning message.
- `displayExceptionMessage(String message)`: Displays an exception message.

### BankAccount

The `BankAccount` class represents a bank account. It has the following attributes and methods:

#### Constructors

- `BankAccount(String name, double initialDeposit, String accountType)`: Creates a new bank account with the specified name, initial deposit amount, and account type.
- `BankAccount(String name, double initialDeposit)`: Creates a new bank account with the specified name and initial deposit amount.
- `BankAccount(String name)`: Creates a new bank account with the specified name.
- `BankAccount()`: Creates a new bank account.
- `BankAccount(String name, String accountType)`: Creates a new bank account with the specified name and account type.

#### Methods

- `getName()`: Returns the name of the bank account.
- `getAccountType()`: Returns the type of the bank account.
- `getAccountNumber()`: Returns the account number of the bank account.
- `getAccountHolderName()`: Returns the account holder name of the bank account.
- `getAccountBalance()`: Returns the current balance of the bank account.
- `deposit(double amount)`: Deposits the specified amount into the bank account.
- `withdraw(double amount)`: Withdraws the specified amount from the bank account.
- `closeAccount()`: Closes the bank account.
- `displayBalance()`: Displays the current balance of the bank account.
- `displayAccountInfo()`: Displays the account information.
- `displayAccountHistory()`: Displays the account history.
- `displayAccountSummary()`: Displays the account summary.
- `toString()`: Returns a string representation of the bank account.
- `equals(Object obj)`: Checks if the specified object is equal to the current bank account.
- `hashCode()`: Returns a hash code value for the current bank account.
- `compareTo(BankAccount otherAccount)`: Compares the current bank account with the specified bank account.

### BankAccountInterface

The `BankAccountInterface` interface represents the interface of the bank account. It has the following methods:

#### Methods

- `getName()`: Returns the name of the bank account.
- `getAccountType()`: Returns the type of the bank account.
- `getAccountNumber()`: Returns the account number of the bank account.
- `getAccountHolderName()`: Returns the account holder name of the bank account.
- `getAccountBalance()`: Returns the current balance of the bank account.
- `deposit(double amount)`: Deposits the specified amount into the bank account.
- `withdraw(double amount)`: Withdraws the specified amount from the bank account.
- `closeAccount()`: Closes the bank account.
- `displayBalance()`: Displays the current balance of the bank account.
- `displayAccountInfo()`: Displays the account information.
- `displayAccountHistory()`: Displays the account history.
- `displayAccountSummary()`: Displays the account summary.

### BankAccountImpl

The `BankAccountImpl` class represents an implementation of the bank account. It has the following attributes and methods:

#### Constructors

- `BankAccountImpl(String name, double initialDeposit, String accountType)`: Creates a new bank account with the specified name, initial deposit amount, and account type.
- `BankAccountImpl(String name, double initialDeposit)`: Creates a new bank account with the specified name and initial deposit amount.
- `BankAccountImpl(String name)`: Creates a new bank account with the specified name.
- `BankAccountImpl()`: Creates a new bank account.

#### Attributes

- `account_number`: The account number of the bank account.
- `balance`: The current balance of the bank account.
- `account_holder_name`: The name of the account holder.
- `account_type`: The type of the bank account.
- `history`: The account history of the bank account.
- `summary`: The account summary of the bank account.
- `name`: The name of the bank account.
- `initial_deposit`: The initial deposit amount of the bank account.

#### Methods

- `deposit(amount)`: Deposits the specified amount into the bank account.
- `withdraw(amount)`: Withdraws the specified amount from the bank account.
- `get_balance()`: Returns the current balance of the bank account.
- `close_account()`: Closes the bank account.
- `display_balance()`: Displays the current balance of the bank account.
- `display_account_info()`: Displays the account information.
- `display_account_history()`: Displays the account history.
- `display_account_summary()`: Displays the account summary.

### Bank

The `Bank` class represents a bank. It has the following attributes and methods:

#### Constructors

- `Bank(String name)`: Creates a new bank with the specified name.
- `Bank()`: Creates a new bank.
- `Bank(String name, List<BankAccount> accounts)`: Creates a new bank with the specified name and bank accounts.
- `Bank(List<BankAccount> accounts)`: Creates a new bank with the specified bank accounts.
- `Bank(List<BankAccount> accounts)`: Creates a new bank with the specified bank accounts.

#### Attributes

- `name`: The name of the bank.
- `accounts`: A list of bank accounts associated with the bank.
- `total_balance`: The total balance of all bank accounts in the bank.
- `history`: The account history of the bank.
- `summary`: The account summary of the bank.

#### Methods

- `add_account(account)`: Adds a bank account to the bank.
- `remove_account(account)`: Removes a bank account from the bank.
- `get_total_balance()`: Returns the total balance of all bank accounts in the bank.
- `get_history()`: Returns the account history of the bank.
- `get_summary()`: Returns the account summary of the bank.
- `get_name()`: Returns the name of the bank.
- `get_accounts()`: Returns the list of bank accounts associated with the bank.

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
15. Use the `display_account_summary` method to display the account summary of the bank.

## License

This project is licensed under the MIT License.