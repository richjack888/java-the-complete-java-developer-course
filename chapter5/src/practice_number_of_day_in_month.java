public class practice_number_of_day_in_month {

    public static void main(String[] args) {
        System.out.println(getDaysInMonth(1, 2020));
        System.out.println(getDaysInMonth(2, 2020));
        System.out.println(getDaysInMonth(2, 2018));
        System.out.println(getDaysInMonth(-1, 2020));
        System.out.println(getDaysInMonth(1, -2020));
    }

    public static boolean isLeapYear(int year) {
        if (year > 0 && year <= 9999) {
            return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
        }
        return false;
    }

    public static int getDaysInMonth(int month, int year) {

        if ((month < 1) || (month > 12) || (year < 1) || (year > 9999)) {
            return -1;
        } else {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    return 31;

                case 2:
                    if (isLeapYear(year)) {
                        return 29;
                    }
                    return 28;
                default:
                    return 30;
            }
        }
    }


}
