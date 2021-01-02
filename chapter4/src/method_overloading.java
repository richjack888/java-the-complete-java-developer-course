public class method_overloading {

    public static void main(String[] args) {

        calcFeetAndInchesToCentimeters(10, 4);
        calcFeetAndInchesToCentimeters(100);
        calcFeetAndInchesToCentimeters();

    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if (feet >= 0 && inches >= 0 && inches <= 12) {
            double cm = ((feet * 12) + inches) * 2.54;
            System.out.println(feet + " feet + " + inches + " inches = " + cm + " cm");
            return cm;
        } else return -1;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if (inches < 0) {
            return -1;
        }
        double feet = (int) (inches / 12);
        double inch = inches % 12;
        System.out.println(inches + " inches = " + feet + " feet + " + inch + " inch.");

        return calcFeetAndInchesToCentimeters(feet, inch);
    }

    public static void calcFeetAndInchesToCentimeters() {
        System.out.println("Don't have parameter!");
    }


}
