import java.util.concurrent.locks.ReentrantLock;

public class ThreadDeadlock {

    private ReentrantLock lock1 = new ReentrantLock(true);
    private ReentrantLock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {

        ThreadDeadlock deadlock = new ThreadDeadlock();

        new Thread(deadlock::operation1).start();
        new Thread(deadlock::operation2).start();

    }

    public void operation1() {

        lock1.lock();
        System.out.println(Thread.currentThread().getName()
                + " lock1 acquired");
        try{
            Thread.sleep(100);
        }
        catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(Thread.currentThread().getName()
                + " Trying to acquire lock 2");
        lock2.lock();
        System.out.println(Thread.currentThread().getName()
                + " lock2 acquired");

        lock2.unlock();
        lock1.unlock();

    }

    public void operation2() {
        lock2.lock();
        System.out.println(Thread.currentThread().getName()
                + " lock2 acquired");
        try{
            Thread.sleep(100);
        }
        catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(Thread.currentThread().getName()
                + " Trying to acquire lock 1");
        lock1.lock();
        System.out.println(Thread.currentThread().getName()
                + " lock1 acquired");



        System.out.println(Thread.currentThread().getName()
                + " releasing lock2");
        lock1.unlock();
        lock2.unlock();
    }

}
