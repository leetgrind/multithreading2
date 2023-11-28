import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        Counter counter = new Counter();

        int numberOfTasks = 100;

        for(int i=0; i<numberOfTasks; i++) {
            executorService.submit(counter::increase);
        }

        executorService.shutdown();

        executorService.awaitTermination(20, TimeUnit.SECONDS);

        System.out.println("Counter: " + counter.getCount());

    }
}

class Counter {

    private int count = 0;

    public synchronized void increase() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
