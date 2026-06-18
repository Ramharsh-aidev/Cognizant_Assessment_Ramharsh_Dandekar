import java.util.Arrays;

public class LibraryManagementSystem {

    public static Book linearSearchByTitle(Book[] books, String targetTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearchByTitle(Book[] sortedBooks, String targetTitle) {
        int left = 0;
        int right = sortedBooks.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = sortedBooks[mid].getTitle().compareToIgnoreCase(targetTitle);

            if (comparison == 0) {
                return sortedBooks[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book("B1", "The Great Gatsby", "F. Scott Fitzgerald"),
                new Book("B2", "1984", "George Orwell"),
                new Book("B3", "To Kill a Mockingbird", "Harper Lee"),
                new Book("B4", "Pride and Prejudice", "Jane Austen")
        };

        System.out.println("--- Linear Search ---");
        System.out.println("Result for '1984': " + linearSearchByTitle(books, "1984"));

        Arrays.sort(books);

        System.out.println("\n--- Binary Search (Sorted Array) ---");
        System.out
                .println("Result for 'To Kill a Mockingbird': " + binarySearchByTitle(books, "To Kill a Mockingbird"));
    }
}
