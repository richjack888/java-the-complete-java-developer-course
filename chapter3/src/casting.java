public class casting {
    public static void main(String[] args) {
        byte MyMaxBite = Byte.MAX_VALUE;
        short MaxShortValue = Short.MAX_VALUE;

        byte NewHalfBiteValue = (byte) (MyMaxBite/2);
        short NewHalfShortValue = (short)(MaxShortValue/2);

        System.out.println("NewHalfBiteValue:" + (NewHalfBiteValue));
        System.out.println("NewHalfShortValue:" + (NewHalfShortValue));

    }
}
