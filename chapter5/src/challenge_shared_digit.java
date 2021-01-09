public class challenge_shared_digit {

    public static void main(String[] args) {

        System.out.println(hasSharedDigit(12, 23));
        System.out.println(hasSharedDigit(9, 99));
        System.out.println(hasSharedDigit(15, 55));

    }

    public static boolean hasSharedDigit(int number1, int number2) {

        if ((number1 < 10) || (number1 > 99) || (number2 < 10) || (number2 > 99)) {
            return false;
        }
        int num1 = number1;
        int num2 = number2;

        while (num1 > 0) {
            int digit1 = num1 % 10;
            while (num2 > 0) {
                int digit2 = num2 % 10;
                if (digit1 == digit2) {
                    return true;
                } else {
                    num2 /= 10;
                    if (num2 == 0) {
                        num2 = number2;
                        break;
                    }
                }
            }
            num1 /= 10;
        }
        return false;

    }
}


//    public static boolean hasSharedDigit(int num1, int num2) {
//        int num1_digit1 = 0;
//        int num1_digit2 = 0;
//        int num2_digit1 = 0;
//        int num2_digit2 = 0;
//        if ((num1 < 10) || (num1 > 99) || (num2 < 10) || (num2 > 99)) {
//            return false;
//        }
//
//        num1_digit1 += num1 % 10;
//        num1 /= 10;
//        num1_digit2 += num1 % 10;
//
//        num2_digit1 += num2 % 10;
//        num2 /= 10;
//        num2_digit2 += num2 % 10;
//
//        return ((num1_digit1 == num2_digit1) ||
//                (num1_digit1 == num2_digit2) ||
//                (num1_digit2 == num2_digit1) ||
//                (num1_digit2 == num2_digit2)) ;
//
//
//    }
//}
