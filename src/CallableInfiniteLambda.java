import java.util.concurrent.*;

public class CallableInfiniteLambda {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Callable<String> callable1 = () ->  {
            Thread.sleep(100000);
            return "Callable finished";
        };

        Future<String> future = executorService.submit(callable1);

        int i = 0;

        while (!future.isDone()) {
            // do something else while the callable is finished
            System.out.println("Waiting for task to finish");
            Thread.sleep(1000);

            if(i==4) {
                future.cancel(true);
                System.out.println("Cancelling the future. Waited long enough");
            }
            i++;
        }

        if(!future.isCancelled()) {
            System.out.println("Future completed");
            System.out.println(future.get());
        }
        else {
            System.out.println("Future cancelled exiting the program");
        }


        executorService.shutdown();

    }
}
