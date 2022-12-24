import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    public static void main(String[] args) {

//        Plate<? extends Fruit> p = new Plate<Fruit>(new Fruit());
//        p.set(new Food());
//        p.set(new Fruit());
//        p.set(new Apple());
//
//        Food food = p.get();
//        Fruit fruit = p.get();
//        Apple apple = p.get();
//
//
//
//        Plate<? super Fruit> p2 = new Plate<Fruit>(new Fruit());
//        p2.set(new Food());
//        p2.set(new Fruit());
//        p2.set(new Apple());
//
//        Food food2 = p2.get();
//        Fruit fruit2 = p2.get();
//        Apple apple2 = p2.get();
//
//        System.out.println("Main");

    }
}


class Plate<T> {
    private T item;

    public Plate(T t) {
        item = t;
    }

    public void set(T t) {
        item = t;
    }

    public T get() {
        return item;
    }
}

class Food {
}

//Lev 2
class Fruit extends Food {
}

class Meat extends Food {
}

//Lev 3
class Apple extends Fruit {
}

class Banana extends Fruit {
}

class Pork extends Meat {
}

class Beef extends Meat {
}

//Lev 4
class RedApple extends Apple {
}

class GreenApple extends Apple {
    public static void main(String[] args) {
        System.out.println("green apple");
    }
}