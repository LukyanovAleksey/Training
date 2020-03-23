package lukyanov.task2;

import lombok.extern.slf4j.Slf4j;

/**
 * Task 2
 * Написать код, который будет выбрасывать java.lang.StackOverflowError
 */
@Slf4j
public class StackOverflowErrorExample {
    public static void main(String[] args) {
        try {
            recursion();
        } catch (StackOverflowError e) {
            log.error("Reproduced error: " + e.toString());
            e.printStackTrace();
        }
    }

    private static void recursion() throws StackOverflowError {
        recursion();
    }
}