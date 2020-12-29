public class operators {

    public static void main(String[] args) {

        int result = 1 + 2; // 1 + 2 = 3
        System.out.println("1 + 2 = " + result);

        int previousResult = result;
        System.out.println("previousResult = " + previousResult);

        result = result - 1;    // 3 - 1 = 2
        System.out.println("previousResult = " + previousResult);
        System.out.println("result = " + result);

        result = result * 10;   // 2 * 10 = 20
        System.out.println("2 * 10 = " + result);

        result = result / 5;    // 20 / 5 = 4
        System.out.println("20 / 5 = " + result);

        result = result % 3;    // 4 % 3 = 1
        System.out.println("4 % 3 = " + result);

        result++;  // 1 + 1 = 2
        System.out.println("1 + 1 = " + result);

        result--; // 2 - 1 = 1
        System.out.println("2 - 1 = " + result);

        result += 2; // 1 + 2 = 3
        System.out.println("1 + 2 = " + result);

        result *= 10; // 3 * 10 = 30
        System.out.println("3 * 10 = " + result);

        result /= 3; // 30 / 3 = 10
        System.out.println("30 / 3 = " + result);

        result -= 5; // 10 - 5 = 5
        System.out.println("10 - 5 = " + result);
    }

}
