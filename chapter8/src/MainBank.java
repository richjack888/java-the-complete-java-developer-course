import java.util.Scanner;

public class MainBank {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("CityBank");

    public static void main(String[] args) {
        boolean quit = false;
        startBank();
        printActions();
        while (!quit) {
            System.out.println("------------------------------------");
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
                    transaction();
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
        String branchName = scanner.nextLine();
        if (bank.addNewBranch(branchName)) {
            System.out.println("Successful! New branch code [" + branchName + "] be added to " + bank.getName());
        } else {
            System.out.println("Error! Cannot add branch code [" + branchName + "] to \" + bank.getName())");
            System.out.println("Branch code [" + branchName + "] already in " + bank.getName());
        }
        System.out.println("addNewBranch function out!");
    }

    private static void addNewCustomer() {
        System.out.println("This function is addNewCustomer");
        if (bank.printBranches()) {
            System.out.println("Which branch need to add new customer?\nEnter branch code: ");
            String branchName = scanner.nextLine();
            if (bank.queryBranch(branchName) != null) {
                System.out.println("Enter new customer name: ");
                String customerName = scanner.nextLine();
                System.out.println("How much initial amount do you want to set?");
                double initialAmount = scanner.nextDouble();
                scanner.nextLine();
                if (bank.addNewCustomer(branchName, customerName, initialAmount)) {
                    System.out.println("Successful! New customer: " + customerName + " be added  to branch code [" + branchName + "]");
                } else {
                    System.out.println("Error! Cannot add " + customerName + " to branch code [" + branchName + "].");
                    System.out.println("Customer already in that branch.");
                }
            } else {
                System.out.println("Error! Branch code [" + branchName + "] doesn't exist!");
            }
        }
        System.out.println("addNewCustomer function out!");
    }

    private static void transaction() {
        System.out.println("This function is transaction");
        if (bank.printBranches()) {
            System.out.println("A pay $amount to B");
            System.out.println("Enter customer A -> branch code: ");
            String branchA = scanner.nextLine();
            if (bank.queryBranch(branchA) != null) {
                Branch branch_A = bank.queryBranch(branchA);
                System.out.println("Enter customer A -> name: ");
                String customerA = scanner.nextLine();
                if (branch_A.queryCustomer(customerA) != null) {
                    Customer customer_A = branch_A.queryCustomer(customerA);
                    System.out.println("Pay how much?");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    if (customer_A.getBalance() >= amount) {
                        System.out.println("Enter customer B -> branch code: ");
                        String branchB = scanner.nextLine();
                        if (bank.queryBranch(branchB) != null) {
                            Branch branch_B = bank.queryBranch(branchB);
                            System.out.println("Enter customer B -> name: ");
                            String customerB = scanner.nextLine();
                            if (branch_B.queryCustomer(customerB) != null) {
                                if (bank.customersTransaction(branchA, customerA, branchB, customerB, amount)) {
                                    System.out.println("Successful!");
                                    System.out.println(customerA + " pay $" + amount + " to " + customerB);
                                } else {
                                    System.out.println("Error, transaction failed!");
                                }
                            } else {
                                System.out.println("Error! " + customerB + " doesn't exist in branch code [" + branchB + "]");
                            }
                        } else {
                            System.out.println("Error! Branch code [" + branchB + "] doesn't exist!");
                        }
                    } else {
                        System.out.println("Error! " + customerA + " balance isn't enough!");
                    }
                } else {
                    System.out.println("Error! " + customerA + " doesn't exist in branch code [" + branchA + "]");
                }
            } else {
                System.out.println("Error! Branch code [" + branchA + "] doesn't exist!");
            }
        }
        System.out.println("transaction function out!");
    }

    private static void printCustomer() {
        System.out.println("This function is printCustomer");
        if (bank.printBranches()) {
            System.out.println("Which branch need to print all customer?\nEnter branch code: ");
            String branchName = scanner.nextLine();
            if (bank.queryBranch(branchName) != null) {
                bank.printBranchCustomer(branchName);
            } else {
                System.out.println("Error! Branch code [" + branchName + "] doesn't exist!");
            }
        }
        System.out.println("printCustomer function out!");
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
