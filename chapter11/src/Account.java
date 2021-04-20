import java.util.ArrayList;

public class Account {
    private String accountName;
    private int balance = 0;
    private ArrayList<Integer> transactions;

    public Account(String accountName) {
        System.out.println(accountName + "'s account was created. Balance is now 0.");
        this.accountName = accountName;
        this.transactions = new ArrayList<Integer>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            transactions.add(amount);
            this.balance += amount;
            System.out.println(amount + " deposited. Balance is now " + this.balance + ".");
        } else {
            System.out.println("Cannot deposit negative amount!");
        }
    }

    public void withdraw(int amount) {
        int withdraw = -amount;
        if (withdraw < 0) {
            this.transactions.add(withdraw);
            this.balance += withdraw;
            System.out.println(amount + " withdraw. Balance is now " + this.balance + ".");
        } else {
            System.out.println("Cannot with draw negative amount!");
        }
    }

    public void calculateBalance() {
        this.balance = 0;
        for (int i : this.transactions) {
            this.balance += i;
        }
        System.out.println("Calculated balance is " + this.balance + ".");
    }
}
