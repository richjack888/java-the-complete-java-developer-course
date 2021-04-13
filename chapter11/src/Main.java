import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Container<Integer> obj = new Container<>();
        obj.demo(new ArrayList<Number>());
//        obj.demo(new ArrayList<Double>()); // won't work

        Container<Number> obj1 = new Container<>();
        obj1.demo2(new ArrayList<Integer>());
        obj1.demo2(new ArrayList<Double>());

    }
}

class Container<T extends Number> {

    public void demo(ArrayList<? super T> obj) {
        System.out.println("demo");
    }

    public void demo2(ArrayList<? extends T> obj) {
        System.out.println("d22222222");
    }
}
