import java.text.Collator;
import java.util.*;

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

        list.forEach(employee -> System.out.println(employee.getName() +  " , " + employee.getAge()));

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