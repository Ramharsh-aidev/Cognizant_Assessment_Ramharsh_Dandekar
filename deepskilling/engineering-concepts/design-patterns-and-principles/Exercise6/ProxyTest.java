public class ProxyTest {
    public static void main(String[] args) {
        System.out.println("Testing Proxy Pattern");

        // The image object is created, but the actual file is NOT loaded yet.
        Image image1 = new ProxyImage("high_res_photo_1.jpg");
        Image image2 = new ProxyImage("high_res_photo_2.jpg");

        System.out.println("Calling display on image1 for the first time:");
        image1.display(); // Will load from server and display

        System.out.println("\nCalling display on image1 for the second time:");
        image1.display(); // Will use cached RealImage instance, no server load

        System.out.println("\nCalling display on image2:");
        image2.display();
    }
}
