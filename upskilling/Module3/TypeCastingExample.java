public class TypeCastingExample {
    public static void main(String[] args) {
        // Double to int (Explicit casting)
        double myDouble = 9.78;
        int myInt = (int) myDouble;
        System.out.println("Original double value: " + myDouble);
        System.out.println("After explicit casting to int: " + myInt);
        
        // Int to double (Implicit casting)
        int anotherInt = 100;
        double anotherDouble = anotherInt;
        System.out.println("\nOriginal int value: " + anotherInt);
        System.out.println("After implicit casting to double: " + anotherDouble);
    }
}
