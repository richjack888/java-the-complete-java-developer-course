import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5};
        reverse(ar);
        System.out.println(Arrays.toString(ar));
    }

    private static void reverse(int[] array) {

        int halfLength = array.length / 2;

        for (int i = 0; i < array.length; i++) {
            if (i > halfLength) {
                break;
            }
            for (int j = (array.length - i - 1); j == (array.length - i - 1); j++) {
                array[j] = array[i];
            }
        }

    }

}
