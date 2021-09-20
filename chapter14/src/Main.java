import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
//        HouseFly houseFly = new HouseFly();
//        Telemarketer telemarketer = new Telemarketer();
//        DiningRoom diningRoom = new DiningRoom(new IPest[]{houseFly, telemarketer});
//        diningRoom.ServeDinner();

//        Student student = new Student();
//        student.setName("");

//        String directoryPath = "src/introduceIo";
//        File file = new File(directoryPath);
//
//        if (file.isDirectory()) {
//            System.out.println("File is a Directory");
//        }
//        else {
//            System.out.println("Directory doesn't exist!!");
//        }

//        String directoryPath = "src/introduceIo";
//
//        Path path = Paths.get(directoryPath);
//        boolean isDir = Files.isDirectory(path);
//
//        if (isDir) {
//            System.out.println("File is a Directory");
//        }
//        else {
//            System.out.println("Directory doesn't exist!!");
//        }
//        String s = "Hello";
//        s.concat(" World");  // returns a new String object
//        System.out.println(s);  // prints Hello - not Hello World.

        System.out.println("Enter a number");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if(a != 0){
            throw new Exception("fuck you, I need a zero!");
        }
        int b = scanner.nextInt();

        System.out.println(a/b);

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