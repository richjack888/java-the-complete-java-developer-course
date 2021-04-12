public class MainPlayer {
    public static void main(String[] args) {

        League<Team<FootballPlayer>> footballLeague = new League<>("football league");
        Team<FootballPlayer> football_Team_1 = new Team<FootballPlayer>("football-1");
        Team<FootballPlayer> football_Team_2 = new Team<FootballPlayer>("football-2");
        Team<FootballPlayer> football_Team_3 = new Team<FootballPlayer>("football-3");

        footballLeague.addTeam(football_Team_1);
        footballLeague.addTeam(football_Team_2);
        footballLeague.addTeam(football_Team_3);

        football_Team_1.matchResult(football_Team_2, 1, 0);
        football_Team_1.matchResult(football_Team_2, 2, 0);
        football_Team_1.matchResult(football_Team_2, 3, 0);

        football_Team_1.matchResult(football_Team_3, 1, 0);
        football_Team_1.matchResult(football_Team_3, 2, 0);
        football_Team_1.matchResult(football_Team_2, 3, 0);

        football_Team_2.matchResult(football_Team_2, 3, 0);
        football_Team_2.matchResult(football_Team_2, 4, 0);
        football_Team_2.matchResult(football_Team_2, 5, 0);

        footballLeague.teamOnLeagueByOrder();

//        Team<BaseballPlayer> baseballTeam = new Team<>("Baseball team");
//        footballLeague.addTeam(baseballTeam);
        // can't be add another sport


    }
}
