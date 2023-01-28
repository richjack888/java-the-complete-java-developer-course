package Pojo;

public class Main {

    public static void main(String[] args) {
//        System.out.println("This is pojo student.");
//        for (int i = 1; i <= 5; i++) {
//            Student s = new Student("S92300" + i,
//                    switch (i) {
//                        case 1 -> "Mary";
//                        case 2 -> "Carol";
//                        case 3 -> "Tim";
//                        case 4 -> "Harry";
//                        case 5 -> "Lisa";
//                        default -> "Anonymous";
//                    },
//                    "05/11/1985",
//                    "Java Masterclass");
//            System.out.println(s);
//        }
//
//        System.out.println("This is record student.");
//        for (int i = 1; i <= 5; i++) {
//            RecordStudent s = new RecordStudent("S92300" + i,
//                    switch (i) {
//                        case 1 -> "Mary";
//                        case 2 -> "Carol";
//                        case 3 -> "Tim";
//                        case 4 -> "Harry";
//                        case 5 -> "Lisa";
//                        default -> "Anonymous";
//                    },
//                    "05/11/1985",
//                    "Java Masterclass");
//            System.out.println(s);
//        }

        Student pojoStudent = new Student("S923001", "Mary", "05/11/1985", "Java Masterclass");
        RecordStudent recordStudent = new RecordStudent("S923001", "Mary", "05/11/1985", "Java Masterclass");
//        System.out.println(pojoStudent.getName() + "is taking " + pojoStudent.getClassList());
//        System.out.println(recordStudent.name() + "is taking " + recordStudent.classList());

        System.out.println(pojoStudent);


    }
}
