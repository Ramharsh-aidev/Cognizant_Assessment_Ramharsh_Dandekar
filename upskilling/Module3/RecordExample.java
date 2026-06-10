import java.util.List;
import java.util.stream.Collectors;

// Define a record
record Person(String name, int age) {
}

public class RecordExample {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Bob", 17);
        Person p3 = new Person("Charlie", 30);

        System.out.println("Printing a record instance directly:");
        System.out.println(p1); // automatically implements toString()

        List<Person> people = List.of(p1, p2, p3);

        List<Person> adults = people.stream()
                .filter(p -> p.age() >= 18)
                .collect(Collectors.toList());

        System.out.println("\nFiltered Adults (age >= 18):");
        System.out.println(adults);
    }
}
