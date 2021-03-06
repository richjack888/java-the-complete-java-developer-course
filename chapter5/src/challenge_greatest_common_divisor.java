public class challenge_greatest_common_divisor {

    public static void main(String[] args) {

//        System.out.println(getGreatestCommonDivisor(25, 15));
//        System.out.println(getGreatestCommonDivisor(12, 30));
//        System.out.println(getGreatestCommonDivisor(9, 18));
//        System.out.println(getGreatestCommonDivisor(81, 153));
        System.out.println(getGreatestCommonDivisor(12, 240));

    }

    public static int getGreatestCommonDivisor(int first, int second) {
        if ((first < 10) || (second < 10)) return -1;
        while (first != second) {
            if (first > second) {
                first -= second;
            } else {
                second -= first;
            }
        }
        return first;
    }

//        Version 2
//        int value = 0;
//
//        for (int i = 1; i <= first; i++) {
//            if ((first % i == 0) && (second % i == 0)) {
//                value = i;
//            }
//        }
//        return value;
//    }

}
