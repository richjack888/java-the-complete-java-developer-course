public class method_overloading_challenge {

    public static final String INVALID = "Hello World!";

    public static void main(String[] args) {
        System.out.println(getDurationString(1));
        System.out.println(getDurationString(-1));
        System.out.println(getDurationString(100));
        System.out.println(getDurationString(1, 2));
        System.out.println(getDurationString(-1, 2));
        System.out.println(getDurationString(1, 600));
    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes < 0 || seconds < 0 || seconds > 59) {
            return "Invalid Value";
        }
        int hour = (minutes / 60);
        int RemainMinute = (minutes % 60);

        return (hour < 10 ? "0" + hour : hour) + " h " +
                (RemainMinute < 10 ? "0" + RemainMinute : RemainMinute) + " m " +
                (seconds < 10 ? "0" + seconds : seconds) + " s ";
    }

    public static String getDurationString(int seconds) {
        if (seconds < 0) {
            return "Invalid Value";
        }

        return getDurationString((seconds / 60), (seconds % 60));
    }

    public static void M1() {
        System.out.println(INVALID);
    }

    public static void M2() {
        System.out.println(INVALID);
    }

    public static void M3() {
        System.out.println(INVALID);
    }

    public static void M4() {
        System.out.println(INVALID);
    }


}
