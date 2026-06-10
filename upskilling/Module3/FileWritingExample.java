import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class FileWritingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to write to the file: ");
        String input = scanner.nextLine();
        
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(input);
            System.out.println("Data has been successfully written to output.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
