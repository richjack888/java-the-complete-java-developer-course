public class for_statement_challenge {
    public static void main(String[] args) {
//        for (int i = 2; i <= 8; i++) {
//            System.out.println("10,000 at " + i + " % interest = " + calculateInterest(10000, i));
//        }
        for (int i = 8; i >= 2; i--) {
            System.out.println("10,000 at " + i + " % interest = " + String.format("%.2f", calculateInterest(10000, i)));
        }
    }

    public static double calculateInterest(double amount, double interestRate) {
        return amount * (interestRate / 100);
    }
}
