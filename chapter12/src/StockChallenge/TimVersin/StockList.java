package StockChallenge.TimVersin;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            // check if already have quantities of this item
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // If there are already stocks on this item, adjust the quantity
            if (inStock != item) {
                inStock.adjustStock(item.availableQuantity());
            }
            list.put(inStock.getName(), inStock);
            return inStock.availableQuantity();
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if ((inStock != null) && (quantity > 0)) {
            return inStock.finalizingStock(quantity);
        }
        return 0;
    }

    public int reserveStock(String item, int quantity) {
        StockItem inStock = list.get(item);

        if ((inStock != null) && (quantity > 0)) {
            return inStock.reservedStock(quantity);
        }
        return 0;
    }

    public int unreserveStock(String item, int quantity) {
        StockItem inStock = list.get(item);

        if ((inStock != null) && (quantity > 0)) {
            return inStock.unreservedStock(quantity);
        }
        return 0;
    }


    public StockItem getStockItem(String key) {
        return list.get(key);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.availableQuantity();

            s = s + stockItem + "   There are " + stockItem.availableQuantity() + " items in stock. Total value of items: ";
            s = s + String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }

        return s + "    Total stock value " + String.format("%.2f", totalCost);
    }
}
