import java.util.Arrays;

public class ReverseArrayChallenge_TimVersion {

    public static void main(String[] args) {

        int[] array = {2, 64, 34, 66};
        reverse(array);
        System.out.println(Arrays.toString(array));

    }

    private static void reverse(int[] array) {
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;
        for (int i = 0; i < halfLength; i++) {
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;

        }
    }

}
