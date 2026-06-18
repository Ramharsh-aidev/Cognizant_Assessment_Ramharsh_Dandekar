public class SortingFunction {

    // Bubble Sort: O(n^2) Time Complexity
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                // Sorting in descending order by total price
                if (orders[j].getTotalPrice() < orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Array is sorted early
        }
    }

    // Quick Sort: O(n log n) Time Complexity
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            // Sorting in descending order by total price
            if (orders[j].getTotalPrice() >= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Order[] orders1 = {
            new Order("O1", "Alice", 250.50),
            new Order("O2", "Bob", 150.00),
            new Order("O3", "Charlie", 500.75),
            new Order("O4", "Dave", 50.25)
        };
        
        System.out.println("--- Before Bubble Sort ---");
        printOrders(orders1);
        bubbleSort(orders1);
        System.out.println("--- After Bubble Sort (Highest Value First) ---");
        printOrders(orders1);

        Order[] orders2 = {
            new Order("O5", "Eve", 300.00),
            new Order("O6", "Frank", 120.00),
            new Order("O7", "Grace", 900.50),
            new Order("O8", "Heidi", 10.00)
        };
        
        System.out.println("--- Before Quick Sort ---");
        printOrders(orders2);
        quickSort(orders2, 0, orders2.length - 1);
        System.out.println("--- After Quick Sort (Highest Value First) ---");
        printOrders(orders2);
    }
}
