public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;  // Withdrawal successful
        }
        return false;  // Withdrawal failed
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;  // Deposit successful
        }
        return false;  // Deposit failed
    }
}
