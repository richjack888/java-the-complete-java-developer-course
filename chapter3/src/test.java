import java.math.BigInteger;

public class test {
    public static void main(String[] args) {
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.MAX_VALUE + 1);
//        System.out.println(Integer.MAX_VALUE + 2);
//        System.out.println(Integer.MAX_VALUE + 9);
//        System.out.println(Integer.MAX_VALUE + 10);
//        System.out.println(Integer.MAX_VALUE);
//
//        int a = 1;
//        System.out.println(a+2147483646);
//        System.out.println(a+2147483647);
//        System.out.println(1+2147483647);
//
//        BigInteger bigInt = new BigInteger("2147483647");
//        bigInt = bigInt.add(BigInteger.ONE);

//        byte minBite = Byte.MIN_VALUE;
//
//        byte maxBite = Byte.MAX_VALUE;
//
//        System.out.println(maxBite);
//        System.out.println(minBite);
//        System.out.println((byte) (maxBite + 1));
//        System.out.println(1 + maxBite);
//        System.out.println(minBite - 1);

//        Integer i = new Integer(10);
//        System.out.println(i.getClass());
//        int i2 = 10;
//        System.out.println(i.getClass());

//        int a = Integer.MAX_VALUE;
//        int b = 1;
//        int c = Math.addExact(a,b); // will throw an ArithmeticException


//        long longNumber = 2147483647;
//        Long longNumber2 = 214748364L;
////        short shortNumber = 541444;
//        System.out.println(longNumber + 2);

//        Integer i = new Integer(10);
//        System.out.println(modify(i));
//        System.out.println(i);
//
//        int i2  = 10;
//        System.out.println(modify2(i2));
//        System.out.println(i2);

//        String a = "a";
//        String b = "a";
//        System.out.println(a == b);

//        Integer i = 5;
//        System.out.println(i.equals(5));
//        byte a = 6;
//        int b = 3;
//
//        int x = (int) 14748364899L;
//        int y = Integer.MAX_VALUE;
//        System.out.println(x > y);

        double myDouble = 2.5;
        float myFloat = (float) myDouble;




    }

    private static Integer modify(Integer i) {
        i = i + 1;
        return i;

    }

    private static int modify2(int i) {
        i = i + 1;
        return i;
    }
}
