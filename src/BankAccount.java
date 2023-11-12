class BankAccount {
    private final String accountNumber;
    private final String accountHolder;
    private double accountBalance;


    // New method to convert account data to a CSV string
    public String toCSVString() {
        return accountNumber + "," + accountHolder + "," + accountBalance;
    }

    // New constructor to create a BankAccount from a CSV string
    public BankAccount(String csv) {
        String[] data = csv.split(",");
        this.accountNumber = data[0];
        this.accountHolder = data[1];
        this.accountBalance = Double.parseDouble(data[2]);
    }

    public BankAccount(String accountNumber, String accountHolder, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.accountBalance = accountBalance;
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
        displayBalance();
    }

    public void withdraw(double amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds");
        }
        displayBalance();
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

    public double getBalance() {
        return 0;
    }
}