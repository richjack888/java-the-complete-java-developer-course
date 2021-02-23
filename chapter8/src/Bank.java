import java.util.ArrayList;

public class Bank {
    private static String BankName;
    private static ArrayList<Branch> branches;

    public Bank(String bankName) {
        BankName = bankName;
        branches = new ArrayList<Branch>();
    }

    public static String getBankName() {
        return BankName;
    }

    public static ArrayList<Branch> getBranches() {
        return branches;
    }

    public boolean printBranches() {
        if (branches.size() == 0) {
            System.out.println("You don't have any branch now.");
            return false;
        }
        System.out.println(getBankName() + " had " + branches.size() + " branches.");
        for (int i = 0; i < branches.size(); i++) {
            System.out.println(getBankName() + " No." + (i + 1) +
                    " branch code(" + branches.get(i).getBranchCode() + ")");

        }
        return true;
    }

    public boolean addNewCustomer(Branch branch, String customerName) {
        Customer customer = new Customer(customerName);
        return branch.addCustomer(customer);
    }

    public boolean addNewBranch(Branch branch) {
        if (findBranch(branch.getBranchCode()) >= 0) {
            System.out.println("That branch is already on file.");
            return false;
        }
        branches.add(branch);
        return true;
    }

    public int findBranch(String branchName) {
        for (int i = 0; i < branches.size(); i++) {
            Branch branch = branches.get(i);
            if (branch.getBranchCode().equals(branchName)) {
                return i;
            }
        }
        return -1;
    }


    public void printBranchCustomer(String BranchName) {
        if (queryBranch(BranchName) != null) {
            queryBranch(BranchName).printCustomer();
        }
    }

    public Branch queryBranch(String BranchName) {
        int position = findBranch(BranchName);
        if (position >= 0) {
            return branches.get(position);
        }
        return null;
    }


}
