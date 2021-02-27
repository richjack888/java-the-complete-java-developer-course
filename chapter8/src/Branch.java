import java.util.ArrayList;

public class Branch {
    private ArrayList<Customer> customers;
    private String name;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<Customer>();
    }

    public static Branch createBranch(String BranchCode) {
        return new Branch(BranchCode);
    }

    public String getName() {
        return name;
    }

    public boolean addCustomer(String customerName, double initialAmount) {
        if (findCustomer(customerName) >= 0) {
            return false;
        }
        customers.add(Customer.createCustomer(customerName, initialAmount));
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

    public Customer queryCustomer(String customerName) {
        int position = findCustomer(customerName);
        if (position >= 0) {
            return customers.get(position);
        }
        return null;
    }

    public void printCustomer() {
        System.out.println("Branch code [" + getName() + "] --- list of customer: ");
        if (customers.size() != 0) {
            for (int i = 0; i < customers.size(); i++) {
                System.out.println("No." + (i + 1) + " Customer: " + customers.get(i).getName());
                System.out.println("Transaction record: ");
                customers.get(i).transaction_record();
                System.out.println("Total balance: \n$" + customers.get(i).getBalance());
            }
        } else {
            System.out.println("Please add customer to branch.\nDon't have any customer now!");
        }
    }


}
