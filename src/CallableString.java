import java.util.concurrent.Callable;

public class CallableString  implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " Inside a callable");
        Thread.sleep(5000);
        return "Returning from a callable";
    }
}
