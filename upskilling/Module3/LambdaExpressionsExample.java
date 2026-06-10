import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaExpressionsExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob", "Eve", "Dave");
        
        System.out.println("Before sorting: " + names);
        
        // Sorting using lambda expression
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
        
        System.out.println("After sorting: " + names);
    }
}
