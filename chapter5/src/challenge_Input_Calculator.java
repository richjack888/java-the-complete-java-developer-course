import java.util.Scanner;

public class challenge_Input_Calculator {

    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }

    public static void inputThenPrintSumAndAverage() {

        int sum = 0;
        int count = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {

            boolean isInt = scanner.hasNextInt();

            if (isInt) {

                int num = scanner.nextInt();
                sum += num;
                count++;

            } else {
                break;
            }
        }
        scanner.nextLine();
        System.out.println("SUM = " + sum + " AVG = " + Math.round((double) sum / count));
        scanner.close();
    }


}

