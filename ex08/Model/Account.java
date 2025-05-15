package ex08.Model;

// Model, POJO, ValueClass
public class Account {
    private int number;
    private String owner;
    private double balance;

    public Account(int number, String owner, double balance) {
        this.number = number;
        this.owner = owner;
        this.balance = balance;
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

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account clone() {
        return new Account(number, owner, balance);
    }

    @Override
    public String toString() {
        return String.format("[%d] %s (%.2f)", number, owner, balance);
        //return "[" + number + "] " + owner + " (" + balance + ")";
    }
}
