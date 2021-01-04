public class practiceJ_minutes_year_days {

    public static void main(String[] args) {

        printYearsAndDays(525600);
        printYearsAndDays(1051200);
        printYearsAndDays(561600);
        printYearsAndDays(2486);
        printYearsAndDays(0);
        printYearsAndDays(-565);

    }

    public static void printYearsAndDays(long minutes) {
        int year = (60 * 24 * 365);
        int day = (60 * 24);
        int equalYear = (int) (minutes / year);
        int remainDay = (int) (minutes % year) / day;
        if (minutes >= 0) {
            System.out.println(minutes + " min = " + equalYear + " y and " + remainDay + " d");
        } else {
            System.out.println("Invalid Value");
        }
    }
}
