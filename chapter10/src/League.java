import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    ArrayList<T> teams = new ArrayList<>();
    private String name;


    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addTeam(T team) {
        if (this.teams.contains(team)) {
            System.out.println(team.getName() + " already in the league.");
            return false;
        } else {
            teams.add(team);
            System.out.println(team.getName() + " be add to " + this.getName());
            return true;
        }
    }

    public void teamOnLeagueByOrder() {
        Collections.sort(teams);
        for (int i = 0; i < teams.size(); i++) {
            System.out.println("No." + (i + 1) + " is team " + teams.get(i).getName() + " ranking : " + teams.get(i).ranking());
        }
    }


}
