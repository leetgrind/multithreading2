import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RaceCondition {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        Counter counter = new Counter();

        int numberOfTasks = 100;

        for(int i=0; i<numberOfTasks; i++) {
            executorService.submit(counter::increase);
        }

        executorService.shutdown();

        System.out.println("Counter: " + counter.getCount());

    }
}

class Counter {

    private int count = 0;

    public void increase() {

        synchronized (this) {
            count++;
        }

    }
    public int getCount() {
        return count;
    }
}
