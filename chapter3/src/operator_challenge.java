public class operator_challenge {

    public static void main(String[] args) {

        double firstValue = 20.00d;
        double secondValue = 80.00d;
        double thirdValue = (firstValue + secondValue) * 100.00;
        System.out.println("(20 + 80) * 100 = " + thirdValue);
        double fourthValue = thirdValue % 40.00;
        System.out.println(thirdValue + " % 40 = " + fourthValue);
        boolean fiveValue = (fourthValue == 0) ? true : false;
        if (!fiveValue) {
            System.out.println("Got some remainder");
        }
        int score = -500;
        if (score > 0) {
            System.out.println("score is positive : " + score);
        } else if (score < 0) {
            System.out.println("score is negative : " + score);
        } else {
            System.out.println("score is : " + score);
        }

        boolean gameOver = true;

        if (gameOver) {
            int gameScore = 788;
            int levelComplete = 5;
            int bonus = 200;
            int finalScore = gameScore + (levelComplete * bonus);
            System.out.println("Your score is : " + finalScore);
        }

    }

}
