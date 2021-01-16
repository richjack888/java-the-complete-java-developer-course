public class Bank {

    private int accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private int phoneNumber;

    public static void main(String[] args) {
        Bank westdoor = new Bank();
        westdoor.deposit(500);
        System.out.println(westdoor.getBalance());
        westdoor.withdraw(600);
        westdoor.withdraw(250);
        System.out.println(westdoor.getBalance());

    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void deposit(double money) {
        this.setBalance(this.getBalance() + money);
    }

    public void withdraw(int money) {
        if (money > this.getBalance()) {
            System.out.println("Not enough");
        } else this.setBalance(this.getBalance() - money);
    }


}
