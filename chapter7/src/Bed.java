public class Bed {
    private int pillowNumber;
    private String comfortersSize;

    public Bed(int pillowNumber, String comfortersSize) {
        this.pillowNumber = pillowNumber;
        this.comfortersSize = comfortersSize;
    }

    public void getPillowNumber() {
        System.out.println("Pillow has " + this.pillowNumber);
    }

    public void getComfortersSize() {
        System.out.println("Comforters size is " + this.comfortersSize);
        ;
    }
}
