package StockChallenge;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem bread = new StockItem("bread", 1, 100);
        stockList.addStock(bread);

        StockItem cake = new StockItem("cake", 2, 100);
        stockList.addStock(cake);

        StockItem door = new StockItem("door", 3, 100);
        stockList.addStock(door);

        Basket zedBasket = new Basket("Zed");
        Basket kenBasket = new Basket("Ken");
        Basket doraBasket = new Basket("Dora");
        zedBasket.addToBasket(bread, 10);
        kenBasket.addToBasket(bread, 10);
        doraBasket.addToBasket(bread, 10);

        zedBasket.addToBasket(cake, 10);
        kenBasket.addToBasket(cake, 10);
        doraBasket.addToBasket(cake, 10);

        zedBasket.addToBasket(door, 10);
        kenBasket.addToBasket(door, 10);
        doraBasket.addToBasket(door, 10);
        checkout(zedBasket, false);

        kenBasket.addToBasket(bread, 80);
        doraBasket.addToBasket(bread, 10);
        checkout(kenBasket, true);

        doraBasket.addToBasket(cake, 10);
        doraBasket.addToBasket(cake, 300);
        checkout(doraBasket, true);

        zedBasket.addToBasket(bread, 10);
        zedBasket.addToBasket(cake, 10);
        zedBasket.addToBasket(door, 10);
        checkout(zedBasket, true);

        System.out.println(stockList);

    }

    public static int checkout(Basket basket, Boolean bool) {
        if (!bool) {
            for (Map.Entry<StockItem, Integer> items : basket.Items().entrySet()) {
                StockItem item = stockList.getStockItem(items.getKey().getName());
                item.setReserved(item.getReserved() - items.getValue());
            }

            printoutAndClear(basket);
            return 0;
        }
        for (Map.Entry<StockItem, Integer> items : basket.Items().entrySet()) {
            StockItem item = stockList.getStockItem(items.getKey().getName());
            sellItem(basket, item.getName(), items.getValue());
        }
        printoutAndClear(basket);
        return 1;

    }

    public static void printoutAndClear(Basket basket) {
        System.out.println(basket);
        System.out.println(basket.getName() + "'s basket not checkout!\n");
        basket.clear();
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
