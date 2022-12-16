import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private double balance;
    private final String accountNumber;
    private final Lock lock;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

//    public void deposit(double amount) {
//            balance += amount;
//    }
//
//    public void withdraw(double amount) {
//            balance -= amount;
//    }

//    public synchronized void deposit(double amount) {
//        balance += amount;
//    }
//
//    public synchronized void withdraw(double amount) {
//        balance -= amount;
//    }


//    public void deposit(double amount) {
//        synchronized (this) {
//            balance += amount;
//        }
//    }
//
//    public void withdraw(double amount) {
//        synchronized (this) {
//            balance -= amount;
//        }
//    }

//    public void deposit(double amount) {
//        lock.lock();
//        try {
//            balance += amount;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public void withdraw(double amount) {
//        lock.lock();
//        try {
//            balance -= amount;
//        } finally {
//            lock.unlock();
//        }
//    }

//    public void deposit(double amount) {
//        try {
//            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
//                try {
//                    balance += amount;
//                } finally {
//                    lock.unlock();
//                }
//            } else {
//                System.out.println("Could not get the lock");
//            }
//        } catch (InterruptedException ignored) {
//
//        }
//    }
//
//    public void withdraw(double amount) {
//        try {
//            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
//                try {
//                    balance -= amount;
//                } finally {
//                    lock.unlock();
//                }
//            } else {
//                System.out.println("Could not get the lock");
//            }
//        } catch (InterruptedException ignored) {
//
//        }
//    }

    public void deposit(double amount) {
        boolean status = false;
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException ignored) {

        }
        System.out.println("Transaction status is: " + status);
    }

    public void withdraw(double amount) {
        boolean status = false;
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException ignored) {

        }
        System.out.println("Transaction status is: " + status);
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void printBalance() {
        System.out.println(getAccountNumber() + ": " + balance);
    }


}