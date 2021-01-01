public class practiceE_leap_year {

    public static void main(String[] args) {

        System.out.println(isLeapYear(-1600));
        System.out.println(isLeapYear(1600));
        System.out.println(isLeapYear(2017));
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(1924));
        System.out.println(isLeapYear(0));

    }

    public static boolean isLeapYear(int year) {

        if (year > 0 && year <= 9999) {
            return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
        }
        return false;
    }

}
