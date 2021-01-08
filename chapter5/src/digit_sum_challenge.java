public class digit_sum_challenge {

    public static void main(String[] args) {
        sumDigits(22222);
        sumDigits(1234);
    }

    public static int sumDigits(int number) {
        if (number < 10) {
            return -1;
        }
        int digit = 0;
        System.out.println("number : " + number);
        while (number > 0) {
            digit += (number % 10);
            number /= 10;
        }


        digit += number;
        System.out.println("digit sum : " + digit);
        return digit;
    }

}
