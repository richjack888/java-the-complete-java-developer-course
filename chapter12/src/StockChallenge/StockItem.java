package StockChallenge;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock = 0;
    private int reserved;

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0; // or here ( but you wouldn't normally do both)
        this.reserved = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
        this.reserved = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if (newQuantity >= 0) {
            this.quantityStock = newQuantity;
        }
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 17;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Call Stock.StockItem.equals()");
        if (obj == this) {
            return true;
        }

        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Call Stock.StockItem.compareTo()");
        if (this == o) {
            return 0;
        }
        if (o != null) {
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return name + " : $" + price;
    }
}
