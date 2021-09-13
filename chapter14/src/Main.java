

public class Main {
    public static void main(String[] args) {
        // test
    }
}

interface IPest {
    void BeAnnoying();
}

class HouseFly  implements IPest {
    void FlyAroundYourHead(){
        System.out.println("FlyAroundYourHead");
    }
    void LandOnThings(){
        System.out.println("LandOnThings");
    }

    public void BeAnnoying() {
        FlyAroundYourHead();
        LandOnThings();
    }
}

class Telemarketer  implements IPest {
    void CallDuringDinner(){
        System.out.println("CallDuringDinner");
    }
    void ContinueTalkingWhenYouSayNo(){
        System.out.println("ContinueTalkingWhenYouSayNo");
    }

    public void BeAnnoying() {
        CallDuringDinner();
        ContinueTalkingWhenYouSayNo();
    }
}

class DiningRoom {

//    DiningRoom(IPest[] pests) {
//        pests = new HouseFly();
//    }
//
//    void ServeDinner() {
//        System.out.println("eating");
//
//        foreach pest in pests
//        pest.BeAnnoying();
//    }
}