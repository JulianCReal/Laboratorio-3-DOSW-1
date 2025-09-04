package edu.dosw.lab.reto4.Test;

import edu.dosw.lab.reto4.Domain.*;
import edu.dosw.lab.reto4.Util.RegistrarBancos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias básicas para la clase BankifyGestion.
 * Sigue el ciclo TDD (Rojo -> Verde -> Refactor).
 *
 * @author Bankify Team
 * @version 1.0
 */
public class BankifyGestionTest {

    private BankifyGestion bankifyGestion;
    private Cliente cliente;
    private ByteArrayOutputStream outputStream;
    private Cuenta cuenta;
    private HashMap<String, BancoRegistrado> bancos = RegistrarBancos.getBancos();

    @BeforeEach
    void setUp() {
        cuenta = new Cuenta("0212345678", 100000, bancos.get("Bancolombia"));
        cliente = new Cliente("Test Cliente", "12454365465", cuenta);
        bankifyGestion = new BankifyGestion(cliente);

        // Capturar salida del sistema
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testCrearCuentaValida() {
        String nombreCliente = "Juan Pérez";
        String idCuenta = "0234509871";
        String nombreBanco = "Bancolombia";
        int saldo = 50000;

        bankifyGestion.crearCuenta(nombreCliente, idCuenta, nombreBanco, saldo);

        String output = outputStream.toString();
        assertTrue(output.contains("Cuenta creada con éxito"));
    }

    @Test
    void testCrearCuentaSaldoInvalido() {
        String nombreCliente = "Ana García";
        String idCuenta = "0299999999";
        String nombreBanco = "Bancolombia";
        int saldo = 0;

        bankifyGestion.crearCuenta(nombreCliente, idCuenta, nombreBanco, saldo);

        String output = outputStream.toString();
        assertTrue(output.contains("Cuenta no valida"));
    }

    @Test
    void testCrearCuentaIdInvalido() {
        String nombreCliente = "Carlos López";
        String idCuenta = "123"; // Muy corto
        String nombreBanco = "Bancolombia";
        int saldo = 100000;

        bankifyGestion.crearCuenta(nombreCliente, idCuenta, nombreBanco, saldo);

        String output = outputStream.toString();
        assertTrue(output.contains("Cuenta no valida"));
    }

    @Test
    void testConsultarCuentaExistente() {
        // Crear cuenta primero
        bankifyGestion.crearCuenta("Test", "0255555555", "Bancolombia", 30000);

        Cuenta cuenta = bankifyGestion.consultarCuenta("0255555555");

        assertNotNull(cuenta);
        assertEquals("0255555555", cuenta.getIdCuenta());
    }

    @Test
    void testConsultarCuentaInexistente() {
        Cuenta cuenta = bankifyGestion.consultarCuenta("9999999999");

        assertNull(cuenta);
    }

    @Test
    void testConsultarSaldo() {
        // Crear cuenta primero
        bankifyGestion.crearCuenta("Test", "0266666666", "Bancolombia", 80000);

        int saldo = bankifyGestion.consultarSaldo("0266666666");

        assertEquals(80000, saldo);
    }

    @Test
    void testRealizarDeposito() {
        int monto = 15000;

        // Verificar que no lance excepción
        assertDoesNotThrow(() -> {
            bankifyGestion.realizarDeposito(monto);
        });
    }

    @Test
    void testConsultarDepositos() {
        ArrayList<Deposito> depositos = bankifyGestion.consultarDepositos();

        assertNotNull(depositos);
    }
}
