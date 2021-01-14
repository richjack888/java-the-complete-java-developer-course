import java.util.Scanner;

public class scanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your year of birth:");

        boolean hasNextInt = scanner.hasNextInt();

        if (hasNextInt) {

            int yearOfBirth = scanner.nextInt();
            int age = 2021 - yearOfBirth;
            scanner.nextLine(); // Without this line, input will end right now.

            System.out.println("What's your name?");
            String name = scanner.nextLine();
            if ((age > 1) && (age < 100)) {
                System.out.println("Welcome " + name + " ,my friend. Wow, you are " + age + " years old now.");
            } else System.out.println("Invalid Value");
        } else {
            System.out.println("Invalid Value");

            scanner.close();


        }
    }

}
