import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList();

    public static void main(String[] args) {

    }


    public void addGroceryItem(String item) {
        System.out.println("You add - " + item + " - to grocery list");
        groceryList.add(item);
    }

    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in your grocery list.");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }

    public void modifyGroceryItem(int position, String item) {
        groceryList.set(position, item);
        System.out.println("Grocery Item " + (position + 1) + " has been modified.");
    }

    public void removeGroceryItem(int position) {
        String theItem = groceryList.get(position - 1);
        groceryList.remove(position - 1);
        System.out.println("item: " + theItem + " had been removed.");
    }

    public String findItem(String searchItem) {
        int position = groceryList.indexOf(searchItem);
        if (position >= 0) {
            return groceryList.get(position);
        }
        return null;
    }

}
