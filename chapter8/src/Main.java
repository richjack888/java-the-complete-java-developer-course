import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    processArrayList();
                    break;
                case 7:
                    quit = true;
                    System.out.println("Good bye!");
                    break;
            }
        }

    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit the application.");
    }

    private static void addItem() {
        System.out.println("This is add item function.");
        System.out.println("Please enter item name to add: ");
        String item = scanner.nextLine();
        groceryList.addGroceryItem(item);

    }

    private static void modifyItem() {
        System.out.println("This is modify item function.");
        System.out.println("Enter current item name: ");
        String item = scanner.nextLine();
        if (groceryList.onFile(item)) {
            System.out.println("Enter replacement item to modify: ");
            String newItem = scanner.nextLine();
            groceryList.modifyGroceryItem(item, newItem);
        } else {
            System.out.println(item + " is not in grocery list");
        }

    }

    private static void removeItem() {
        System.out.println("This is remove item function.");
        groceryList.printGroceryList();
        System.out.println("Enter item name to remove: ");
        String item = scanner.nextLine();
        groceryList.removeGroceryItem(item);
    }

    private static void searchItem() {
        System.out.println("This is search item function.");
        System.out.println("Enter Item to search: ");
        String searchItem = scanner.nextLine();
        if (groceryList.onFile(searchItem)) {
            System.out.println("found item: " + searchItem);
        } else {
            System.out.println("Not found: " + searchItem);
        }

    }

    public static void processArrayList() {
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList());

        // same as line 101~102
        ArrayList<String> newArray2 = new ArrayList<String>(groceryList.getGroceryList());

        // ArrayList convert to normal array
        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }


}
