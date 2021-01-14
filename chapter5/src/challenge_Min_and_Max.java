import java.util.Scanner;

public class challenge_Min_and_Max {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int maxValue = 0;
        int minValue = 0;
        int count = 0;

        while (true) {

            System.out.println("Enter number:");
            boolean hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                int number = scanner.nextInt();
                if (count == 0) {
                    maxValue = number;
                    minValue = number;
                    count++;
                } else if (number > maxValue) maxValue = number;
                else if (number < minValue) minValue = number;

            } else break;

            scanner.nextLine();

        }
        System.out.println("Max: " + maxValue + " Minx: " + minValue);
        scanner.close();


    }

}
