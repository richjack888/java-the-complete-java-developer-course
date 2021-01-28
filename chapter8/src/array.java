import java.util.Scanner;

public class array {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myIntegers = getIntegers(3);
        for (int i = 0; i < myIntegers.length; i++) {
            System.out.println("Element " + i + ", type value was " + myIntegers[i]);
        }
        System.out.println("The average is " + getAverage(myIntegers));

    }

    private static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer value.\r");
        int[] values = new int[number];

        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }

        return values;
    }

    public static double getAverage(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];

        }
        return sum / array.length;
    }


}



