import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0988-321-123");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("Enter number to action: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    quit = true;
                    System.out.println("Good bye!");
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;

            }
        }

    }

    public static void addNewContact() {
        System.out.println("This is x function.");
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContacts(name, phone);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: " + name + ", phone = " + phone);
        } else {
            System.out.println("Cannot add, " + name + " already phone...");
        }

    }

    private static void updateContact() {
        System.out.println("This is updateContact function.");
    }

    private static void removeContact() {
        System.out.println("This is removeContact function.");
    }

    private static void queryContact() {
        System.out.println("This is queryContact function.");
    }


    private static void startPhone() {
        System.out.println("Start phone ------");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to shutdown\n" +
                "1  - to print contacts\n" +
                "2  - to add a new contact\n" +
                "3  - to update existing an existing contact\n" +
                "4  - to remove an existing contact\n" +
                "5  - query if an existing contact exists\n" +
                "6  - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }


}
