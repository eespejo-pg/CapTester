package utils;

import org.junit.Assert;

public class Validacion {

    public static void validarTexto(String textoActual, String textoEsperado) {
        try {
            Assert.assertEquals(textoEsperado, textoActual);
        } catch (AssertionError e) {
            throw e;
        }
    }
}
