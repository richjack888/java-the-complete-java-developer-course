public class ChallengePrinter {
    private int tonerLevel;
    private int numberOfPagePrinted;
    private boolean duplexPrinter;

    public ChallengePrinter(int tonerLevel, boolean duplexPrinter) {
        if (tonerLevel > 0 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        } else {
            this.tonerLevel = 100;
        }
        this.numberOfPagePrinted = 0;
        this.duplexPrinter = duplexPrinter;
        if (duplexPrinter) {
            System.out.println("Duplex mode on, double side be printed");
        }
    }

    public void fillUp() {
        tonerLevel = 100;
        System.out.println("Start fill up.");
        System.out.println("tonerLevel is 100 full now.");
    }

    public void print(double page) {
        if (page <= tonerLevel) {
            tonerLevel -= page;
            if (isDuplexPrinter()) {
                numberOfPagePrinted += Math.ceil(page / 2);

            } else {
                numberOfPagePrinted += page;
            }
            System.out.println("--- Start print ---");
            System.out.println(getNumberOfPagePrinted() + " total page be printed.");
            System.out.println("toner level now left: " + getTonerLevel());
            System.out.println("--- Done ---\n");
            if (getTonerLevel() == 0) {
                System.out.println("Toner level is 0 plz fill up.");
            }
        } else {
            System.out.println("Toner level is not enough" + getTonerLevel() + "plz fill up.");
        }

    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getNumberOfPagePrinted() {
        return numberOfPagePrinted;
    }

    public boolean isDuplexPrinter() {
        return duplexPrinter;
    }
}
