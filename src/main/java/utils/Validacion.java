package utils;

import org.junit.jupiter.api.Assertions;

public class Validacion {

    public static void validarTexto(String textoActual, String textoEsperado) {
        try {
            Assertions.assertEquals(textoEsperado, textoActual,
                    () -> "El texto actual '" + textoActual + "' no coincide con el esperado '" + textoEsperado + "'");
        } catch (AssertionError e) {
            throw e;
        }
    }
}
