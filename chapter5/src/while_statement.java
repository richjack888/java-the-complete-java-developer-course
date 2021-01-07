public class while_statement {

    public static void main(String[] args) {
        int count = 1;

        while (count <= 6) {
            System.out.println("Count :" + count);
            count++;
        }

        for (int i = count; i <= 6; i++) {
            System.out.println("Count :" + count);
            count++;
        }

        do {
            System.out.println("Count :" + count);
            count++;

        } while (count < 100);
    }

}
