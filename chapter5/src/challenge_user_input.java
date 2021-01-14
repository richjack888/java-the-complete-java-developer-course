import java.util.Scanner;

class challenge_user_input {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = 1;
        int sum = 0;

        while (count <= 10) {
            System.out.println("Enter Number #" + count);
            boolean hasNextInt = scanner.hasNextInt();

            if (hasNextInt) {

                int number = scanner.nextInt();
                sum += number;
                count++;

            } else System.out.println("Invalid Number");
            scanner.nextLine();

        }
        System.out.println("Input sum is: " + sum);
        scanner.close();
    }
}



