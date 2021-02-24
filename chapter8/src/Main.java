import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> numbers = new ArrayList<Double>();
        double num = 5.555;
        numbers.add(-num);
        System.out.println(numbers.get(0));

    }
}
