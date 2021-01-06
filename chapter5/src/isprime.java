public class isprime {
    public static void main(String[] args) {

        System.out.println(isPrime(4));
        System.out.println(isPrime(7));
        System.out.println(isPrime(18));
        System.out.println(isPrime(99));
        System.out.println(isPrime(111));
        System.out.println(isPrime(121));
        System.out.println(isPrime(13));

    }

    public static boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
