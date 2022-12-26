import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmployeeTest {

    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(
                new Employee("Jack", 80),
                new Employee("Banana", 105),
                new Employee("Apple", 33),
                new Employee("Cock", 13));

//        Collections.sort(list);


//        list.sort(Comparator.comparing(Employee::getAge));

//        for (Employee employee : list) {
//            System.out.println(employee.getName() + ", " + employee.getAge());
//        }

//        list.forEach(employee -> {
//                    if (employee.getAge() > 50) {
//                        System.out.println(employee.getName() + " , " + employee.getAge());
//                    }
//                }
//        );

//        for (Employee employee : list) {
//            System.out.println(employee.getName());
//            new Thread(() -> System.out.println(employee.getAge())).start();
//        }

//        CoordinateSystem coordinateSystem = new CoordinateSystem();
//        System.out.println(coordinateSystem.getOrigin());
//        coordinateSystem.getOrigin().x = 15;
//        System.out.println(coordinateSystem.getOrigin());
//        assert coordinateSystem.getOrigin().getX() == 0;
//        System.out.println(coordinateSystem.getOrigin());
//        coordinateSystem.getOrigin() = new Point(5,5);


//        list.stream().filter(employee -> employee.getAge() > 50)
//                .forEach(employee -> System.out.println(employee.getName() + ": " + employee.getAge()));

//        printEmployeeByAge(list, "[Employee who age over 50:]", employee -> employee.getAge() > 50);
//        printEmployeeByAge(list, "[Employee who age under 30:]", employee -> employee.getAge() < 30);
//
//        Random randomno = new Random();
//        // get next boolean value
//        int falseTime = 0;
//        int trueTime = 0;
//        for (int i = 0; i < 100000; i++) {
//            boolean value = randomno.nextBoolean();
//            if(value){
//                trueTime++;
//            }else {
//                falseTime++;
//            }
//
//        }
//
//        System.out.println("trueTime: " + trueTime);
//        System.out.println("falseTime: " + falseTime);


        Function<Employee, String> UpperName = employee -> employee.getName().toUpperCase();



    }

    static void printEmployeeByAge(List<Employee> list,
                                   String ageText,
                                   Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        for (Employee employee : list) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName() + ": " + employee.getAge());
            }
        }
        System.out.println("================================================");


    }
}

class Employee implements Comparable<Employee> {
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Employee o) {
        if (this.age > o.age) {
            return 10000;
        } else if (this.age == o.age) {
            return 0;
        } else {
            return -8765;
        }
    }


}





