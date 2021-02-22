import java.util.ArrayList;

public class Bank {
    private static String BankName;
    private static ArrayList<Branch> branches;

    public Bank(String bankName) {
        BankName = bankName;
        branches = new ArrayList<Branch>();
    }

    public static void main(String[] args) {
        Bank bank = new Bank("CityBank");
        bank.addBranch("124");
        bank.addBranchCustomer("124", "Steam");
        bank.showBranchCustomer("124");


    }

    public static String getBankName() {
        return BankName;
    }

    public static ArrayList<Branch> getBranches() {
        return branches;
    }

    private static void showAllBranch() {
        System.out.println("This function is showAllBranch.");
        if (branches.size() == 0) {
            System.out.println("You don't have any branch now.");
            return;
        }
        System.out.println(getBankName() + " had " + branches.size() + " branches.");
        for (int i = 0; i < branches.size(); i++) {
            System.out.println(getBankName() + " No." + (i + 1) +
                    " branch code(" + branches.get(i).getBranchCode() + ")");

        }
    }

    private void addBranch(String BranchCode) {
        System.out.println("This function is addBranch.");
        branches.add(Branch.createBranch(BranchCode));
    }

    private void addBranchCustomer(String branchCode, String name) {
        System.out.println("This function is addBranchCustomer.");
        Customer customer = new Customer(name);
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getBranchCode().equals(branchCode)) {
                branches.get(i).addCustomer(customer);
            }

        }
    }

    private void transaction() {
        System.out.println("This function is transaction.");
        // need to validate
    }

    private void showBranchCustomer(String branchCode) {
        for (int i = 0; i < branches.size(); i++) {
            ;
            if (branches.get(i).getBranchCode().equals(branchCode)) {
                for (i = 0; i < branches.get(i).getCustomers().size(); i++) {
                    System.out.println(branches.get(i).getCustomers());
                }
            }

        }
    }


}
