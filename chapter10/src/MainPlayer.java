public class MainPlayer {
    public static void main(String[] args) {
//        FootballPlayer footballPlayer_joe = new FootballPlayer("Joe(football player)");
//        BaseballPlayer baseballPlayer_Pat = new BaseballPlayer("Pat(baseball player)");
//        SoccerPlayer SoccerPlayer_beckham = new SoccerPlayer("Beckham(soccer player)");

//        Team<FootballPlayer> football_Team_1 = new Team<FootballPlayer>("Go-football-1");
//        football_Team.addPlayer(footballPlayer_joe);
//        System.out.println(football_Team.numPlayers());

//        Team<BaseballPlayer> baseball_Team = new Team<>("Go-baseball");
//        baseball_Team.addPlayer(baseballPlayer_Pat);
//        System.out.println(baseball_Team.numPlayers());

//        Team<SoccerPlayer> soccer_Team = new Team<>("GO-soccer");
//        soccer_Team.addPlayer(SoccerPlayer_beckham);
//        System.out.println(soccer_Team.numPlayers());

//        football_Team.matchResult(baseball_Team, 0, 1);
//        football_Team.matchResult(soccer_Team, 1, 0);

        Team<FootballPlayer> football_Team_1 = new Team<FootballPlayer>("Go-football-1");
        Team<FootballPlayer> football_Team_2 = new Team<FootballPlayer>("Go-football-2");
        football_Team_1.matchResult(football_Team_2, 1, 0);
        football_Team_1.matchResult(football_Team_2, 2, 0);
        football_Team_1.matchResult(football_Team_2, 3, 0);
        System.out.println("Ranking-----------");
        System.out.println(football_Team_1.getName() + " : " + football_Team_1.ranking());
        System.out.println(football_Team_2.getName() + " : " + football_Team_2.ranking());
        System.out.println(football_Team_1.compareTo(football_Team_2));
        System.out.println(football_Team_2.compareTo(football_Team_1));


    }
}
