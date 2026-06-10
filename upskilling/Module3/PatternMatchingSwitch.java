public class PatternMatchingSwitch {
    public static void determineType(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println("It's an Integer with value: " + i);
            case String s -> System.out.println("It's a String of length: " + s.length());
            case Double d -> System.out.println("It's a Double with value: " + d);
            case null -> System.out.println("It's null!");
            default -> System.out.println("Unknown type.");
        }
    }

    public static void main(String[] args) {
        determineType(42);
        determineType("Hello Java 21");
        determineType(3.14);
        determineType(null);
    }
}
