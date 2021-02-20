import java.util.ArrayList;

public class Branch {
    private ArrayList<Customer> customers;
    private int BranchName;
    private double transcation_amount;

    public Branch(int BranchName) {
        this.BranchName = BranchName;
        this.customers = new ArrayList<Customer>();
    }

    public boolean addCustomer(Customer customer) {
        if (findCustomer(customer.getName()) >= 0) {
            System.out.println("customer is already on file.");
            return false;
        }
        customers.add(customer);

        return true;

    }

    private int findCustomer(String customerName) {
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.getName().equals(customerName)) {
                return i;
            }
        }
        return -1;
    }
}
