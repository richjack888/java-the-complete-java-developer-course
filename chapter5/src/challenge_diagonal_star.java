public class challenge_diagonal_star {

    public static void main(String[] args) {
//        printSquareStar(5);
        printSquareStar(10);

    }

    public static void printSquareStar(int number) {

        if (number < 5) System.out.println("Invalid Value");
        else {
//            for (int row = 1; row <= number; row++) {
//                for (int col = 1; col <= number; col++) {
//                    if ((row == 1) || (col == 1) || (row == number) || (col == number) || (row == col) || (col == number - row + 1)) {
//                        System.out.print("*");
//                    } else {
//                        System.out.print(" ");
//                    }
//                    if (col == number) System.out.println();
//                }
//
//            }
            for (int row = 1; row <= number; row++) {
                for (int column = 1; column <= number; column++) {
                    if (row == 1 || row == number) System.out.print("1");
                    else if (column == 1) System.out.print("2");
                    else if (column == number) System.out.print("3");
                    else if (column == row) System.out.print("4");
                    else if (column == number + 1 - row) System.out.print("5");
                    else System.out.print("-");
                }
                System.out.println("");
            }


        }


    }

}
