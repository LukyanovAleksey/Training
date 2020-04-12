package lukyanov.task2;

import lombok.extern.slf4j.Slf4j;

/**
 * The class presents the resolution of the RaceConditionExample
 *
 * @author Lukyanov Aleksey
 */
@Slf4j
public class RaceConditionResolution {
    private static class Counter {
        private int value = 0;

        private int getValue() {
            return value;
        }

        private void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Runnable count = () -> {
            int oldValue;
            int newValue;
            for (int i = 0; i < 1000000; i++) {
                synchronized (counter) {
                    oldValue = counter.getValue();
                    newValue = counter.getValue() + 1;
                    counter.setValue(newValue);
                    if (oldValue + 1 != counter.getValue()) {
                        log.error(oldValue + " + 1 not equal " + newValue);
                    }
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
