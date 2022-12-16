import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Challenge7 {

    public static void main(String[] args) throws InterruptedException {
        BankAccount7 account1 = new BankAccount7("12345-678", 500.00);
        BankAccount7 account2 = new BankAccount7("98765-432", 1000.00);

        new Thread(new Transfer(account1, account2, 100.00), "Transfer1").start();
        new Thread(new Transfer(account2, account1, 200.00), "Transfer2").start();

        Thread.sleep(1000);
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
    }
}

class BankAccount7 {
    private double balance;
    private String accountNumber;
    private Lock lock = new ReentrantLock();

    BankAccount7(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public boolean withdraw(double amount) {
        if (lock.tryLock()) {
            try {
                try {
                    // Simulate database access
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
                balance -= amount;
                System.out.printf("%s: Deposited %f\n", Thread.currentThread().getName(), amount);
                return true;
            } finally {
                lock.unlock();
            }
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (lock.tryLock()) {
            try {
                try {
                    // Simulate database access
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
                balance += amount;
                System.out.printf("%s: Deposited %f\n", Thread.currentThread().getName(), amount);
                return true;
            } finally {
                lock.unlock();
            }
        }
        return false;
    }

    public boolean transfer(BankAccount7 destinationAccount, double amount) {
        if (withdraw(amount)) {
            if (destinationAccount.deposit(amount)) {
                return true;
            } else {
                // The deposit failed. Refund the money back into the account.
                System.out.printf("%s: Destination account busy. Refunding money\n",
                        Thread.currentThread().getName());
                while (!deposit(amount)) {
                    continue;
                }

            }
        }

        return false;
    }

    public double getBalance() {
        return balance;
    }
}

class Transfer implements Runnable {
    private BankAccount7 sourceAccount, destinationAccount;
    private double amount;

    Transfer(BankAccount7 sourceAccount, BankAccount7 destinationAccount, double amount) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void run() {
        while (!sourceAccount.transfer(destinationAccount, amount)) {
            continue;
        }
        System.out.printf("%s completed\n", Thread.currentThread().getName());


    }
}
