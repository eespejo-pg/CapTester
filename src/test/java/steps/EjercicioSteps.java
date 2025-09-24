package steps;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import pages.EjercicioPage;

public class EjercicioSteps {
    EjercicioPage ejercicioPage = new EjercicioPage();

    @Dado("que abro la página de login del ejercicio")
    public void abrirPaginaLogin() {
        ejercicioPage.abrirPagina();
    }

    @Cuando("ingreso con las credenciales válidas")
    public void ingresarCredenciales() {
        String usuario = "practice";
        String password = "SuperSecretPassword!";
        ejercicioPage.ingresarCredenciales(usuario, password);
        ejercicioPage.hacerLogin();
    }

    @Entonces("valido que el login es exitoso con el mensaje de bienvenida")
    public void validarLoginExitoso() {
        ejercicioPage.validarLoginExitoso();
    }
}
