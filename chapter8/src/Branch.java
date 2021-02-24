import java.util.ArrayList;

public class Branch {
    private ArrayList<Customer> customers;
    private String BranchCode;

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


    public void customersTransaction(Customer customerA, Customer customerB, Double amount) {
        customerA.getTransactions().add(-amount);
        customerB.getTransactions().add(amount);
    }

    public boolean addCustomer(Customer customer) {
        if (findCustomer(customer.getName()) >= 0) {
            System.out.println("customer is already on file.");
            return false;
        }
        customers.add(customer);
        double initial_amount = 10000;
        customer.getTransactions().add(initial_amount);
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

    public Customer queryCustomer(String customerName) {
        int position = findCustomer(customerName);
        if (position >= 0) {
            return customers.get(position);
        }
        return null;
    }

    public double checkBalance(String customerName) {
        Customer customer = queryCustomer(customerName);
        return customer.countBalance();
    }

    public void printCustomer() {
        System.out.println("Branch code(" + getBranchCode() + "), list of customer: ");
        if (customers.size() != 0) {
            for (int i = 0; i < customers.size(); i++) {
                System.out.println("No." + (i + 1) + " Customer: " + customers.get(i).getName());
                System.out.println("Transaction record: ");
                customers.get(i).transaction_record();
                System.out.println("Total balance: \n$" + customers.get(i).countBalance());
            }
        } else {
            System.out.println("Please add customer to branch.\nDon't have any customer now!");
        }
    }


}
