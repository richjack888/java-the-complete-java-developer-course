import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new HashMap<>();
    }

    public int addStock(StockItem stockItem) {
        if (stockItem != null) {
            // check if already have stockItem, jf get null just pass stockItem of parameter
            StockItem inStock = list.getOrDefault(stockItem.getName(), stockItem);
            // if there are already stocks on this item, adjust the quantity
            if (inStock != stockItem) {
                stockItem.adjustStock(inStock.quantityInStock());
            }
            list.put(stockItem.getName(), stockItem);
            return stockItem.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);
        if ((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity > 0)) {
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem getStockItem(String key) {
        return list.get(key);
    }

    public Map<String, StockItem> Item() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

            s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: ";
            s = s + itemValue + "\n";
            totalCost += itemValue;
        }

        return s + " Total stock value " + totalCost;
    }
}
