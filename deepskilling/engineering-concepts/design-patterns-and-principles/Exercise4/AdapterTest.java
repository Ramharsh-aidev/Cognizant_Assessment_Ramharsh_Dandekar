public class AdapterTest {
    public static void main(String[] args) {
        System.out.println("Testing Adapter Pattern");

        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(150.00);

        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        paypalProcessor.processPayment(200.50);
    }
}
