import java.util.Scanner;

public class ArrayExercise {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] myIntegers = getIntegers(3);
        printIntegers(sortIntegers(myIntegers));

    }

    private static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer value.\r");
        int[] values = new int[number];
        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }

        return values;
    }

    private static void printIntegers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element " + i + ", type value was " + numbers[i]);
        }
    }

    private static int[] sortIntegers(int[] numbers) {
        for (int a = 0; a < numbers.length; a++) {
            for (int b = 0; b < numbers.length; b++) {
                if (numbers[a] < numbers[b]) {
                    int temp = numbers[b];
                    numbers[b] = numbers[a];
                    numbers[a] = temp;
                }
            }
        }

        return numbers;


    }

}



