public class Vip_Customer {

    private String name;
    private double creditLimit;
    private String emailAddress;

    public Vip_Customer() {
        this("Default name", 666, "Defalut email");
    }

    public Vip_Customer(String name, String emailAddress) {
        this(name, 666, emailAddress);
    }

    public Vip_Customer(String name, double creditLimit, String emailAddress) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
        System.out.println("Start");
        System.out.println("name: " + this.getName() +
                "\ncreditLimit: " + this.getCreditLimit() +
                "\nemail: " + this.getEmailAddress());
        System.out.println("------");
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
