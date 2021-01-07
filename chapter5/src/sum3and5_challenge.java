public class sum3and5_challenge {

    public static void main(String[] args) {

        int count = 0;
        int numberSum = 0;

        for (int i = 1; i <= 1000; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.println(i + ", could divided by 3 and 5. ");
                numberSum += i;
                count++;
                if (count == 5) {
                    System.out.println("Those number sum is: " + numberSum);
                    break;
                }
            }

        }

    }

}
