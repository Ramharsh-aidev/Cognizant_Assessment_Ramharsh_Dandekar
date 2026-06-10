import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadingExample {
    public static void main(String[] args) {
        File file = new File("output.txt");
        
        try (Scanner fileScanner = new Scanner(file)) {
            System.out.println("Contents of output.txt:");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file output.txt was not found. Please run FileWritingExample first.");
        }
    }
}
