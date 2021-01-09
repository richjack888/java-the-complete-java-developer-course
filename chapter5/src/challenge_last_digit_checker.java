public class challenge_last_digit_checker {

    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(42, 22, 71));
        System.out.println(hasSameLastDigit(23, 42, 42));
        System.out.println(hasSameLastDigit(9, 99, 999));
    }

    public static boolean hasSameLastDigit(int number1, int number2, int number3) {
        if ((isValid(number1) && (isValid(number2)) && (isValid(number3)))) {
            int digit1 = number1 % 10;
            int digit2 = number2 % 10;
            int digit3 = number3 % 10;
            return (digit1 == digit2) || (digit1 == digit3) || (digit2 == digit3);
        }
        return false;

    }

    public static boolean isValid(int number) {
        return (number >= 10) && (number <= 1000);
    }

}
