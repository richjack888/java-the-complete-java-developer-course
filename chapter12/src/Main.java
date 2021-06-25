import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

//        Set<Fruit> fruits1 = new HashSet<>();
//        Fruit fruit1 = new Fruit("apple", "tree");
//        Fruit fruit2 = new Fruit("apple", "tree");
//        fruits1.add(fruit1);
//        fruits1.add(fruit2);
//
//        for (Fruit f : fruits1) {
//            System.out.println(f);
//
//        }


        Set<String> fruits2 = new HashSet<>();
        String fruitA = "apple";
        String fruitB = "apple";
        fruits2.add(fruitA);
        fruits2.add(fruitB);

        for (String f : fruits2) {
            System.out.println(f);

        }


    }
}

class Fruit {
    private String name;
    private String fruitType;

    Fruit(String name, String fruitType) {
        this.name = name;
        this.fruitType = fruitType;
    }

    @Override
    public boolean equals(Object other) {
        System.out.println("calling equals this= " + this + " other= " + other);
        // if same reference (e.g. same memory address then they are logically equal)
        if (this == other) {
            return true;
        }

        if (other == null || other.getClass() != this.getClass()) {
            return false;
        }

        // cast to fruit
        Fruit fruit = (Fruit) other;

        return this.name.equals(fruit.name) && this.fruitType.equals(fruit.fruitType);
    }

    @Override
    public int hashCode() {
//        return this.name.hashCode() + this.fruitType.hashCode();
        System.out.println(super.hashCode());
        return super.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}

