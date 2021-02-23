import java.util.ArrayList;

public class Branch {
    private ArrayList<Customer> customers;
    private String BranchCode;
    private double transaction_amount;

    public Branch(String BranchCode) {
        this.BranchCode = BranchCode;
        customers = new ArrayList<Customer>();
    }

    public static Branch createBranch(String BranchCode) {
        return new Branch(BranchCode);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public String getBranchCode() {
        return BranchCode;
    }

    public double getTransaction_amount() {
        return transaction_amount;
    }

    public boolean addCustomer(Customer customer) {
        if (findCustomer(customer.getName()) >= 0) {
            System.out.println("customer is already on file.");
            return false;
        }
        customers.add(customer);
        return true;
    }

    public int findCustomer(String customerName) {
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.getName().equals(customerName)) {
                return i;
            }
        }
        return -1;
    }

    public void printCustomer() {
        System.out.println("Branch code(" + getBranchCode() + "), list of customer: ");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println("No." + (i + 1) + " Customer: " + customers.get(i).getName());
        }
    }
}
