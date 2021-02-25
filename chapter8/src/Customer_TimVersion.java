import java.util.ArrayList;

public class Customer_TimVersion {
    private String name;
    private ArrayList<Double> transactions;

    public Customer_TimVersion(String name, double initialAmount) {
        this.name = name;
        transactions = new ArrayList<Double>();
        addTransaction(initialAmount);
    }

    public void addTransaction(double amount) {
        transactions.add(amount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
