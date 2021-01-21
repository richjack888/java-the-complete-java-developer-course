public class ChallengeBedroom {
    private String name;
    private ChallengeWall wall1;
    private ChallengeWall wall2;
    private ChallengeWall wall3;
    private ChallengeWall wall4;
    private ChallengeCeiling ceiling;
    private ChallengeBed bed;
    private ChallengeLamp lamp;

    public ChallengeBedroom(String name, ChallengeWall wall1, ChallengeWall wall2, ChallengeWall wall3, ChallengeWall wall4, ChallengeCeiling ceiling, ChallengeBed bed, ChallengeLamp lamp) {
        this.name = name;
        this.wall1 = wall1;
        this.wall2 = wall2;
        this.wall3 = wall3;
        this.wall4 = wall4;
        this.ceiling = ceiling;
        this.bed = bed;
        this.lamp = lamp;
    }

    public ChallengeLamp getLamp() {
        return this.lamp;
    }

    public void makeBed() {
        System.out.println("Bedroom -> Making bed");
        bed.make();
    }


}
