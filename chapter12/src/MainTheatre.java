public class MainTheatre {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Muzha Guangming", 8, 10);
//        theatre.getSeats();
        if (theatre.reserveSeat("E05")) {
            System.out.println("Okay, this seat is yours, one seat is $1");
        } else {
            System.out.println("Sorry, this seat is sold out already.");
        }
        if (theatre.reserveSeat("E05")) {
            System.out.println("Okay, this seat is yours, one seat is $1");
        } else {
            System.out.println("Sorry, this seat is sold out already.");
        }
    }

}
