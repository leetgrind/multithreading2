public class Main {
    public static void main(String[] args) {

        System.out.println("Entering thread " + Thread.currentThread().getName());

        Thread threadExample = new ThreadExample();
        threadExample.start();

        Runnable runnable = new RunnableExample();

        Thread thread = new Thread(runnable);

        thread.start();

    }
}