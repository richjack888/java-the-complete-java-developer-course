public class InheritanceChallengeBenz extends InheritanceChallengeCar {
    private int roadServiceMonths;

    public InheritanceChallengeBenz(int roadServiceMonths) {
        super("Benz", "Sport", 4, 4, 8, true);
        this.roadServiceMonths = roadServiceMonths;
    }

    public void accelerate(int rate) {
        int newVelocity = getCurrentVelocity();
        if (newVelocity == 0) {
            stop();
            changeGear(1);
        } else if (newVelocity > 0 && newVelocity <= 20) {
            changeGear(1);
        } else if (newVelocity > 20 && newVelocity <= 40) {
            changeGear(2);
        } else if (newVelocity > 40 && newVelocity <= 60) {
            changeGear(3);
        } else if (newVelocity > 60 && newVelocity <= 80) {
            changeGear(4);
        } else if (newVelocity > 80 && newVelocity <= 100) {
            changeGear(5);
        } else {
            changeGear(6);
        }

        if (newVelocity > 0) {
            changeVelocity(newVelocity, getCurrentDirection());
        }

    }

}
