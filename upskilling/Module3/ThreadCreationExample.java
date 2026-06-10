class MessageThread extends Thread {
    private String message;
    
    public MessageThread(String message) {
        this.message = message;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " says: " + message + " (" + i + ")");
            try {
                Thread.sleep(500); // Wait 500ms
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }
}

public class ThreadCreationExample {
    public static void main(String[] args) {
        MessageThread thread1 = new MessageThread("Hello");
        MessageThread thread2 = new MessageThread("World");
        
        thread1.setName("Thread-1");
        thread2.setName("Thread-2");
        
        thread1.start();
        thread2.start();
    }
}
