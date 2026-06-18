import java.util.Arrays;

public class SearchFunction {

    public static ECommerceProduct linearSearch(ECommerceProduct[] products, String targetId) {
        for (ECommerceProduct product : products) {
            if (product.getProductId().equals(targetId)) {
                return product;
            }
        }
        return null;
    }

    public static ECommerceProduct binarySearch(ECommerceProduct[] sortedProducts, String targetId) {
        int left = 0;
        int right = sortedProducts.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = sortedProducts[mid].getProductId().compareTo(targetId);

            if (comparison == 0) {
                return sortedProducts[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ECommerceProduct[] products = {
                new ECommerceProduct("P050", "Gaming Headphones", "Audio"),
                new ECommerceProduct("P010", "Business Laptop", "Electronics"),
                new ECommerceProduct("P099", "Wireless Mouse", "Accessories"),
                new ECommerceProduct("P025", "4K Monitor", "Electronics"),
                new ECommerceProduct("P005", "Mechanical Keyboard", "Accessories")
        };

        System.out.println("--- Linear Search (Unsorted Array) ---");
        ECommerceProduct resultLinear = linearSearch(products, "P099");
        System.out.println("Search for P099: " + (resultLinear != null ? resultLinear : "Not Found"));

        Arrays.sort(products);

        System.out.println("\n--- Binary Search (Sorted Array) ---");
        ECommerceProduct resultBinary = binarySearch(products, "P025");
        System.out.println("Search for P025: " + (resultBinary != null ? resultBinary : "Not Found"));

        System.out.println("\n--- Searching for non-existent item ---");
        ECommerceProduct missingItem = binarySearch(products, "P999");
        System.out.println("Search for P999: " + (missingItem != null ? missingItem : "Not Found"));
    }
}
