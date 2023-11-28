public class MemoryError {

    private static volatile boolean condition = false;
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {

            while (!condition) {

            }

            System.out.println("Value of condition changed to "  + condition);
            System.out.println("Out of while loop #1");

            while(condition) {

            }
            System.out.println("Value of condition changed to "  + condition);
            System.out.println("Out of while loop #2");
        });

        thread.start();

        //artificial delay
        Thread.sleep(1000);
        System.out.println("Changing the value of condition to true");
        condition = true;

        Thread.sleep(1000);

        System.out.println("Changing the value of condition to false");
        condition = false;
    }


}
