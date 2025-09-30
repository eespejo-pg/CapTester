package chromeConfigs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeConfigs {
    public static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        // Configuración básica
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--lang=es");

        // Configuración específica para headless
        // options.addArguments("--headless=new"); // Nuevo argumento para Chrome
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Argumentos adicionales para mejorar la estabilidad
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-web-security");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--enable-javascript");

        return new ChromeDriver(options);
    }
}