import java.util.Arrays;

public class ReverseArrayChallenge {

    public static void main(String[] args) {

        int[] ar = new int[]{11, 22, 3, 22, 44};
        System.out.println(Arrays.toString(reverse(ar)));

    }

    private static int[] reverse(int[] array) {
        int[] reverseArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = (array.length - i - 1); j == (array.length - i - 1); j++) {
                reverseArray[j] = array[i];
            }
        }
        return reverseArray;
    }

}
