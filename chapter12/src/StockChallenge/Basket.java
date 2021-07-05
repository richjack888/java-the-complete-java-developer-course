package StockChallenge;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new LinkedHashMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            int reservedCheck = item.getReserved() + quantity;
            if (item.quantityInStock() >= reservedCheck) {
                item.setReserved(reservedCheck);
                list.put(item, inBasket + quantity);
                System.out.println(item.getName() + " order " + quantity + " -> Total reserved: " + item.getReserved());
                return inBasket;
            }else {
                System.out.println("Stock of " + item.getName() + " not enough!");
                return 0;
            }
        }
        return 0;
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() + (list.size() == 1 ? " item" : " items") + "\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + " --> " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + " Total cost $" + totalCost;
    }


}
