public class TestClass {
    private static Runnable r;
    // same as with constructor, you don't have this value of 'i' outside
    // of static block, and you are not printing here anything
    static {
        final int i = 10;
        r = new Runnable() {
            @Override
            public void run() {
                System.out.println("i was " + i);
            }
        };
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(r);
        t1.start();
    }
}