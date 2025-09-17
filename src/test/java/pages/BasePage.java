package pages;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
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
        takeScreenshotAllure("Navegar a: " + url);
    }

    protected WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected List<WebElement> findElements(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    protected boolean isDisplayed(By locator) {
        WebElement element = findElement(locator);
        takeScreenshotAllure("Verificar visibilidad de: " + locator.toString());
        return element.isDisplayed();
    }

    protected boolean areDisplayed(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            takeScreenshotAllure("Verificar visibilidad de todos los elementos: " + locator.toString());
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected void waitAndClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        takeScreenshotAllure("Click esperado en: " + locator.toString());
    }

    protected void click(By locator) {
        WebElement element = findElement(locator);
        element.click();
        takeScreenshotAllure("Click en: " + locator.toString());
    }

    protected void sendKeys(By locator, String text) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
        takeScreenshotAllure("SendKeys en: " + locator.toString());
    }

    protected String getText(By locator) {
        WebElement element = findElement(locator);
        takeScreenshotAllure("Obtener texto de: " + locator.toString());
        return element.getText();
    }

    protected void selectByValue(By locator, String value) {
        WebElement dropdown = findElement(locator);
        dropdown.click();
        By optionLocator = By.xpath(".//option[@value='" + value + "']");
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        option.click();
        takeScreenshotAllure("Seleccionar valor: " + value + " en: " + locator.toString());
    }

    protected void clearInput(By locator) {
        WebElement element = findElement(locator);
        element.clear();
        takeScreenshotAllure("Limpiar input: " + locator.toString());
    }

    protected void isEnabled(By locator) {
        WebElement element = findElement(locator);
        takeScreenshotAllure("Verificar si está habilitado: " + locator.toString());
        if (!element.isEnabled()) {
            throw new RuntimeException("Element is not enabled: " + locator);
        }
    }

    protected void isSelected(By locator) {
        WebElement element = findElement(locator);
        takeScreenshotAllure("Verificar si está seleccionado: " + locator.toString());
        if (!element.isSelected()) {
            throw new RuntimeException("Element is not selected: " + locator);
        }
    }

    protected void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    protected void dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }

    protected String getAlertText() {
        return wait.until(ExpectedConditions.alertIsPresent()).getText();
    }

    protected void switchToFrame(By locator) {
        WebElement frame = findElement(locator);
        driver.switchTo().frame(frame);
    }

    protected void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    protected void scrollToElement(By locator) {
        WebElement element = findElement(locator);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        takeScreenshotAllure("Desplazar a elemento: " + locator.toString());
    }

    protected void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }
}