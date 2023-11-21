import java.util.concurrent.*;

public class CallableLambda {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Callable<String> callable1 = () -> "Callable finished";

        Future<String> future = executorService.submit(callable1);

        System.out.println(future.get());

        executorService.shutdown();

    }
}
