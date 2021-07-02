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
        zedBasket.addToBasket(bread, 10);
        zedBasket.addToBasket(cake, 20);
        zedBasket.addToBasket(door, 3000);
        checkout(zedBasket);

        zedBasket.addToBasket(door, 300);
        checkout(zedBasket);

//        for (Map.Entry<String, Double> price : stockList.PriceList().entrySet()) {
//            System.out.println(price.getKey() + " costs: $" + price.getValue());
//        }
//        System.out.println(zedBasket);


//        System.out.println(stockList);



    }

    public static int checkout(Basket basket) {
        for (Map.Entry<StockItem, Integer> items : basket.Items().entrySet()) {
            StockItem item = stockList.getStockItem(items.getKey().getName());
            if (item.getReserved() <= item.quantityInStock()) {
                item.setReserved(items.getValue());
            } else {
                System.out.println("Stock of " + item.getName() + " not enough!");
                return 0;
            }
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
            basket.addToBasket(stockItem, quantity);

            return quantity;

        }
        return 0;
    }

//    public static int sellItem(Basket basket, String item, int quantity) {
//
//        if (stockItem.quantityInStock() == 0) {
//            System.out.println(item.toUpperCase() + " already sold out !");
//            return 0;
//        }

}
