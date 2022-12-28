import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaTest {
    public static void main(String[] args) {

        List<Person> roster = Arrays.asList(
                new Person("Tom", Person.Sex.MALE, "a@gamil.com", 21),
                new Person("Banana", Person.Sex.MALE, "b@gamil.com", 50),
                new Person("Coke", Person.Sex.MALE, "c@gamil.com", 5),
                new Person("GI JOE", Person.Sex.MALE, "d@gamil.com", 31));


//        printPersons(
//                roster, new CheckPersonEligibleForSelectiveService());

//        printPersons(
//                roster,
//                new CheckPerson() {
//                    public boolean test(Person p) {
//                        return p.getGender() == Person.Sex.MALE
//                                && p.getAge() >= 18
//                                && p.getAge() <= 25;
//                    }
//                }
//        );

//        printPersons(
//                roster,
//                (Person p) -> p.getGender() == Person.Sex.MALE
//                        && p.getAge() >= 18
//                        && p.getAge() <= 25
//        );

//        printPersonsWithPredicate(
//                roster,
//                (Person p) -> p.getGender() == Person.Sex.MALE
//                        && p.getAge() >= 18
//                        && p.getAge() <= 25);

//        processPersons(
//                roster,
//                (Person p) -> p.getGender() == Person.Sex.MALE
//                        && p.getAge() >= 18
//                        && p.getAge() <= 25,
//                Person::printPerson
//        );

//        processPersonsWithFunction(
//                roster,
//                (Person p) -> p.getGender() == Person.Sex.MALE
//                        && p.getAge() >= 18
//                        && p.getAge() <= 25,
//                (Person p) -> p.getEmailAddress(),
//                (String email) -> System.out.println(email)
//        );

//        processElements(
//                roster,
//                (Person p) -> p.getGender() == Person.Sex.MALE
//                        && p.getAge() >= 18
//                        && p.getAge() <= 25,
//                (Person p) -> p.getEmailAddress(),
//                email -> System.out.println(email)
//        );

        roster
                .stream()
                .filter(
                        (Person p) -> p.getGender() == Person.Sex.MALE
                                && p.getAge() >= 18
                                && p.getAge() <= 25)
                .map((Person p) -> p.getEmailAddress())
                .forEach(email -> System.out.println(email));


    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void processPersons(
            List<Person> roster,
            Predicate<Person> tester,
            Consumer<Person> block) {

        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    public static void processPersonsWithFunction(
            List<Person> roster,
            Predicate<Person> tester,
            Function<Person, String> mapper,
            Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

}

class Person {
    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    int age;

    public Person(String name, Sex gender, String emailAddress, int age) {
        this.name = name;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getAge() {
        return age;
    }

    public Sex getGender() {
        return gender;
    }

    public void printPerson() {
        System.out.println(name + " - " + gender + " - " + age);
    }
}

interface CheckPerson {
    boolean test(Person p);
}

class CheckPersonEligibleForSelectiveService implements CheckPerson {
    public boolean test(Person p) {
        return p.gender == Person.Sex.MALE &&
                p.getAge() >= 18 &&
                p.getAge() <= 25;
    }
}