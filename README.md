# Banking System

This is a simple banking system implemented in Java (Console Application).

## Classes

### BankSystemMain

The `BankSystemMain` class is the entry point of the application. It contains the main method that starts the banking system.

### BankAccount

The `BankAccount` class represents a bank account. It has the following attributes and methods:

#### Attributes

- `account_number`: The account number of the bank account.
- `balance`: The current balance of the bank account.

#### Methods

- `deposit(amount)`: Deposits the specified amount into the bank account.
- `withdraw(amount)`: Withdraws the specified amount from the bank account.
- `get_balance()`: Returns the current balance of the bank account.

### Bank

The `Bank` class represents a bank. It has the following attributes and methods:

#### Attributes

- `name`: The name of the bank.
- `accounts`: A list of bank accounts associated with the bank.

#### Methods

- `add_account(account)`: Adds a bank account to the bank.
- `remove_account(account)`: Removes a bank account from the bank.
- `get_total_balance()`: Returns the total balance of all bank accounts in the bank.

## Usage

To use the banking system, you can follow these steps:

1. Create an instance of the `Bank` class.
2. Create instances of the `BankAccount` class for each bank account.
3. Add the bank accounts to the bank using the `add_account` method.
4. Use the methods of the `BankAccount` class to perform operations such as depositing and withdrawing money.
5. Use the methods of the `Bank` class to manage the bank accounts and get the total balance.

## License

This project is licensed under the MIT License.