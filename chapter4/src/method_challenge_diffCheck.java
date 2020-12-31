public class method_challenge_diffCheck {

    public static void main(String[] args) {

        displayHighScorePosition("Leo", calculateHighScorePosition(1500));
        displayHighScorePosition("Mandy", calculateHighScorePosition(900));
        displayHighScorePosition("Reo", calculateHighScorePosition(400));
        displayHighScorePosition("Amanda", calculateHighScorePosition(50));

    }

    public static void displayHighScorePosition(String playerName, int position) {
        System.out.println(" to get into position " + position + " on the high score table");
    }

    public static int calculateHighScorePosition(int playerScore) {

        return (playerScore >= 1000) ? 1 : (playerScore >= 500) ? 2 : (playerScore >= 100) ? 3 : 4;
    }


}
