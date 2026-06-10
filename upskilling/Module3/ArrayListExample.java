import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;
        
        System.out.println("Enter student names (type 'done' to finish):");
        while (true) {
            System.out.print("Name: ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            students.add(input);
        }
        
        System.out.println("\nList of Students:");
        for (String student : students) {
            System.out.println("- " + student);
        }
        scanner.close();
    }
}
