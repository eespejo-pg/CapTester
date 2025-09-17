package driver;

import org.openqa.selenium.WebDriver;
import ChromeConfigs.ChromeConfigs;

public class DriverManager {
    private static WebDriver driver;

    public DriverManager() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            // Usa la configuración de Chrome desde `ChromeConfigs`
            driver = ChromeConfigs.getChromeDriver();
        }
        return driver;
    }

    public static void quitWebDriver() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                driver = null;
            }
        }
    }
}