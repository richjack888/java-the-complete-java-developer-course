

public class Main {
    public static void main(String[] args) {
//        HouseFly houseFly = new HouseFly();
//        Telemarketer telemarketer = new Telemarketer();
//        DiningRoom diningRoom = new DiningRoom(new IPest[]{houseFly, telemarketer});
//        diningRoom.ServeDinner();

        Student student = new Student();
        student.setName("");
    }
}

interface IPest {
    void BeAnnoying();
}

class HouseFly implements IPest {
    void FlyAroundYourHead() {
        System.out.println("FlyAroundYourHead");
    }

    void LandOnThings() {
        System.out.println("LandOnThings");
    }

    public void BeAnnoying() {
        FlyAroundYourHead();
        LandOnThings();
    }
}

class Telemarketer implements IPest {
    void CallDuringDinner() {
        System.out.println("CallDuringDinner");
    }

    void ContinueTalkingWhenYouSayNo() {
        System.out.println("ContinueTalkingWhenYouSayNo");
    }

    public void BeAnnoying() {
        CallDuringDinner();
        ContinueTalkingWhenYouSayNo();
    }
}

class DiningRoom {
    IPest[] pests;

    DiningRoom(IPest[] pests) {
        this.pests = pests;
    }

    void ServeDinner() {
        System.out.println("when diningPeople are eating...");
        for (IPest pest : pests) {
            if (pest instanceof HouseFly) {
                pest.BeAnnoying();
            }
        }
    }
}

class Student {

    private String name;
    private int age;

    public void setName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name is invalid");
        }

        this.name = name;
    }

    public void setAge(int age) {
        if (age < 1 || age > 100) {
            throw new IllegalArgumentException("Age is invalid");
        }

        this.age = age;
    }
}