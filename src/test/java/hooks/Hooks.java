package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import driver.DriverManager;
import io.qameta.allure.Step;

public class Hooks {

    @Before
    @Step("Configurar el entorno web antes de los escenarios web")
    public void setUpWeb() {
        DriverManager.getDriver();
    }

    @After
    @Step("Limpiar el entorno web después de los escenarios web")
    public void tearDownWeb() {
        DriverManager.quitWebDriver();
    }
}