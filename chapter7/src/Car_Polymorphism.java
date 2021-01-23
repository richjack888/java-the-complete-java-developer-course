//class Car {
//    private String name;
//    private boolean engine;
//    private int cylinders;
//    private int wheels;
//
//    public Car(String name, int cylinders) {
//        this.name = name;
//        this.cylinders = cylinders;
//        wheels = 4;
//        engine = true;
//    }
//
//    public void startEngine(){
//        System.out.println("Start Engine from Car");
//    }
//
//    public void acceleration(){
//        System.out.println("acceleration from Car");
//    }
//
//    public void brake(){
//        System.out.println("brake from Car");
//    }
//
//    public String getName() {
//        return name;
//    }
//
//
//    public int getCylinders() {
//        return cylinders;
//    }
//
//}
//
//class Benz extends Car {
//    public Benz(String name, int cylinders) {
//        super(name, cylinders);
//    }
//
//    @Override
//    public void startEngine() {
//        System.out.println("Start Engine from Benz");
//    }
//
//    @Override
//    public void acceleration() {
//        System.out.println("acceleration from Benz");
//    }
//
//    @Override
//    public void brake() {
//        System.out.println("brake from Benz");
//    }
//
//}
//
//class BMW extends Car {
//    public BMW(String name, int cylinders) {
//        super(name, cylinders);
//    }
//    @Override
//    public void startEngine() {
//        System.out.println("Start Engine from BMW");
//    }
//
//    @Override
//    public void acceleration() {
//        System.out.println("acceleration from BMW");
//    }
//
//    @Override
//    public void brake() {
//        System.out.println("brake from BMW");
//    }
//}
//
//class Audi extends Car {
//    public Audi(String name, int cylinders) {
//        super(name, cylinders);
//    }
//    @Override
//    public void startEngine() {
//        System.out.println("Start Engine from Audi");
//    }
//
//    @Override
//    public void acceleration() {
//        System.out.println("acceleration from Audi");
//    }
//
//    @Override
//    public void brake() {
//        System.out.println("brake from Audi");
//    }
//}
//
//
//public class Car_Polymorphism {
//    public static void main(String[] args) {
//        Car benz1 = new Benz("M6", 4);
//        benz1.startEngine();
//        benz1.acceleration();
//        benz1.brake();
//        System.out.println();
//
//        Benz benz = new Benz("M6", 4);
//        benz.startEngine();
//        benz.acceleration();
//        benz.brake();
//        System.out.println();
//    }
//
//}
//
