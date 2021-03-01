import java.util.Iterator;
import java.util.LinkedList;

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


    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()) {
            System.out.println("Now visiting City of " + i.next());
        }
        System.out.println("=============================");
    }


}
