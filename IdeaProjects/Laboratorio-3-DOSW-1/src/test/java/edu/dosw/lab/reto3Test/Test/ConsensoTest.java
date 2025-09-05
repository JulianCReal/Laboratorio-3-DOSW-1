package reto3Test.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reto3.Consenso;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias básicas para la clase Consenso.
 *
 * @author Bankify Team
 * @version 1.0
 */

class ConsensoTest {

    @Test
    void testConsensoDirectoConDosIntegrantes() {
        // 2 integrantes, 1 historia, ambos votan 3
        String input = "2\n1\nHistoria A\n3\n3\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        Assertions.assertDoesNotThrow(Consenso::ejecutar);
        String salida = out.toString();

        assertTrue(salida.contains("Historia A"));
        assertTrue(salida.contains("3 puntos"));
    }

    @Test
    void testConVotosDiferentesYLuegoConsenso() {
        // 2 integrantes, 1 historia, primero votan diferente (2 y 3),
        // luego ambos votan 5
        String input = "2\n1\nHistoria B\n2\n3\n5\n5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        assertDoesNotThrow(Consenso::ejecutar);
        String salida = out.toString();

        assertTrue(salida.contains("Votos diferentes"));
        assertTrue(salida.contains("5 puntos"));
    }

    @Test
    void testConValorInvalidoYLuegoValido() {
        // 1 integrante, 1 historia, mete 7 (inválido) y luego 8 (válido)
        String input = "1\n1\nHistoria C\n7\n8\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        assertDoesNotThrow(Consenso::ejecutar);
        String salida = out.toString();

        assertTrue(salida.contains("no hace parte de la secuencia Fibonnaci"));
        assertTrue(salida.contains("8 puntos"));
    }

    @Test
    void testMultiplesHistorias() {
        // 1 integrante, 2 historias, siempre vota 1
        String input = "1\n2\nHistoria D\nHistoria E\n1\n1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        assertDoesNotThrow(Consenso::ejecutar);
        String salida = out.toString();

        assertTrue(salida.contains("Historia D"));
        assertTrue(salida.contains("Historia E"));
    }

    @Test
    void testMinimoIntegrantesUnicoVoto() {
        // 1 integrante, 1 historia, vota 13
        String input = "1\n1\nHistoria F\n13\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        assertDoesNotThrow(Consenso::ejecutar);
        String salida = out.toString();

        assertTrue(salida.contains("Historia F"));
        assertTrue(salida.contains("13 puntos"));
    }
}
