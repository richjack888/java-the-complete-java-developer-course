import java.util.ArrayList;

public class Customer {
    ArrayList<Double> transactions;
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


}
