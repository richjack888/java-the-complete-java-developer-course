public class Hamburger {
    public static void main(String[] args) {
        Burger buger = new Burger("BigPork", "white", "pork", false, true, true, true);
        buger.price();
        Burger buger2 = new Burger("BigPork", "white", "pork", true, true, true, false);
        buger2.price();
        HealthyBurger hg = new HealthyBurger("beef", true, false, false, false, false, false);
        hg.price();
        HealthyBurger hg1 = new HealthyBurger("beef", true, true, true, true, true, true);
        hg1.price();
        DeluxeBurger db = new DeluxeBurger(false, true);
        db.price();
        DeluxeBurger db2 = new DeluxeBurger(true, true);
        db2.price();

    }
}

class Burger {
    HealthyBurger health;
    private String name;
    private String bread_roll_type;
    private String meat;
    private String additionalStr;
    private boolean lettuce;
    private boolean tomato;
    private boolean carrot;
    private boolean onion;
    private int price;


    public Burger(String name, String bread_roll_type, String meat, boolean lettuce, boolean tomato, boolean carrot, boolean onion) {
        this.name = name;
        this.bread_roll_type = bread_roll_type;
        this.meat = meat;
        this.lettuce = lettuce;
        this.tomato = tomato;
        this.carrot = carrot;
        this.onion = onion;
        price = 2;
        setAdditionalStr((this.lettuce ? " lettuce, " : "")
                + (this.tomato ? " tomato, " : "")
                + (this.carrot ? " carrot, " : "")
                + (this.onion ? " onion, " : ""));
    }


    public int price() {
        if (lettuce) {
            price += 1;
        }
        if (tomato) {
            price += 1;
        }
        if (carrot) {
            price += 1;
        }
        if (onion) {
            price += 1;
        }
        System.out.println(getClass().getSimpleName() + " " + this.name + " on " + this.bread_roll_type + " bread ");
        System.out.println("addition contain: " + (additionalStr != null ? additionalStr : ""));
        System.out.println("total price is : $" + getPrice());
        System.out.println();

        return price;

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAdditionalStr(String additionalStr) {
        this.additionalStr = additionalStr;
    }
}

class HealthyBurger extends Burger {
    private boolean peanut;
    private boolean corn;

    public HealthyBurger(String meat, boolean lettuce, boolean tomato, boolean carrot, boolean onion, boolean peanut, boolean corn) {
        super("Healthy", "Brown rye", meat, lettuce, tomato, carrot, onion);
        this.peanut = peanut;
        this.corn = corn;
    }


    @Override
    public int price() {
        int price = getPrice();
        if (isPeanut()) {
            setPrice(price + 1);
        }
        if (isCorn()) {
            setPrice(price + 1);
        }
        setAdditionalStr((isPeanut() ? "peanut, " : "") + (isCorn() ? "corn " : ""));
        return super.price();
    }

    public boolean isPeanut() {
        return peanut;
    }

    public boolean isCorn() {
        return corn;
    }
}

class DeluxeBurger extends Burger {
    private boolean chips;
    private boolean drinks;

    public DeluxeBurger(boolean chips, boolean drinks) {
        super("Deluxe", "White", "Bacon", false, false, false, false);
        this.chips = chips;
        this.drinks = drinks;
    }

    @Override
    public int price() {
        if (isChips()) {
            int price = getPrice();
            setPrice(price + 1);
        }
        if (isDrinks()) {
            int price = getPrice();
            setPrice(price + 1);
        }
        setAdditionalStr((isChips() ? "chips, " : "") + (isDrinks() ? "drinks " : ""));

        return super.price();
    }

    public boolean isChips() {
        return chips;
    }

    public boolean isDrinks() {
        return drinks;
    }
}

