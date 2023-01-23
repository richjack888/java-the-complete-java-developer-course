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

//        Double myDouble = 2.5;
//        System.out.println(myDouble.getClass());

//        System.out.println(8e7);

//        double pound = 100;
//        double kilogram = pound * 0.45359237;
//        System.out.println(kilogram);

//        // calculate pi
//        double pi = 0;
//        for (int i = 1; i <= 10000000; i++) {
//            pi += Math.pow(-1, i + 1) / (2 * i - 1);
//        }
//        pi *= 4;
//        System.out.println(pi);

//        char mychar = '\u9876';
//        System.out.println(mychar);

//        char mySimplechar = '?';
//        System.out.println(mySimplechar);
//        char myUnicodechar = '\u003F';
//        System.out.println(myUnicodechar);
//        char myDecimalchar = 63;
//        System.out.println(myDecimalchar);

//        int myInt = Integer.parseInt("123456");
//        System.out.println(Integer.reverse(myInt));

//        int myInt2 = 10;
//        String myString = "Hello";
//        System.out.println(myInt2 + myString);

//        char firstChar = 'A';
//        char secondChar = 'B';
//        System.out.println(firstChar + secondChar);

//        int result = 10;
//        result -= 5.5;
//        System.out.println(result);





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
