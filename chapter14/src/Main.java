import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int x = getIntEAFP();
        System.out.println("x is " + x);
    }

    private static int getIntEAFP() {
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter an integer: ");
        try {
            return s.nextInt();
        } catch (InputMismatchException e) {
            return 0;
        }
    }

    private static int getIntLBYL() {
        Scanner sc = new Scanner(System.in);
        boolean isValid = true;
        System.out.print("Please enter an integer: ");
        String input = sc.next();
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                isValid = false;
                break;
            }
        }
        if (isValid) {
            return Integer.parseInt(input);
        }
        return 0;
    }

    private static int getInt() {
        System.out.print("Please enter X: ");
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }


}
