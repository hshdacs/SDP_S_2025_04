package ex09.model;

// Model, POJO, ValueClass
public class Account {
    private int number;
    private String owner;
    private double balance;
    private AccountType accountType;

    public Account(int number, String owner, double balance, AccountType accountType) {
        this.number = number;
        this.owner = owner;
        this.balance = balance;
        this.accountType = accountType;
    }

    public int getNumber() {
        return number;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Account clone() {
        return new Account(number, owner, balance, accountType);
    }

    @Override
    public String toString() {
        return String.format("[%d] %s (%.2f) %s",
         number, owner, balance, accountType);
        //return "[" + number + "] " + owner + " (" + balance + ")";
    }
}
