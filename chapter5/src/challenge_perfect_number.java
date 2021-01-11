public class challenge_perfect_number {
    public static void main(String[] args) {
        System.out.println(isPerfectNumber(6));
        System.out.println(isPerfectNumber(28));
        System.out.println(isPerfectNumber(5));
        System.out.println(isPerfectNumber(-1));
    }

    public static boolean isPerfectNumber(int number) {

        int factor_sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                factor_sum += i;
            }
        }
        return (factor_sum == number) && (number > 1);
    }
}
