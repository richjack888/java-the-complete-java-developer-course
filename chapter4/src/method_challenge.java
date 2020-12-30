public class method_challenge {

    public static void main(String[] args) {

        displayHighScorePosition("Leo", calculateHighScorePosition(1500));
        displayHighScorePosition("Mandy", calculateHighScorePosition(900));
        displayHighScorePosition("Reo", calculateHighScorePosition(400));
        displayHighScorePosition("Amanda", calculateHighScorePosition(50));

    }

    public static void displayHighScorePosition(String playerName, int position) {
        System.out.println(playerName + " to get into position " + position + " on the high score table");
    }

    public static int calculateHighScorePosition(int playerScore) {

        if (playerScore > 1000) {
            return 1;
        } else if (playerScore > 500 && playerScore < 1000) {
            return 2;
        } else if (playerScore > 100 && playerScore < 500) {
            return 3;
        }
        return 4;
    }


}
