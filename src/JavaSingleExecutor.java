import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaSingleExecutor {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Runnable runnable = () -> System.out.println("Inside thread " + Thread.currentThread().getName());

        executorService.submit(runnable);

        executorService.shutdown();
    }

}
