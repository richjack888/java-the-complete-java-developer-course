public class challenge_number_palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-111));
        System.out.println(isPalindrome(110));
        System.out.println(isPalindrome(-1221));
        System.out.println(isPalindrome(707));
    }

    public static boolean isPalindrome(int number) {

        int reverse = 0;
        int original_number = number;

        while (number != 0) {
            int digit = number % 10;
            reverse = reverse * 10 + digit;
            number /= 10;
        }

        return (original_number == reverse);
    }


}
