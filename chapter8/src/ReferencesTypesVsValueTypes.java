import java.util.Arrays;

public class ReferencesTypesVsValueTypes {
    public static void main(String[] args) {
        int[] a = new int[5];
        int[] b = a;
        System.out.println("a: " + Arrays.toString(a));
        System.out.println("b: " + Arrays.toString(b));
        a = new int[]{6, 7, 8, 9, 10};
        b[0] = 66;
        System.out.println("a: " + Arrays.toString(a));
        System.out.println("b: " + Arrays.toString(b));


    }
}
