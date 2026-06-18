public class StrategyTest {
    public static void main(String[] args) {
        System.out.println("Testing Strategy Pattern");

        PaymentContext context = new PaymentContext();

        // Select Credit Card Strategy
        context.setPaymentStrategy(new CreditCardPayment("1234567890123456"));
        context.executePayment(250.00);

        // Switch to PayPal Strategy dynamically at runtime
        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.executePayment(99.99);
    }
}
