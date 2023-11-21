import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        CallableString callableString = new CallableString();

        Future<String> result = executorService.submit(callableString);

        System.out.println("Blocking the thread until we process the future");

        String output = result.get();

        System.out.println("Block lifted can process now");

        System.out.println(output);

        executorService.shutdown();

    }
}
