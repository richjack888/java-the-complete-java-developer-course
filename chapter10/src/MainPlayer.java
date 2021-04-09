public class MainPlayer {
    public static void main(String[] args) {
        FootballPlayer footballPlayer_joe = new FootballPlayer("Joe");
        BaseballPlayer baseballPlayer_Pat = new BaseballPlayer("Pat");
        SoccerPlayer SoccerPlayer_beckham = new SoccerPlayer("Beckham");

        Team team_Cow = new Team("Cow");
        team_Cow.addPlayer(footballPlayer_joe);
        team_Cow.addPlayer(baseballPlayer_Pat);
        team_Cow.addPlayer(SoccerPlayer_beckham);

        System.out.println(team_Cow.numPlayers());

    }
}
