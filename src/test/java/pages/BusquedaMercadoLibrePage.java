package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static utils.WaitUtils.fixedWait;

public class BusquedaMercadoLibrePage extends BasePage {
    public BusquedaMercadoLibrePage() {
        super();
    }

    private By searchBoxBy = By.xpath("//input[@class='nav-search-input']");
    private By categoriaZapatillasBy = By.xpath("//h1[text()='Zapatillas']");

    public void abrirPagina() {
        navigateTo("https://www.mercadolibre.com.ar");
    }

    public void buscar(String termino) {
        sendKeys(searchBoxBy, termino + Keys.ENTER);
    }

    public void validaCategoriaDeLaBusqueda() {
        boolean categoria = isDisplayed(categoriaZapatillasBy);
        Assert.assertTrue(categoria);
        fixedWait(2);
    }
}