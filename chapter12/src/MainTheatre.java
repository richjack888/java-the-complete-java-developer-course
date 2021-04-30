import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainTheatre {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Muzha Guangming", 8, 12);

//        if (theatre.reserveSeat("D12")) {
//            System.out.println("Okay, this seat is yours");
//        } else {
//            System.out.println("Sorry, this seat is sold out already.");
//        }
//
//        if (theatre.reserveSeat("D12")) {
//            System.out.println("Okay, this seat is yours");
//        } else {
//            System.out.println("Sorry, this seat is sold out already.");
//        }
//
//        if (theatre.reserveSeat("B13")) {
//            System.out.println("Okay, this seat is yours");
//        } else {
//            System.out.println("Sorry, this seat is sold out already.");
//        }

        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);


    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber() + " " + seat.getPrice());
        }

        System.out.println();
        System.out.println("================================");
    }

}
