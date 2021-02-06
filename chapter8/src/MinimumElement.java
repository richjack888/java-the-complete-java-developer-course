import java.util.Scanner;

public class MinimumElement {

    private static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        int integer = scanner.nextInt();
        scanner.nextLine();

        return integer;
    }

    private static int[] readElements(int integer) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[integer];
        for (int i = 0; i < integer; i++) {
            int number = scanner.nextInt();
            scanner.nextLine();
            array[i] = number;
        }
        return array;
    }

    private static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if (value < min) {
                min = value;
            }
        }
        return min;

    }

}
