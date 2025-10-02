package pages;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

import driver.DriverManager;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Attachment(value = "{action}", type = "image/png")
    protected byte[] takeScreenshotAllure(String action) {
        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            return new byte[0];
        }
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    WebElement findElement(By locator) {
        try {
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            throw e;
        }
    }

    List<WebElement> findElements(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    boolean isDisplayed(By locator) {
        WebElement element = findElement(locator);
        takeScreenshotAllure("Verificando visibilidad del elemento: " + locator.toString());
        return element.isDisplayed();
    }

    boolean areDisplayed(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    void waitAndClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    void click(By locator) {
        WebElement element = findElement(locator);
        element.click();
    }

    void sendKeys(By locator, String text) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    String getText(By locator) {
        WebElement element = findElement(locator);
        return element.getText();
    }

    void selectByValue(By locator, String value) {
        WebElement dropdown = findElement(locator);
        scrollToElement(locator); // Asegura que el elemento esté visible
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    void clearInput(By locator) {
        WebElement element = findElement(locator);
        element.clear();
    }

    void isEnabled(By locator) {
        WebElement element = findElement(locator);
        if (!element.isEnabled()) {
            throw new RuntimeException("Elemento está habilitado: " + locator);
        }
    }

    void isSelected(By locator) {
        WebElement element = findElement(locator);
        if (!element.isSelected()) {
            throw new RuntimeException("Elemento no está seleccionado: " + locator);
        }
    }

    void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    void dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }

    String getAlertText() {
        return wait.until(ExpectedConditions.alertIsPresent()).getText();
    }

    void switchToFrame(By locator) {
        WebElement frame = findElement(locator);
        driver.switchTo().frame(frame);
    }

    void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    void scrollToElement(By locator) {
        WebElement element = findElement(locator);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    void waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }
}