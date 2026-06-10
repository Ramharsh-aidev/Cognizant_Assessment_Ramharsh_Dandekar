import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        StringBuilder sb = new StringBuilder(input);
        String reversed = sb.reverse().toString();
        
        System.out.println("Reversed string: " + reversed);
        scanner.close();
    }
}
