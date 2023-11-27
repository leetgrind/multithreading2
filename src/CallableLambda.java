import java.util.concurrent.*;

public class CallableLambda {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Callable<String> callable1 = () ->  {
            Thread.sleep(2000);
            return "Callable finished";
        };

        Future<String> future = executorService.submit(callable1);

        while (!future.isDone()) {
            // do something else while the callable is finished
            System.out.println("Fetching data from database");
            Thread.sleep(500);
            System.out.println("Data fetched");
        }

        System.out.println("Future completed");

        System.out.println(future.get());

        executorService.shutdown();

    }
}
