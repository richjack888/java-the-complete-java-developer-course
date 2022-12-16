public class Main {

    public static void main(String[] args) throws InterruptedException {
        final BankAccount account = new BankAccount("123-456", 1000.00);

        Thread trThread1 = new Thread(() -> {
            account.deposit(100.00);
            account.withdraw(200.00);
        });

        Thread trThread2 = new Thread(() -> {
            account.deposit(300.00);
            account.withdraw(400.00);
        });

        trThread1.start();
        trThread2.start();

        trThread1.join();
        trThread2.join();

//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        account.printBalance();


    }
}
