import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableInvoke {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        invokeAny();
    }

    public static void  invokeAll() throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<String> callable1 = () -> {
            Thread.sleep(2000);
            return "callable 1 finished";
        };

        Callable<String> callable2 = () -> {
            Thread.sleep(500);
            return "callable 2 finished";
        };

        Callable<String> callable3 = () -> {
            Thread.sleep(1000);
            return "callable 3 finished";
        };

        List<Callable<String>> taskList = Arrays.asList(callable1,
                callable2, callable3);

        // blocks code here until all futures are completed
       List<Future<String>> futuresList = executorService.invokeAll(taskList);


       for(var future : futuresList) {
           System.out.println(future.get());
       }
       executorService.shutdown();
    }

    public static void  invokeAny() throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<String> callable1 = () -> {
            Thread.sleep(2000);
            return "callable 1 finished";
        };

        Callable<String> callable2 = () -> {
            Thread.sleep(500);
            return "callable 2 finished";
        };

        Callable<String> callable3 = () -> {
            Thread.sleep(1000);
            return "callable 3 finished";
        };

        List<Callable<String>> taskList = Arrays.asList(callable1,
                callable2, callable3);

        // blocks code here until all futures are completed
        String result = executorService.invokeAny(taskList);

        System.out.println("Result from fastest callable " + result);
        executorService.shutdown();
    }


}
