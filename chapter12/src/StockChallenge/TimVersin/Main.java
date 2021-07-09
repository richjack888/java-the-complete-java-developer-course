package StockChallenge.TimVersin;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 50);
        System.out.println("First add: "  + stockList.addStock(temp));
        System.out.println(stockList);
        System.out.println("Open store!");

        Basket timsBasket = new Basket("Tim");
        sellItem(timsBasket, "bread", 40);
        System.out.println(stockList);
        System.out.println("Sell some stock!");
//
//        StockItem temp2 = new StockItem("bread", 0.86, 50);
//        stockList.addStock(temp2);
        System.out.println("Second add: " + stockList.addStock(temp));
        //check here
        System.out.println(stockList);
        System.out.println("Refill stock");




//        temp = new StockItem("cake", 1.10, 7);
//        stockList.addStock(temp);
//
//        temp = new StockItem("car", 12.50, 2);
//        stockList.addStock(temp);
//
//        temp = new StockItem("chair", 62.0, 10);
//        stockList.addStock(temp);
//
//        temp = new StockItem("cup", 0.50, 200);
//        stockList.addStock(temp);
//        temp = new StockItem("cup", 0.45, 7);
//        stockList.addStock(temp);
//
//        temp = new StockItem("door", 72.95, 4);
//        stockList.addStock(temp);
//
//        temp = new StockItem("juice", 2.50, 36);
//        stockList.addStock(temp);
//
//        temp = new StockItem("phone", 96.99, 35);
//        stockList.addStock(temp);
//
//        temp = new StockItem("towel", 2.40, 80);
//        stockList.addStock(temp);
//
//        temp = new StockItem("vase", 8.76, 40);
//        stockList.addStock(temp);
//
//        System.out.println(stockList);

//        Basket timsBasket = new Basket("Tim");
//
//        sellItem(timsBasket, "car", 1);
//        System.out.println(timsBasket);
//
//        sellItem(timsBasket, "car", 1);
//        System.out.println(timsBasket);
//
//        if (sellItem(timsBasket, "car", 1) != 1) {
//            System.out.println("There are no more cars in stock");
//        }
//
//        sellItem(timsBasket, "spanner", 5);
//        sellItem(timsBasket, "juice", 4);
//        sellItem(timsBasket, "cup", 12);
//        sellItem(timsBasket, "bread", 1);
//        System.out.println(timsBasket);
//
//        Basket basket = new Basket("customer");
//        sellItem(basket, "cup", 100);
//        sellItem(basket, "juice", 5);
//        removeItem(basket, "cup", 1);
//        System.out.println(basket);
//
//        removeItem(timsBasket, "car", 1);
//        removeItem(timsBasket, "cup", 9);
//        removeItem(timsBasket, "car", 1);
//        System.out.println("cars removed: " + removeItem(timsBasket, "car", 1));  // should not remove any
//
//        System.out.println(timsBasket);
//
//        // remove all items from timsBasket
//        removeItem(timsBasket, "bread", 1);
//        removeItem(timsBasket, "cup", 3);
//        removeItem(timsBasket, "juice", 4);
//        removeItem(timsBasket, "cup", 3);
//        System.out.println(timsBasket);
//
//        System.out.println("\nDisplay stock list before and after checkout");
//        System.out.println(basket);
//        System.out.println(stockList);
//        checkOut(basket);
//        System.out.println(basket);
//        System.out.println(stockList);
//
//        StockItem car = stockList.Items().get("car");
//        if (car != null) {
//            car.adjustStock(2000);
//        }
//        if (car != null) {
//            stockList.getStockItem("car").adjustStock(-1000);
//        }
//
//        System.out.println(stockList);
//        checkOut(timsBasket);
//        System.out.println(timsBasket);

    }

    public static int sellItem(Basket basket, String item, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.getStockItem(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
        }

        if (stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity); // need to check
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.getStockItem(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
        }

        if (basket.removeFromBasket(stockItem, quantity) != 0) {
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    public static int checkOut(Basket basket) {
        for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
        return 0;
    }
}
