public class DecoratorTest {
    public static void main(String[] args) {
        System.out.println("Testing Decorator Pattern");

        // Base notifier
        Notifier emailNotifier = new EmailNotifier();

        System.out.println("Sending standard notification:");
        emailNotifier.send("System update complete.");

        Notifier multiChannelNotifier = new SlackNotifierDecorator(
                new SMSNotifierDecorator(emailNotifier));

        System.out.println("\nSending multi-channel notification:");
        multiChannelNotifier.send("CRITICAL: Server is down!");
    }
}
