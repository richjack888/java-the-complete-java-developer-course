import java.util.ArrayList;

public class Bank_TimVersion {
    private String name;
    private ArrayList<Branch_TimVersion> branches;

    public Bank_TimVersion(String name) {
        this.name = name;
        branches = new ArrayList<Branch_TimVersion>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            branches.add(new Branch_TimVersion(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch_TimVersion branch = findBranch(branchName);
        if (branchName != null && branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch_TimVersion branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    private Branch_TimVersion findBranch(String branchName) {
        for (int i = 0; i < branches.size(); i++) {
            Branch_TimVersion Branch = branches.get(i);
            if (Branch.getName().equals(branchName)) {
                return Branch;
            }
        }
        return null;
    }

    public boolean listCustomer(String branchName, boolean showTransaction) {
        Branch_TimVersion branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getName());

            ArrayList<Customer_TimVersion> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer_TimVersion branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i + 1) + "]");
                if (showTransaction) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "]" + "Amount " + transactions.get(j));

                    }
                }
            }
            return true;
        }
        return false;
    }
}

