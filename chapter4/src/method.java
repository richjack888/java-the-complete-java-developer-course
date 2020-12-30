public class method {

    public static void main(String[] args) {

        boolean gameOver = true;
        int playerA = calculate(gameOver, 1000, 20, 100);
        int playerB = calculate(gameOver, 20, 5, 100);

        if (playerA > playerB) {
            System.out.println("playerA Win!!!");
        } else {
            System.out.println("playerB Win!!");
        }
    }

    public static int calculate(boolean gameOver, int gameScore, int levelComplete, int bonus) {

        if (gameOver) {
            int finalScore = gameScore + (levelComplete * bonus);
            System.out.println("finalScore : " + finalScore);
            return finalScore;
        } else {
            return -1;
        }

    }

}
