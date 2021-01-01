public class practiceB_speed_converter {

    public static void main(String[] args) {

        printConversion(1.5);
        printConversion(10.25);
        printConversion(-5.6);
        printConversion(25.42);
        printConversion(75.114);

    }

    public static long toMilesPerHour(double kilometersPerHour) {
        return (kilometersPerHour >= 0) ? Math.round(kilometersPerHour / 1.609) : -1;
    }

    public static void printConversion(double kilometersPerHour) {
        if (kilometersPerHour > 0) {
            System.out.println(kilometersPerHour + "km/h = " + toMilesPerHour(kilometersPerHour) + " mile/h");
        } else {
            System.out.println("Invalid Value!");
        }
    }

}
