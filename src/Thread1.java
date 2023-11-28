import java.util.concurrent.locks.ReentrantLock;

public class Thread1 extends Thread{

    private ReentrantLock lock1 = new ReentrantLock(true);

    @Override
    public void run() {
        System.out.println("Inside thread example" + Thread.currentThread().getName());
    }
}
