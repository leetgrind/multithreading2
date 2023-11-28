import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class LockAtomicVariables {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        AtomicCounter atomicCounter = new AtomicCounter();

        Runnable runnable = () -> atomicCounter.increment();

        for (int i=0; i<100; i++) {
            executorService.submit(runnable);
        }

        executorService.shutdown();

        executorService.awaitTermination(20, TimeUnit.SECONDS);

        System.out.println("Counter is " + atomicCounter.getCount());
    }
}

class AtomicCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public int increment() {
        return count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
