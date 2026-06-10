public class MethodOverloading {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        MethodOverloading mo = new MethodOverloading();
        System.out.println("Sum of two ints (5, 10): " + mo.add(5, 10));
        System.out.println("Sum of two doubles (5.5, 10.5): " + mo.add(5.5, 10.5));
        System.out.println("Sum of three ints (5, 10, 15): " + mo.add(5, 10, 15));
    }
}
