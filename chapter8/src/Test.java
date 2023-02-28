import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
//        int sum = 1 + 1;
//        System.out.println("1 + 1 = " + sum);
//
//        System.out.println("1 + 1 = " + (1 + 1));

        //        String a = "a";
//        System.out.println(a == "a");

        var array = new ArrayList<String>();
        array.add("a");
        array.add("b");
        for (String s : array) {
            System.out.printf("%s%n\n", s);
        }

    }
}
