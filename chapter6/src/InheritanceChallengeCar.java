public class InheritanceChallengeCar extends InheritanceChallengeVehicle {

    private int wheels;
    private int doors;
    private int gears;
    private boolean isManual;

    private int currentGear;

    public InheritanceChallengeCar(String name, String size, int wheels, int doors, int gears, boolean isManual) {
        super(name, size);
        this.wheels = wheels;
        this.doors = doors;
        this.gears = gears;
        this.isManual = isManual;
        this.currentGear = 1;
    }

    public void changeGear(int currentGear) {
        System.out.println("Car.changeGear(): change to " + this.currentGear + " gear.");
        this.currentGear = currentGear;
    }

    public void changeVelocity(int speed, int direction) {
        System.out.println("Car.changeVelocity(): Velocity " + speed + " direction " + direction + " .");
        move(speed, direction);
    }

    @Override
    public void stop() {
        super.stop();
    }
}
