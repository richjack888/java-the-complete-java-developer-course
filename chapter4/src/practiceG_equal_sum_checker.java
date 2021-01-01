public class practiceG_equal_sum_checker {

    public static void main(String[] args) {

        System.out.println(hasEqualSum(1, 1, 1));
        System.out.println(hasEqualSum(1, 1, 2));
        System.out.println(hasEqualSum(-1, 1, 0));

    }

    public static boolean hasEqualSum(int one, int two, int three) {
        return one + two == three;
    }

}

