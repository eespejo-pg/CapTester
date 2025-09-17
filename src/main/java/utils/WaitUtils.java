package utils;

public class WaitUtils {
    public static void fixedWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Error: ", e.getCause());
        }
    }
}
