import java.util.Arrays;

public class ReverseArray {

    private static void reverse(int[] array) {
        int backToStart = array.length - 1;
        System.out.println("Array = " + Arrays.toString(array));
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[backToStart];
            array[backToStart] = temp;
            backToStart--;

        }
        System.out.println("Reversed array = " + Arrays.toString(array));
    }
}


