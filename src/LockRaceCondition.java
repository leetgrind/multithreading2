import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class LockRaceCondition {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        Counter counter = new Counter();

        int numberOfTasks = 20;

        for(int i=0; i<numberOfTasks; i++) {
            executorService.submit(counter::increase);
        }

        executorService.shutdown();

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
