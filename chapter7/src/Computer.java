public class Computer {
    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public Computer(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp() {
        theCase.pressPowerButton();
        System.out.println("Power of computer is up now.");
    }

    public void showProgram(String programName) {
        motherboard.loadProgram(programName);
        monitor.drawPixelAt(1080, 720, "Black background");
        System.out.println("Window of program is opened.");
    }


}
