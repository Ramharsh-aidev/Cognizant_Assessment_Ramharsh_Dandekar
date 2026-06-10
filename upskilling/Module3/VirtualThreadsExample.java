public class VirtualThreadsExample {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        
        for (int i = 0; i < 100_000; i++) {
            Thread.startVirtualThread(() -> {
                // Task representing minimal work
                Math.hypot(10, 10);
            });
        }
        
        long end = System.currentTimeMillis();
        System.out.println("Launched 100,000 virtual threads seamlessly in " + (end - start) + " ms.");
    }
}
