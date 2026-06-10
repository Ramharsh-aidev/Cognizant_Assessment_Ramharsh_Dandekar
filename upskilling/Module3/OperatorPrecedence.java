public class OperatorPrecedence {
    public static void main(String[] args) {
        int result = 10 + 5 * 2;
        System.out.println("The result of the expression '10 + 5 * 2' is: " + result);
        System.out.println("\nExplanation:");
        System.out.println("Java evaluates expressions based on operator precedence rules.");
        System.out.println("The multiplication operator (*) has higher precedence than the addition operator (+).");
        System.out.println("Therefore, '5 * 2' is evaluated first (which equals 10), and then added to 10.");
    }
}
