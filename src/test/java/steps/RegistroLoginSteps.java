package steps;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import pages.RegistroLoginPage;

public class RegistroLoginSteps {
    RegistroLoginPage registroLoginPage = new RegistroLoginPage();
    String url = "https://automationexercise.com/";
    String nombre = "Jose";

    @Dado("que estoy en la página de registro")
    public void abrirPaginaWebPractica() {
        registroLoginPage.abrirPagina(url);
    }

    @Cuando("completo el formulario de registro con datos válidos")
    public void realizaRegistroCompleto() {
        registroLoginPage.clickMenuLogin();
        registroLoginPage.ingresaNombre(nombre);
        registroLoginPage.ingresaEmail("test@test34234324.com");
        registroLoginPage.clickBotonSignup();
        registroLoginPage.ingresaGenero();
        registroLoginPage.ingresaInputPassword("iushdf83");
        registroLoginPage.ingresaInputNombrRegistro(nombre);
        registroLoginPage.ingresaInputApellido("Perez");
        registroLoginPage.selectPais("Canada");
        registroLoginPage.selectDia("2");
        registroLoginPage.selectMes("10");
        registroLoginPage.selectAnio("2000");
        registroLoginPage.ingresaEstado("Ontario");
        registroLoginPage.ingresaCiudad("ASD");
        registroLoginPage.ingresaCodPostal("95348");
        registroLoginPage.ingresaMobileNumber("777342324");
        registroLoginPage.ingresaDireccion("Siempreviva");
        registroLoginPage.clickBotonCrearCuenta();
    }

    @Entonces("debería ver un mensaje de confirmación de registro exitoso")
    public void validarCreacionCuenta() {
        registroLoginPage.validarCreacionCuenta("ACCOUNT CREATED!");
        registroLoginPage.clickBotonContinuar();
        registroLoginPage.clickBotonEliminarCuenta();
        registroLoginPage.validarEliminarCuenta("ACCOUNT DELETED!");
    }
}
