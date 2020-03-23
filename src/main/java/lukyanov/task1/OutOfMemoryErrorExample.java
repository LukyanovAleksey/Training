package lukyanov.task1;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * Task 1
 * Написать код, который будет выбрасывать java.lang.OutOfMemoryError, при ограничении heap 20мб (-Xmx20m)
 */
@Slf4j
public class OutOfMemoryErrorExample {

    public static void main(String[] args) {
        try {
            List<Object[]> list = new LinkedList<>();
            for (; ; ) {
                list.add(new Object[1000]);
            }
        } catch (OutOfMemoryError e) {
            log.error("Reproduced error: " + e.toString());
            e.printStackTrace();
        }
    }

}

