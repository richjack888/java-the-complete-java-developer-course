import java.util.Scanner;

public class StackTraceAndCallStack {
    public static void main(String[] args) {
        int result = divide();
        System.out.println("x / y = " + result);
    }

    private static int divide() {
        int x = getInt();
        int y = getInt();
        System.out.println("x is " + x + ", y is " + y);
        return x / y;
    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter an Integer");
        return s.nextInt();
    }
}
