import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockRaceCondition {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        Counter counter = new Counter();

        int numberOfTasks = 20;

        for(int i=0; i<numberOfTasks; i++) {
            executorService.submit(counter::increase);
        }

        executorService.shutdown();

        executorService.awaitTermination(20, TimeUnit.SECONDS);

        System.out.println("Counter: " + counter.getCount());


    }
}

class LockedCounter {

    ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    public void increase() {

        lock.lock();
        try{
            count++;
        }
        finally {
            lock.unlock();
        }
    }
    public int getCount() {
       return count;
    }
}
