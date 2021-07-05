package StockChallenge;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem bread = new StockItem("bread", 1, 100);
        stockList.addStock(bread);

        StockItem cake = new StockItem("cake", 2, 200);
        stockList.addStock(cake);

        StockItem door = new StockItem("door", 3, 300);
        stockList.addStock(door);

        Basket zedBasket = new Basket("Zed");
        Basket zaraBasket = new Basket("Zara");
        zedBasket.addToBasket(bread, 5);
        zedBasket.addToBasket(cake, 10);

        zaraBasket.addToBasket(bread, 15);
        zaraBasket.addToBasket(cake, 20);
        
        checkout(zaraBasket, true);
        checkout(zedBasket, false);

        System.out.println(zedBasket);
        System.out.println();
        System.out.println(zaraBasket);
        System.out.println();
        System.out.println(stockList);


    }

    public static int checkout(Basket basket, Boolean bool) {
        if (!bool) {
            System.out.println("Not checkout!");
            for (Map.Entry<StockItem, Integer> items : basket.Items().entrySet()) {
                StockItem item = stockList.getStockItem(items.getKey().getName());
                item.setReserved(item.getReserved() - items.getValue());
            }
            return 0;
        }
        for (Map.Entry<StockItem, Integer> items : basket.Items().entrySet()) {
            StockItem item = stockList.getStockItem(items.getKey().getName());
            sellItem(basket, item.getName(), item.getReserved());
        }
        return 1;

    }


    public static int sellItem(Basket basket, String item, int quantity) {
        //retrieve the item from stock list
        StockItem stockItem = stockList.getStockItem(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (stockList.sellStock(item, quantity) != 0) {
            return quantity;

        }
        return 0;
    }

}
