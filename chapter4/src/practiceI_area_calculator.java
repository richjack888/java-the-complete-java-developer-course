public class practiceI_area_calculator {
    public static void main(String[] args) {
        System.out.println(area(5));
    }

    public static double area(double radius) {
        return (radius < 0) ? -1 : radius * radius * Math.PI;

    }

    public static double area(double x, double y) {
        return (x < 0 || y < 0) ? -1 : (x * y);

    }

}
