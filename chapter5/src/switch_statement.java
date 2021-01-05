public class switch_statement {

    public static void main(String[] args) {

        int value = 25;
        switch (value) {
            case 1: {
                System.out.println("1");
                break;
            }
            case 2: {
                System.out.println("2");
            }
            case 3: {
                System.out.println("3");
            }
            case 4:
            case 5: {
                System.out.println("4, 5");
            }
            default: {
                System.out.println("None of above");
            }
        }

    }

}
