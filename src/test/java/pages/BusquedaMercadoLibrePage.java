package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static utils.WaitUtils.fixedWait;

public class BusquedaMercadoLibrePage extends BasePage {
    private By searchBoxBy = By.xpath("//input[@class='nav-search-input']");
    private By categoriaZapatillasBy = By.xpath("//h1[text()='Zapatillas']");

    @Step("Se inicia el navegador con la pagina Web de MercadoLibre")
    public void abrirPagina() {
        navigateTo("https://www.mercadolibre.com.ar");
    }

    @Step("Se ingresa en el buscador el siguiente articulo: {termino}")
    public void buscar(String termino) {
        sendKeys(searchBoxBy, termino + Keys.ENTER);
    }

    @Step("Validamos la búsqueda del articulo")
    public void validaCategoriaDeLaBusqueda() {
        boolean categoria = isDisplayed(categoriaZapatillasBy);
        Assert.assertTrue(categoria);
        fixedWait(2);
    }
}