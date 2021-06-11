package Dog;

public class MainDog {
    public static void main(String[] args) {

        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println("Does rover2 equal rover? " + rover2.equals(rover));
        System.out.println("Does rover equal rover2? " + rover.equals(rover2));
    }


}
