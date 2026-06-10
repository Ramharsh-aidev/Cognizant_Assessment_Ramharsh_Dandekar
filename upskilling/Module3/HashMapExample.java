import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Add students to the map (enter ID 0 to finish):");
        while (true) {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            if (id == 0) break;
            
            scanner.nextLine(); // consume newline
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            
            studentMap.put(id, name);
        }
        
        System.out.print("\nEnter a Student ID to search: ");
        int searchId = scanner.nextInt();
        
        if (studentMap.containsKey(searchId)) {
            System.out.println("Student found: " + studentMap.get(searchId));
        } else {
            System.out.println("Student ID not found.");
        }
        scanner.close();
    }
}
