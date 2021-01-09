public class challenge_first_and_last_digit_sum {

    public static void main(String[] args) {

        System.out.println(sumFirstAndLastDigit(252));
        System.out.println(sumFirstAndLastDigit(0));
        System.out.println(sumFirstAndLastDigit(5));
        System.out.println(sumFirstAndLastDigit(-10));

    }

    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) return -1;
        int last_digit = number % 10;

        while (number > 9) {
            number /= 10;
        }

        return number + last_digit;
    }
}
