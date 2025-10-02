package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.Validacion;

public class RegistroLoginPage extends BasePage{
    private By botonMenuLogin = By.xpath("//a[@href='/login']");
    private By inputName = By.xpath("//input[@data-qa='signup-name']");
    private By inputEmail = By.xpath("//input[@data-qa='signup-email']");
    private By botonSignup = By.xpath("//button[@data-qa='signup-button']");
    private By inputGender = By.xpath("//input[@id='id_gender1']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By selectPais = By.xpath("//select[@data-qa='country']");
    private By selectDay = By.xpath("//select[@id='days']");
    private By selectMonth = By.xpath("//select[@id='months']");
    private By selectYears = By.xpath("//select[@id='years']");
    private By inputAddress = By.xpath("//input[@data-qa='address']");
    private By inputState = By.xpath("//input[@data-qa='state']");
    private By inputCity = By.xpath("//input[@data-qa='city']");
    private By inputCodePostal = By.xpath("//input[@data-qa='zipcode']");
    private By inputMobileNumber = By.xpath("//input[@data-qa='mobile_number']");
    private By botonCrearCuenta = By.xpath("//button[@data-qa='create-account']");
    private By textoCreacionExitosa = By.xpath("//b[contains(text(), 'Account Created!')]");
    private By botonContinuar = By.xpath("//a[contains(text(),'Continue')]");
    private By botonEliminarCuenta = By.xpath("//a[@href='/delete_account']");
    private By textoCuentaEliminada = By.xpath("//b[contains(text(), 'Account Deleted!')]");
    private By inputNombreRegistro = By.xpath("//input[@data-qa='first_name']");
    private By inputApellido = By.xpath("//input[@data-qa='last_name']");

    @Step("Se inicia el navegador con la página web de Práctica")
    public void abrirPagina(String url) {
        navigateTo(url);
    }

    @Step("Hace click en menu Login/Signup")
    public void clickMenuLogin(){
        isDisplayed(botonMenuLogin);
        waitAndClick(botonMenuLogin);
    }

    @Step("Ingresa nombre en input")
    public void ingresaNombre(String nombre) {
        isDisplayed(inputName);
        sendKeys(inputName, nombre);
    }

    @Step("Ingresa email en input")
    public void ingresaEmail(String mail) {
        isDisplayed(inputEmail);
        sendKeys(inputEmail, mail);
    }

    @Step("Hace click en botón Signup")
    public void clickBotonSignup(){
        isDisplayed(botonSignup);
        waitAndClick(botonSignup);
    }

    @Step("Ingresa genero en input")
    public void ingresaGenero() {
        isDisplayed(inputGender);
        waitAndClick(inputGender);
    }

    @Step("Ingresa password")
    public void ingresaInputPassword(String password) {
        isDisplayed(inputPassword);
        sendKeys(inputPassword, password);
    }

    @Step("Ingresa Nombre registro")
    public void ingresaInputNombrRegistro(String nombre) {
        isDisplayed(inputNombreRegistro);
        sendKeys(inputNombreRegistro, nombre);
    }

    @Step("Ingresa Apellido registro")
    public void ingresaInputApellido(String apellido) {
        isDisplayed(inputApellido);
        sendKeys(inputApellido, apellido);
    }

    @Step("Selecciona País")
    public void selectPais(String pais){
        isDisplayed(selectPais);
        selectByValue(selectPais, pais);
    }

    @Step("Selecciona día nacimiento")
    public void selectDia(String dia) {
        isDisplayed(selectDay);
        selectByValue(selectDay, dia);
    }

    @Step("Selecciona mes nacimiento")
    public void selectMes(String mes) {
        isDisplayed(selectMonth);
        selectByValue(selectMonth, mes);
    }

    @Step("Selecciona año nacimiento")
    public void selectAnio(String anio) {
        isDisplayed(selectYears);
        selectByValue(selectYears, anio);
    }

    @Step("Ingresa address en input")
    public void ingresaDireccion(String direccion) {
        isDisplayed(inputAddress);
        sendKeys(inputAddress, direccion);
    }

    @Step("Ingresa estado en input")
    public void ingresaEstado(String estado) {
        isDisplayed(inputState);
        sendKeys(inputState, estado);
    }

    @Step("Ingresa ciudad en input")
    public void ingresaCiudad(String ciudad) {
        isDisplayed(inputCity);
        sendKeys(inputCity, ciudad);
    }

    @Step("Ingresa Cod Postal en input")
    public void ingresaCodPostal(String cpostal) {
        isDisplayed(inputCodePostal);
        sendKeys(inputCodePostal, cpostal);
    }

    @Step("Ingresa Mobile Number en input")
    public void ingresaMobileNumber(String number) {
        isDisplayed(inputMobileNumber);
        sendKeys(inputMobileNumber, number);
    }

    @Step("Hace click en botón Crear cuenta")
    public void clickBotonCrearCuenta(){
        isDisplayed(botonCrearCuenta);
        waitAndClick(botonCrearCuenta);
    }

    @Step("Hace click en botón Continuar")
    public void clickBotonContinuar(){
        isDisplayed(botonContinuar);
        waitAndClick(botonContinuar);
    }

    @Step("Validar Creación de cuenta")
    public void validarCreacionCuenta(String textoEsperado){
        isDisplayed(textoCreacionExitosa);
        String mensajeCreacionActual = getText(textoCreacionExitosa);
        Validacion.validarTexto(mensajeCreacionActual, textoEsperado);
    }

    @Step("Hace click en botón Signup")
    public void clickBotonEliminarCuenta(){
        isDisplayed(botonEliminarCuenta);
        waitAndClick(botonEliminarCuenta);
    }

    @Step("Validar Eliminar cuenta")
    public void validarEliminarCuenta(String textoEsperado){
        isDisplayed(textoCuentaEliminada);
        String mensajeEliminacionActual = getText(textoCuentaEliminada);
        Validacion.validarTexto(mensajeEliminacionActual, textoEsperado);
    }
}