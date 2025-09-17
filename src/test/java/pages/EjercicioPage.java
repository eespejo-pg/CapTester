package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class EjercicioPage extends BasePage{
    public EjercicioPage() {
        super();
    }

    private By loginInput = By.xpath("//input[@id='username']");
    private By passwordInput = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//button[text()='Login']");
    private By welcomeMessage = By.xpath("//b[text()='You logged into a secure area!']");

    public void abrirPagina() {
        navigateTo("https://practice.expandtesting.com/login");
    }

    public void ingresarCredenciales(String usuario, String password) {
        sendKeys(loginInput, usuario);
        sendKeys(passwordInput, password);
    }

    public void hacerLogin() {
        scrollToElement(loginButton);
        click(loginButton);
    }

    public void validarLoginExitoso() {
        Assert.assertTrue(isDisplayed(welcomeMessage));
    }
}