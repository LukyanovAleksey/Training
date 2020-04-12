package lukyanov.task2;

import lombok.extern.slf4j.Slf4j;

/**
 * The class presents the resolution of the DeadlockExample
 *
 * @author Lukyanov Aleksey
 */
@Slf4j
public class DeadLockResolution {
    private static Object object1 = new Object();
    private static Object object2 = new Object();

    public static void main(String[] args) {

        Runnable task = () -> {
            Object firstObj;
            Object secondObj;
            if (object1.hashCode() < object2.hashCode()) {
                firstObj = object1;
                secondObj = object2;
            } else {
                firstObj = object2;
                secondObj = object1;
            }
            synchronized (firstObj) {
                log.info("Holding object " + firstObj);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("Waiting for object " + secondObj);

                synchronized (secondObj) {
                    log.info("Holding object " + firstObj + " and " + secondObj);
                }
            }
        };

        new Thread(task, "Thread-1").start();
        new Thread(task, "Thread-2").start();
    }
}