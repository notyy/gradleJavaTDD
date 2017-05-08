package account;

public class Account {
    private String owner;
    private double balance;

    public Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void dec(double money) {
        this.balance -= money;
    }

    public void inc(double money) {
        this.balance += money;
    }

    public String getOwner() {
        return owner;
    }
}
