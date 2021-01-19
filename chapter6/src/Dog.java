public class Dog extends Animal {

    private String tale;
    private String fur;
    private int eyes;
    private int legs;


    public Dog(String sex, String size, String weight, String tale, String fur, int eyes, int legs) {
        super(sex, size, weight);
        this.tale = tale;
        this.fur = fur;
        this.eyes = eyes;
        this.legs = legs;

    }

    public void quickEat() {
        System.out.println("Dog.quickEat() method");
        eat();
    }

    public void slowEat() {
        System.out.println("Dog.slowEat() method");
    }

    @Override
    public void eat() {
        System.out.println("Dog.eat() method");
        slowEat();
        super.eat();
    }

    public void bark() {
        System.out.println("Dog.bark() method");
    }
}
