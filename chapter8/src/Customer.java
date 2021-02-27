import java.util.ArrayList;

public class Customer {
    private ArrayList<Double> transactions;
    private String name;

    public Customer(String name, double initialAmount) {
        this.name = name;
        transactions = new ArrayList<Double>();
        addTransaction(initialAmount);
    }

    public static Customer createCustomer(String name, double initialAmount) {
        return new Customer(name, initialAmount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double amount) {
        transactions.add(amount);
    }

    public void transaction_record() {
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println((i + 1) + " : " + transactions.get(i));
        }
    }

    public double getBalance() {
        double balance = 0;
        for (Double transaction : transactions) {
            balance += transaction;
        }
        return balance;
    }
}
