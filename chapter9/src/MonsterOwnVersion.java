import java.util.ArrayList;
import java.util.List;

public class MonsterOwnVersion implements ISaveable {

    private String name;
    private int hitPoints;
    private int strength;

    public MonsterOwnVersion(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }


    @Override
    public String toString() {
        return "Monsters{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }

    @Override
    public ArrayList<String> write() {
        ArrayList<String> values = new ArrayList<String>();
        values.add(0, name);
        values.add(1, "" + hitPoints);
        values.add(2, "" + strength);
        return values;

    }

    @Override
    public void update(List<String> savedValues) {
        if (savedValues != null && savedValues.size() > 0) {
            name = savedValues.get(0);
            hitPoints = Integer.parseInt(savedValues.get(1));
            strength = Integer.parseInt(savedValues.get(2));
        }
    }
}
