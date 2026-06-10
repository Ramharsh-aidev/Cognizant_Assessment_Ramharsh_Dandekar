import java.util.Scanner;

public class ArraySumAndAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        if(n <= 0) {
            System.out.println("Invalid number of elements.");
            scanner.close();
            return;
        }

        int[] arr = new int[n];
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        
        double average = (double) sum / n;
        
        System.out.println("Sum of the elements: " + sum);
        System.out.println("Average of the elements: " + average);
        
        scanner.close();
    }
}
