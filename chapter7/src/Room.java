public class Room {

    private Door theDoor;
    private Bed theBed;
    private BookCase theBookCase;

    public Room(Door theDoor, Bed theBed, BookCase theBookCase) {
        this.theDoor = theDoor;
        this.theBed = theBed;
        this.theBookCase = theBookCase;
    }

    public BookCase getTheBookCase() {
        return theBookCase;
    }

    public Bed getTheBed() {
        return theBed;
    }

    public Door getTheDoor() {
        return theDoor;
    }

    public void putBook(String bookName) {
        if (this.theBookCase.getBookNumber() > 10) {
            System.out.println("BookCase already full.");
        } else {
            this.theBookCase.setBookInCase(bookName);
        }
    }

    public void open_door() {
        this.theDoor.setOpen();
        System.out.println("The door is open.");
    }

    public void close_door() {
        this.theDoor.setClose();
        System.out.println("The door is close.");
    }


}
