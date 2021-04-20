public class MainAccount {
    public static void main(String[] args) {
        Account zedAccount = new Account("zed");
        zedAccount.deposit(1000);
        zedAccount.withdraw(600);
        zedAccount.withdraw(-200);
        zedAccount.deposit(-20);
        zedAccount.calculateBalance();
//        zedAccount.balance = 9999; // 'balance' has private access in 'Account

        System.out.println("Balance on account is " + zedAccount.getBalance() + ".");
    }
}
