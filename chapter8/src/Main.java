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
        System.out.println("This is addNewContact function.");
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
        System.out.println("Enter existing name to update: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Enter new contact name");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContacts(newName, newNumber);
        if (mobilePhone.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated record.");
        } else {
            System.out.println("Error updated.");
        }
    }


    private static void removeContact() {
        System.out.println("This is removeContact function.");
        System.out.println("Enter existing name to remove: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        if (mobilePhone.removeContact(existingContactRecord)) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }
    }

    private static void queryContact() {
        System.out.println("This is queryContact function.");
        System.out.println("Enter existing name to query: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name: " + existingContactRecord.getName() + " phone number is " + existingContactRecord.getPhoneNumber());
    }


    private static void startPhone() {
        System.out.println("Start phone ------");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\nPress number of list.");
        System.out.println("0  - to shutdown\n" +
                "1  - to print contacts\n" +
                "2  - to add a new contact\n" +
                "3  - to update an existing contact\n" +
                "4  - to remove an existing contact\n" +
                "5  - query if an existing contact exists\n" +
                "6  - to print a list of available actions.");
    }


}
