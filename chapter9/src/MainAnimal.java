public class MainAnimal {
    public static void main(String[] args) {
//        Dog dog = new Dog("Husky");
//        dog.breathe();
//        dog.eat();

        Parrot parrot = new Parrot("Rainbow");
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("Happy feet");
        penguin.breathe();
        penguin.eat();
        penguin.fly();
    }
}
