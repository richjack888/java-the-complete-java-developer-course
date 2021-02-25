import java.util.ArrayList;

public class Branch_TimVersion {
    private String name;
    private ArrayList<Customer_TimVersion> customers;

    public Branch_TimVersion(String name) {
        this.name = name;
        customers = new ArrayList<Customer_TimVersion>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer_TimVersion> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialAmount) {
        if (findCustomer(customerName) == null) {
            customers.add(new Customer_TimVersion(customerName, initialAmount));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer_TimVersion existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    private Customer_TimVersion findCustomer(String customerName) {
        for (int i = 0; i < customers.size(); i++) {
            Customer_TimVersion checkCustomer = customers.get(i);
            if (checkCustomer.getName().equals(customerName)) {
                return checkCustomer;
            }
        }
        return null;
    }
}
