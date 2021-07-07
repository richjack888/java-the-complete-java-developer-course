package StockChallenge.TimVersin;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityInStock = 0;
    private int reserved;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityInStock = 0; // or here ( but you wouldn't normally do both)
    }

    public StockItem(String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
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

    public int availableQuantity() {
        return quantityInStock - reserved;
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityInStock + quantity;
        if (newQuantity >= 0) {
            this.quantityInStock = newQuantity;
        }
    }

    public int reservedStock(int quantity) {
        if (quantity <= availableQuantity()) {
            this.reserved += quantity;
            return quantity;
        }
        return 0;
    }

    public int unreservedStock(int quantity) {
        if (quantity <= this.reserved) {
            this.reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    public int finalizingStock(int quantity) {
        if (quantity <= this.reserved) {
            this.reserved -= quantity;
            this.quantityInStock -= quantity;
            return quantity;
        }
        return 0;
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
        return name + " : $" + price + " .reserved: " + this.reserved ;
    }
}
