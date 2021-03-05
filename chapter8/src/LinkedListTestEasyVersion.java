import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkedListTestEasyVersion {
    public static void main(String[] args) {
        LinkedList<String> placeToVisit = new LinkedList<String>();
        addInOrder(placeToVisit, "Taipei");
        addInOrder(placeToVisit, "New Taipei");
        addInOrder(placeToVisit, "Taoyuan");
        addInOrder(placeToVisit, "Taichung");
        addInOrder(placeToVisit, "Tainan");
        addInOrder(placeToVisit, "Kaohsiung");
        printList(placeToVisit);

        visit(placeToVisit);

    }

    private static void printList(LinkedList<String> linkedList) {
        System.out.println("==============================================");
        System.out.println("The list of cities which we want to visit: ");
        for (String s : linkedList) {
            System.out.println("No." + (linkedList.indexOf(s) + 1) + " City is " + s);
        }
        System.out.println("==============================================");
    }

    private static void addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                // equal, no add
                System.out.println(newCity + " is already included as a destination");
                return;
            } else if (comparison > 0) {
                // new City should appear before this one
                // B city -> A city
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return;
            }
        }
        stringListIterator.add(newCity);
    }

    private static void visit(LinkedList<String> cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        ListIterator<String> listIterator = cities.listIterator();
//        boolean changeDirection = false;

        if (cities.isEmpty()) {
            System.out.println("No cities in the itinerary");
            return;
        } else {
            System.out.println("Vacation start!\nWe are at the origin point now.");
            printMenu();
        }

        while (!quit) {
            System.out.print("\n" + "Enter number to action:");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Vacation over!");
                    quit = true;
                    break;
                case 1:
//                    if (changeDirection) {
//                        if (listIterator.hasNext()) {
//                            listIterator.next();
//                        }
//                        changeDirection = false;
//                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting -- City No." + (listIterator.nextIndex() + 1) + " " + listIterator.next());
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                    } else {
                        System.out.println("No more next city!");
//                        changeDirection = true;
                    }
                    break;
                case 2:
//                    if (!changeDirection) {
//                        if (listIterator.hasPrevious()) {
//                            listIterator.previous();
//                        }
//                        changeDirection = true;
//                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting -- City No." + (listIterator.previousIndex() + 1) + " " + listIterator.previous());
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                    } else {
                        System.out.println("No more previous city!");
//                        changeDirection = false;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }


    }

    private static void printMenu() {
        System.out.println("Available actions:");
        System.out.println("0 - Quit!\n" +
                "1 - Go to next city.\n" +
                "2 - Go to previous city.\n" +
                "3 - Print menu of actions again.\n" +
                "-------------------------------");
    }
}
