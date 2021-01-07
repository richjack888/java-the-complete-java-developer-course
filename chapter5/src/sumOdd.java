public class sumOdd {

    public static void main(String[] args) {
        sumOdd(5, 10);
        sumOdd(-5, 10);
        sumOdd(500, 101);
    }

    public static boolean isOdd(int number) {
        if (number > 0) {
            return number % 2 != 0;
        }
        return false;
    }

    public static int sumOdd(int start, int end) {
        int sum = 0;
        System.out.println("range start with " + start + " and end with " + end);
        if ((start > end) || (start < 0) || (end < 0)) {
            return -1;
        }
        for (int i = start; i <= end; i++) {
            if (isOdd(i)) {
                System.out.println("odd : " + i + " found.");
                sum += i;
            }
        }
        System.out.println("The sum of odd in the range is : " + sum);
        return sum;
    }

}
