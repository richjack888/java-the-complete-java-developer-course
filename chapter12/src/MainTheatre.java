import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainTheatre {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Muzha Guangming", 8, 10);
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);

        Collections.shuffle(seatCopy);
        sortList(seatCopy);
        System.out.println("Printing sorted seat seat copy");
        printList(seatCopy);

    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber());
        }

        System.out.println();
        System.out.println("================================");
    }

    public static void sortList(List<? extends Theatre.Seat> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }


}
