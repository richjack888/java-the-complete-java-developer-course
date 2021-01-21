public class BookCase {
    private int bookNumber;
    private String bookName;
    private String bookInCase;

    public BookCase() {
        this.bookNumber = 0;
        this.bookName = null;
        this.bookInCase = "";
    }

    public String getBookInCase() {
        return bookInCase;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public String setBookInCase(String bookInCase) {
        return this.bookInCase += bookInCase + " . ";
    }

    public void checkBook() {
        System.out.println("Bookcase has: " + getBookInCase());
    }

}
