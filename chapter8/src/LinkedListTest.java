import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> placeToVisit = new LinkedList<String>();
        placeToVisit.add("Taipei");
        placeToVisit.add("New Taipei");
        placeToVisit.add("Taoyuan");
        placeToVisit.add("Taichung");
        placeToVisit.add("Tainan");
        placeToVisit.add("Kaohsiung");

        printList(placeToVisit);

        placeToVisit.add(1, "Middle Taipei");
        printList(placeToVisit);

        placeToVisit.remove(4);
        printList(placeToVisit);

    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()) {
            System.out.println("Now visiting City of " + i.next());
        }
        System.out.println("=============================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                // equal, no add
                System.out.println(newCity + " is already included as a destination");
                return false;
            } else if (comparison > 0) {
                // new City should appear before this one
                // Bcity -> Acity
                stringListIterator.previous();
                stringListIterator.add(newCity);
            } else if (comparison < 0) {
                // move on
            }

        }
        stringListIterator.add(newCity);
        return true;
    }


}
