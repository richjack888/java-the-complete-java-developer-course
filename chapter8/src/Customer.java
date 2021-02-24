import java.util.ArrayList;

public class Customer {
    private ArrayList<Double> transactions;
    private String name;

    public Customer(String name) {
        this.name = name;
        transactions = new ArrayList<Double>();
    }

    public static Customer createCustomer(String name) {
        return new Customer(name);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void transaction_record() {
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println((i + 1) + " : " + transactions.get(i));
        }
    }

    public double countBalance() {
        double balance = 0;
        for (int i = 0; i < transactions.size(); i++) {
            balance += transactions.get(i).doubleValue();
        }
        return balance;
    }
}
