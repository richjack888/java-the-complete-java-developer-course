public class test {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            System.out.println("Round " + (i + 1));
            // random generate width from 1 to 100
            int width = (int) (Math.random() * 100 + 1); // +1 to avoid 0
            System.out.println("print star with width: " + width);
            printStar(width);
            System.out.println();
        }
    }

    public static void printStar(int width) {
        // top part
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // bottom part
        for (int i = width - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
