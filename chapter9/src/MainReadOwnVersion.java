import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainReadOwnVersion {
    List<ISaveable> files = new ArrayList<ISaveable>();

    public static void menu() {
        System.out.println("Choose\n" +
                "0 - to quit\n" +
                "1 - created a character\n" +
                "2 - save record\n" +
                "3 - load record\n" +
                "4 - edit character state");
    }

    public static List<String> editValues(ISaveable objectToEdit) {
        List<String> values = new ArrayList<String>();
        return values;
    }

    public static void saveObject(ISaveable objectToSave) {
        for (int i = 0; i < objectToSave.write().size(); i++) {
            String state = "";
            switch (i) {
                case 0:
                    state = " name ";
                    break;
                case 1:
                    state = " hit point ";
                    break;
                case 2:
                    state = " strength ";
                    break;
                case 3:
                    state = " weapon ";
                    break;
            }
            System.out.println("Saving " + objectToSave.write().get(i) + state + "to storage device.");
        }
    }

    public static void editObject(ISaveable objectToEdit) {
        System.out.println();
    }

    public static void loadObject(ISaveable objectToLoad) {
        System.out.println(objectToLoad.toString());
    }

    public void main(String[] args) {
        menu();
        start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    System.out.println("Bye bye!");
                    break;
                case 1:
                    System.out.print("Enter a character name: ");
                    String characterName = scanner.nextLine();
                    System.out.print("Enter a weapon: ");
                    String weapon = scanner.nextLine();
                    System.out.print("Enter a hitPoints: ");
                    int hitPoints = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter a strength: ");
                    int strength = scanner.nextInt();
                    scanner.nextLine();
                    ISaveable player = new PlayerOwnVersion(characterName, hitPoints, strength);
                    files.add(player);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }

    }


}
