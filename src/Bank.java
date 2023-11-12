import java.util.ArrayList;

class Bank {
    private final ArrayList<BankAccount> accounts; // List of bank accounts in the bank

    public Bank() {
        // Initialize the list of bank accounts as an empty arraylist.
        this.accounts = new ArrayList<>();
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
}
