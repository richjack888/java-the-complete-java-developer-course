package Stock;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("bread", 0.2, 500);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);


//        for (String s : stockList.Items().keySet()) {
//            System.out.println(s);
//        }

//        Basket zedBasket = new Basket("Zed");
//        sellItem(zedBasket, "car", 1);
//        System.out.println(zedBasket);
//
//        sellItem(zedBasket, "car", 1);
//        System.out.println(zedBasket);
//
//
//        sellItem(zedBasket, "car", 1);
//        sellItem(zedBasket, "something", 1);
//        System.out.println(zedBasket);
//
//        sellItem(zedBasket, "juice", 4);
//        sellItem(zedBasket, "cup", 12);
//        sellItem(zedBasket, "bread", 1);
//        System.out.println(zedBasket);
//

//        temp = new StockItem("pen", 1.5);
//        stockList.Items().put(temp.getName(), temp);

//        stockList.Items().get("car").adjustStock(2000);
//        stockList.getStockItem("car").adjustStock(-1000);
//        System.out.println(stockList);

        for (Map.Entry<String, Double> price : stockList.PriceList().entrySet()) {
            System.out.println(price.getKey() + " costs: $" + price.getValue());
        }

    }

    public static int sellItem(Basket basket, String item, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.getStockItem(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }

        if (stockItem.quantityInStock() == 0) {
            System.out.println(item.toUpperCase() + " already sold out !");
            return 0;
        }

        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }

        return 0;
    }
}
