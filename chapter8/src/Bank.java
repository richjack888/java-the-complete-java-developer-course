import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<Branch>();
    }

    public String getName() {
        return name;
    }

    public boolean printBranches() {
        if (branches.size() == 0) {
            System.out.println("Please add branch first!\nDon't have any branch now.");
            return false;
        }
        System.out.println(getName() + " had " + branches.size() + " branches.");
        for (int i = 0; i < branches.size(); i++) {
            System.out.println(getName() + " No." + (i + 1) +
                    " branch code (" + branches.get(i).getName() + ")");

        }
        return true;
    }

    public boolean addNewCustomer(String branchName, String customerName, double initialAmount) {
        if (findBranch(branchName) >= 0) {
            Branch branch = queryBranch(branchName);
            if (branch.addCustomer(customerName, initialAmount)) {
                return true;
            }
        }
        return false;
    }

    public boolean addNewBranch(String branchName) {
        if (findBranch(branchName) >= 0) {
            return false;
        }
        branches.add(Branch.createBranch(branchName));
        return true;
    }

    private int findBranch(String branchName) {
        for (int i = 0; i < branches.size(); i++) {
            Branch branch = branches.get(i);
            if (branch.getName().equals(branchName)) {
                return i;
            }
        }
        return -1;
    }

    public Branch queryBranch(String BranchName) {
        int position = findBranch(BranchName);
        if (position >= 0) {
            return branches.get(position);
        }
        return null;
    }

    public void printBranchCustomer(String BranchName) {
        queryBranch(BranchName).printCustomer();

    }

    public boolean customersTransaction(String branchA, String customerA, String branchB, String customerB, Double amount) {
        if (findBranch(branchA) >= 0 && findBranch(branchB) >= 0) {
            Branch branch_A = queryBranch(branchA);
            Branch branch_B = queryBranch(branchB);
            if (branch_A.queryCustomer(customerA) != null && branch_B.queryCustomer(customerB) != null) {
                Customer customerPay = branch_A.queryCustomer(customerA);
                if (customerPay.getBalance() >= amount) {
                    customerPay.getTransactions().add(-amount);
                    Customer customerReceive = branch_B.queryCustomer(customerB);
                    customerReceive.getTransactions().add(amount);
                    return true;
                }
            }
        }
        return false;
    }


}
