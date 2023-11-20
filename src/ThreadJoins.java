public class ThreadJoins {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            System.out.println("Inside thread 1");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Thread one complete");
        };

        Thread thread1 = new Thread(runnable);

        Runnable runnable2 = () -> {
            System.out.println("inside thread 2");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Thread two complete");
        };

        Thread thread2 = new Thread(runnable2);

        Thread threadExample = new ThreadExample();

        thread1.start();

        thread1.join(500);

        threadExample.start();

        thread2.start();


    }




}
