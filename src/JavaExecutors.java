import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaExecutors {

    public static void main(String[] args) {

        threadPool();

    }

    static void threadPool() {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable runnable1 = getRunnable(1, 3000);
        Runnable runnable2 = getRunnable(2, 5000);
        Runnable runnable3 = getRunnable(3, 4000);
        Runnable runnable4 = getRunnable(4, 1000);

        executorService.submit(runnable1);
        executorService.submit(runnable2);
        executorService.submit(runnable3);
        executorService.submit(runnable4);

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
