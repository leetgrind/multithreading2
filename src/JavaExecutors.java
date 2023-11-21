import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JavaExecutors {

    public static void main(String[] args) {

        scheduleAtFixedRate();

    }

    static void scheduledService() {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        Runnable runnable = () -> {
            System.out.println("Starting at " + LocalDateTime.now());
        };

        System.out.println("Submitted thread at " + LocalDateTime.now());
        scheduledExecutorService.schedule(runnable, 5, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }

    static void scheduleAtFixedRate() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        Runnable runnable = () -> {
            System.out.println("Starting at " + LocalDateTime.now());
        };

        System.out.println("Submitted thread at " + LocalDateTime.now());
        scheduledExecutorService.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
    }

    static void threadPool() {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable runnable1 = getRunnable(1, 3000);
        Runnable runnable2 = getRunnable(2, 5000);
        Runnable runnable3 = getRunnable(3, 4000);

        executorService.submit(runnable1);
        executorService.submit(runnable2);
        executorService.submit(runnable3);

        executorService.shutdown();

    }

    static Runnable getRunnable(int i, long sleepTime) {

        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + " Starting Runnable " + i);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + " Runnable "+ i + " finished");
        };

        return runnable;
    }

}
