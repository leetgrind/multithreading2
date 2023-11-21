public class RunnableExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Inside Runnable thread: " + Thread.currentThread().getName());
    }
}
