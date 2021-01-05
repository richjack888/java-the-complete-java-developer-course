

public class switch_challenge {

    public static void main(String[] args) {
        String word = "monTH";


        switch (word.toLowerCase()) {

            case "month": {
                System.out.println("lower");
                break;
            }
            case "MONTH": {
                System.out.println("UPPER");
                break;
            }
            default: {
                System.out.println("Not Found!");
                break;
            }

        }


    }

}
