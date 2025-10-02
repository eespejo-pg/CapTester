package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.Validacion;

public class EjercicioPage extends BasePage{
    private By loginInput = By.xpath("//input[@id='username']");
    private By passwordInput = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//button[text()='Login']");
    private By welcomeMessage = By.xpath("//b[text()='You logged into a secure area!']");

    @Step("Se inicia el navegador con la pagina Web del Ejercicio")
    public void abrirPagina() {
        navigateTo("https://practice.expandtesting.com/login");
    }

    @Step("Se ingresa los datos de inicio de sesión")
    public void ingresarCredenciales(String usuario, String password) {
        sendKeys(loginInput, usuario);
        sendKeys(passwordInput, password);
    }

    @Step("Se hace clic en el botón Login")
    public void hacerLogin() {
        scrollToElement(loginButton);
        click(loginButton);
    }

    @Step("Valida el inicio de sesión")
    public void validarLoginExitoso() {
        Assert.assertTrue(isDisplayed(welcomeMessage));
    }

    @Step("Validar login realizado con éxito")
    public void validarLoginExitoso(String mensajeEsperado) {
        String mensajeActual = getText(welcomeMessage);
        Validacion.validarTexto(mensajeActual, mensajeEsperado);
    }
}