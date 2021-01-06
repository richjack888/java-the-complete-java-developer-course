public class isprime_challenge {
    public static void main(String[] args) {

        int anyStart = 50;
        int anyEnd = 99;
        int primeCount = 0;

        for (int i = anyStart; i <= anyEnd; i++) {
            if (isPrime(i)) {
                primeCount++;
                System.out.println("prime number found :" + i);
            }
            if (primeCount == 3) {
                break;
            }
        }
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
