public class practiceH_teen_number_check {

    public static void main(String[] args) {

        System.out.println(hasTeen(13, 25, 29));
        System.out.println(hasTeen(24, 25, 29));
        System.out.println(isTeen(9));
        System.out.println(isTeen(13));

    }

    public static boolean hasTeen(int one, int two, int three) {
        return isTeen(one) || isTeen(two) || isTeen(three);
    }

    public static boolean isTeen(int one) {
        return (one >= 13 && one <= 19);
    }
}
