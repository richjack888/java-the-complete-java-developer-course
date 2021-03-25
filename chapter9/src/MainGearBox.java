public class MainGearBox {
    public static void main(String[] args) {
        GearBox mcLaren = new GearBox(6);
        GearBox.Gear first = mcLaren.new Gear(1, 12.3);
//        GearBox.Gear second = new GearBox.Gear(2,2.34);
//        GearBox.Gear third = new mcLaren.Gear(3, 3.45);
        System.out.println(first.driveSpeed(1000));
    }
}
