import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class test {
    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(
                new Employee("Jack", 80),
                new Employee("Banana", 105),
                new Employee("Apple", 33),
                new Employee("Cock", 13));

        Collections.sort(list);


//        list.sort(Comparator.comparing(Employee::getAge));

//        for (Employee employee : list) {
//            System.out.println(employee.getName() + ", " + employee.getAge());
//        }

        list.forEach(employee -> {
                    if (employee.getAge() > 50){
                        System.out.println(employee.getName() + " , " + employee.getAge());
                    }
                }
        );

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


    }

    static final class CoordinateSystem {
        private final Point origin = new Point(0, 0);

        public Point getOrigin() {
            return origin;
        }
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


