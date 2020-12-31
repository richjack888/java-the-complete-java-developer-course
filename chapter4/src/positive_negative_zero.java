public class positive_negative_zero {

    public static void main(String[] args) {

        checkNumber(500);
        checkNumber(-500);
        checkNumber(0);
        checkNumber(-0);

    }

    public static void checkNumber(int number) {

        System.out.println((number > 0) ? "positive" : (number < 0) ? "negative" : "zero");

    }
}
