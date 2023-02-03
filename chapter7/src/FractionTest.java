public class FractionTest {
    public static void main(String[] args) {
//        System.out.println(addFractions("5/8", "5/6"));
//        System.out.println(addFractions("1/8", "5/6"));
//        System.out.println(addFractions("1/5", "2/5"));
        System.out.println(addFractions("15/8", "5/6"));
    }

    public static String addFractions(String fraction1, String fraction2) {
        String[] fraction1Parts = fraction1.split("/");
        String[] fraction2Parts = fraction2.split("/");

        int numerator1 = Integer.parseInt(fraction1Parts[0]);
        int denominator1 = Integer.parseInt(fraction1Parts[1]);

        int numerator2 = Integer.parseInt(fraction2Parts[0]);
        int denominator2 = Integer.parseInt(fraction2Parts[1]);

        int numerator = numerator1 * denominator2 + numerator2 * denominator1;
        int denominator = denominator1 * denominator2;
        int wholeNumber = numerator / denominator;
        if(wholeNumber > 0) {
            numerator = numerator % denominator;
            return fraction1 + " + " + fraction2 + " -> 整數="+ wholeNumber + ", 分子=" + numerator + ", 分母=" + denominator;
        }

        return fraction1 + " + " + fraction2 + " -> 分子=" + numerator + ", 分母=" + denominator;
    }
}
