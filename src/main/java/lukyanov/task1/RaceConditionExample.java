package lukyanov.task1;

import lombok.extern.slf4j.Slf4j;

/**
 * The class presents the Race Condition example using only Thread API.
 *
 * @author Lukyanov Aleksey
 */
@Slf4j
public class RaceConditionExample {
    private static int value = 0;

    public static void main(String[] args) {
        Runnable count = () -> {
            for (int i = 0; i < 100000; i++) {
                int oldValue = value;
                int newValue = ++value;
                if (oldValue + 1 != newValue) {
                    log.error(oldValue + " + 1 not equal " + newValue);
                }
            }
        };
        new Thread(count, "Thread-1").start();
        new Thread(count, "Thread-2").start();
        new Thread(count, "Thread-3").start();
        new Thread(count, "Thread-4").start();
        new Thread(count, "Thread-5").start();
    }
}
