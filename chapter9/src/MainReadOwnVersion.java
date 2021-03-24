import java.util.ArrayList;
import java.util.Scanner;

public class MainReadOwnVersion {

    public static void main(String[] args) {
        ISaveable player = new PlayerOwnVersion("Tim", 20, 40);
        saveObject(player);
        editObject(player);
        loadObject(player);
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

    public static void loadObject(ISaveable objectToLoad) {
        System.out.println(objectToLoad);
    }

    public static void editObject(ISaveable objectToLoad) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> values = new ArrayList<String>();

        System.out.print("Enter a character name: ");
        String characterName = scanner.nextLine();
        System.out.print("Enter a hitPoints: ");
        String hitPoints = scanner.nextLine();
        System.out.print("Enter a strength: ");
        String strength = scanner.nextLine();
        System.out.print("Enter a weapon: ");
        String weapon = scanner.nextLine();

        values.add(0, characterName);
        values.add(1, hitPoints);
        values.add(2, strength);
        values.add(3, weapon);

        objectToLoad.update(values);

    }

}