import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Fruit> fruits = new HashSet<>();
        Fruit fruit1 = new Fruit("apple", "tree");
        Fruit fruit2 = new Fruit("apple11", "tree");
        fruits.add(fruit1);
        fruits.add(fruit2);

        for (Fruit f : fruits) {
            System.out.println(f);

        }


    }
}

class Fruit {
    private String name;
    private String fruitType;

    public Fruit(String name, String fruitType) {
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

        // if different type they cant be equal
        if (!(other instanceof Fruit)) {
            return false;
        }

        // cast to fruit
        Fruit fruit = (Fruit) other;

        // check if names are equal
        return this.fruitType.equals(fruit.fruitType);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.fruitType.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}

