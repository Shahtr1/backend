package stream_api.list;

import java.util.Comparator;
import java.util.List;

public class SortPersonByName {
    static class Person {
        private String name;

        Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person [name=" + name + "]";
        }

    }

    public static void main(String[] args) {
        Person emp1 = new Person("one");
        Person emp2 = new Person("two");
        Person emp3 = new Person("three");
        Person emp4 = new Person("four");
        Person emp5 = new Person("fir");

        List<Person> employees = List.of(emp1, emp2, emp3, emp4, emp5);

        employees.stream().sorted(Comparator.comparing(person -> person.name)).forEach(System.out::println);
    }
}
