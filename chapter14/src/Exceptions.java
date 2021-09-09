import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) {
        int x = getIntLBYL();
        System.out.println("x is " + x);
    }

    private static int getIntLBYL() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer");
        if(s.hasNextInt()) {
            return s.nextInt();
        }
        return 0;
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

    private static int getInt() {
        System.out.print("Please enter X: ");
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }
}
