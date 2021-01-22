public class Player {

    public String name;
    public int hp = 100;
    public String weapon;

    public Player(String name, int hp, String weapon) {
        this.name = name;
        if (hp > 0 && hp <= 100) {
            this.hp = hp;
        }
        this.weapon = weapon;
    }

    public void loseHealth(int damage) {
        System.out.println("Lose hp: " + damage);
        this.hp -= damage;
        if (hp <= 0) {
            this.hp = 0;
            System.out.println("GG!");
        }
    }

    public int hpCheck() {
        System.out.println("HP: " + this.hp);
        return this.hp;
    }
}
