import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainTheatre {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Muzha Guangming", 8, 10);
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
//        printList(seatCopy);
//
//        seatCopy.get(1).reserve();
//        if(theatre.reserveSeat("A02")){
//            System.out.println("Please pay for A02");
//        }else{
//            System.out.println("Seat already reserved.");
//        }

        Collections.reverse(seatCopy);
        System.out.println("Print seatCopy");
        ;
        printList(seatCopy);
        System.out.println("Print original seat");
        printList(theatre.seats);


    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber());
        }

        System.out.println();
        System.out.println("================================");
    }

}
