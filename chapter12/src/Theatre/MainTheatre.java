package Theatre;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainTheatre {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Muzha Guangming", 8, 12);

        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 5));
        priceSeats.add(theatre.new Seat("A00", 5));
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printList(priceSeats);


    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {
            System.out.print(seat.getSeatNumber() + ":$" + seat.getPrice() + ", ");
        }

        System.out.println();
        System.out.println("================================");
    }

}
