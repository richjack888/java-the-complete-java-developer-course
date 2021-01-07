public class iseven_number {

    public static void main(String[] args) {

        int startNumber = 20;
        int endNumber = 30;
        int evenNumberSum = 0;
        int count = 0;

        do {
            startNumber++;
            if (!isEvenNumber(startNumber)) {
                continue;
            }

            System.out.println("Even number : " + startNumber);
            evenNumberSum += startNumber;
            count++;
            System.out.println("Count : " + count);

            if (count == 5) {
                break;
            }

        } while (startNumber <= endNumber);
        System.out.println("Even number sum : " + evenNumberSum);


    }

    public static boolean isEvenNumber(int number) {
        return (number % 2 == 0);
    }
}
