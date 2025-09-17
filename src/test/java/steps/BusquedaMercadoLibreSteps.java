package steps;

import io.cucumber.java.es.*;
import io.qameta.allure.Step;
import pages.BusquedaMercadoLibrePage;

public class BusquedaMercadoLibreSteps {
    private BusquedaMercadoLibrePage busquedaMercadoLibrePage = new BusquedaMercadoLibrePage();

    @Dado("que abro Mercado Libre")
    @Step("Dado que abro la página de Mercado Libre")
    public void abrePaginaMercadoLibre() {
        busquedaMercadoLibrePage.abrirPagina();
    }

    @Cuando("busco {string} en Mercado Libre")
    @Step("Cuando busco {termino} en Mercado Libre")
    public void busquedaEnMercadoLibre(String termino) {
        busquedaMercadoLibrePage.buscar(termino);
    }

    @Entonces("valido que entro en la categoría correspondiente")
    @Step("Entonces valido que entro en la categoría correspondiente")
    public void validoCategoriaDeBusqueda() {
        busquedaMercadoLibrePage.validaCategoriaDeLaBusqueda();
    }
}