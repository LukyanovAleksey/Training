package lukyanov.task1;

import lombok.extern.slf4j.Slf4j;

/**
 * The class presents the Deadlock example using only Thread API.
 *
 * @author Lukyanov Aleksey
 */
@Slf4j
public class DeadLockExample {
    private static Object object1 = new Object();
    private static Object object2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            Thread.currentThread().setName("Thread-1");
            synchronized (object1) {
                log.info("Holding object1...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("Waiting for object2...");

                synchronized (object2) {
                    log.info("Holding objects 1 & 2...");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            Thread.currentThread().setName("Thread-2");
            synchronized (object2) {
                log.info("Holding object2...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("Waiting for object1...");

                synchronized (object1) {
                    log.info("Holding objects 1 & 2...");
                }
            }
        });

        thread1.start();
        thread2.start();

    }

}