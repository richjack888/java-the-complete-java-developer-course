public class Main {
    public static void main(String[] args) {
//        System.out.println("结果： " + new Main().test());

        int x=5;
        int y=++x;
        System.out.println("x=" + x + ", y=" + y);

    }

    static int test() {
        int i = 1;
        try {
            System.out.println("try里面的i : " + i);
            return i;
        } finally {
            System.out.println("进入finally...");
            ++i;
            System.out.println("fianlly里面的i : " + i);
        }
    }
}
