public class Car {

    public String model;
    public String color;
    private String engine;
    private int doors;
    private int wheels;

    public int getWheels() {
        return this.wheels;
    }

    public void setWheels(Integer wheels) {
        if (wheels > 20 || wheels < 1) {
            System.out.println("Dude, are you sure that is car?");
        } else {
            this.wheels = wheels;
            System.out.println("Dude, nice wheels.");
        }
    }

}
