import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.List;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool of 3
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            Callable<Integer> task = () -> {
                System.out.println("Executing Task " + taskId + " on " + Thread.currentThread().getName());
                Thread.sleep(1000);
                return taskId * 10;
            };
            futures.add(executor.submit(task));
        }

        for (Future<Integer> f : futures) {
            try {
                System.out.println("Task Result Returned: " + f.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }
}
