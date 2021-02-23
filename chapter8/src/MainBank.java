import java.util.Scanner;

public class MainBank {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("CityBank");

    {
        System.out.println("Cannot find that branch");
    }

    public static void main(String[] args) {
        boolean quit = false;
        startBank();
        printActions();
        while (!quit) {
            System.out.println("------");
            System.out.println("Enter number to action: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    quit = true;
                    System.out.println("Thank you, Good bye!");
                    break;
                case 1:
                    bank.printBranches();
                    break;
                case 2:
                    addNewBranch();
                    break;
                case 3:
                    addNewCustomer();
                    break;
                case 4:
                    addTransaction();
                    break;
                case 5:
                    printCustomer();
                    break;
                case 6:
                    printActions();
                    break;

            }
        }

    }

    private static void addNewBranch() {
        System.out.println("This function is addNewBranch");
        System.out.println("Enter new branch code: ");
        Branch branch = Branch.createBranch(scanner.nextLine());
        if (bank.addNewBranch(branch)) {
            System.out.println("Successful! New branch code: " + branch.getBranchCode() + " be added");
        } else {
            System.out.println("Error! Cannot add branch code " + branch.getBranchCode() + " already had...");
        }
    }

    private static void addNewCustomer() {
        System.out.println("This function is addNewCustomer");
        if (bank.printBranches()) {
            System.out.println("Which branch need to add new customer?\nEnter branch code: ");
            String branchName = scanner.nextLine();
            Branch branch = bank.queryBranch(branchName);
            if (bank.findBranch(branchName) >= 0) {
                System.out.println("Enter new customer name: ");
                String customerName = scanner.nextLine();
                if (bank.addNewCustomer(branch, customerName)) {
                    System.out.println("Successful! New customer: " + customerName + " be added  to branch code: " + branchName);
                } else {
                    System.out.println("Cannot add new customer " + customerName + " to branch code " + branchName);
                }
            } else {
                System.out.println("Error! Branch(" + branchName + ") doesn't exist!");
            }
        }
    }

    private static void addTransaction() {
        System.out.println("This function is addTransaction");

    }

    private static void printCustomer() {
        System.out.println("This function is printCustomer");
        if (bank.printBranches()) {
            System.out.println("Which branch need to print all customer?\nEnter branch code: ");
            String branchName = scanner.nextLine();
            bank.printBranchCustomer(branchName);
        }
        ;

    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\nPress number of list.");
        System.out.println("0  - to shutdown\n" +
                "1  - to print branches\n" +
                "2  - to add a new branch\n" +
                "3  - to add a new customer\n" +
                "4  - to add a transaction\n" +
                "5  - to print customer list of branch\n" +
                "6  - to print action.");
    }


    private static void startBank() {
        System.out.println("Start Bank app ------");
    }


}
