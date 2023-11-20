public class Main {
    public static void main(String[] args) {

        System.out.println("Entering thread " + Thread.currentThread().getName());

        //threadAnon();
        //threadLambda();
        threadSleep();
    }

    static void threadAnon() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Starting anonymous thread " + Thread.currentThread().getName());
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    static void threadLambda() {

        Runnable runnable = () -> System.out.println("Starting Lambda Thread " + Thread.currentThread().getName());

        Thread thread = new Thread(runnable);
        thread.start();

    }

    static void threadSleep() {

        Runnable runnable = () -> {
            System.out.println("Inside sleeping thread " + Thread.currentThread().getName());

            try {
                Thread.sleep(500);
                System.out.println("Waking up");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

    }
}