import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Fruit> fruits = new HashSet<>();
        Fruit fruit = new Fruit("apple");
        fruits.add(fruit);
        fruits.add(fruit);

        for (Fruit f : fruits) {
            System.out.println(f);

        }


    }
}

class Fruit {
    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return name.equals(fruit.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}

