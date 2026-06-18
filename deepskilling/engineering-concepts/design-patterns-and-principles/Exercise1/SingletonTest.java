public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("Testing Singleton Pattern");

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is a message from logger1.");
        logger2.log("This is a message from logger2.");

        System.out.println("\nVerification");
        if (logger1 == logger2) {
            System.out.println(
                    "Success! The Singleton pattern works. Both variables point to the exact same memory instance.");
        } else {
            System.out.println("Failure! The loggers are different instances.");
        }
    }
}
