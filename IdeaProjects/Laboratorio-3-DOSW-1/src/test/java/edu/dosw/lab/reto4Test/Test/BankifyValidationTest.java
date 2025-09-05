package Test;

import reto4.Domain.*;
import reto4.Util.RegistrarBancos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias básicas para la clase BankifyValidacion.
 * Sigue el ciclo TDD (Rojo -> Verde -> Refactor).
 *
 * @author Bankify Team
 * @version 1.0
 */
public class BankifyValidationTest {

    private BankifyValidacion bankifyValidacion;
    private HashMap<String, BancoRegistrado> bancos;
    private HashMap<String, Cuenta> cuentas;

    @BeforeEach
    void setUp() {
        bankifyValidacion = new BankifyValidacion();
        bancos = RegistrarBancos.getBancos();
        cuentas = new HashMap<>();

        // Cuenta existente
        cuentas.put("0212345678", new Cuenta("0212345678", 100000, bancos.get("Bancolombia")));
    }

    @Test
    void testValidarCuentaValida() {
        String idCuenta = "0299999999";

        boolean resultado = bankifyValidacion.validarCuenta(idCuenta, bancos, cuentas);

        assertTrue(resultado);
    }

    @Test
    void testValidarCuentaLongitudIncorrecta() {
        String idCuenta = "123456789";

        boolean resultado = bankifyValidacion.validarCuenta(idCuenta, bancos, cuentas);

        assertFalse(resultado);
    }

    @Test
    void testValidarCuentaExistente() {
        String idCuenta = "0212345678";

        boolean resultado = bankifyValidacion.validarCuenta(idCuenta, bancos, cuentas);
        assertFalse(resultado);
    }

    @Test
    void testValidarCuentaBancoNoRegistrado() {
        String idCuenta = "9999999999";

        boolean resultado = bankifyValidacion.validarCuenta(idCuenta, bancos, cuentas);

        assertFalse(resultado);
    }

    @Test
    void testConsultarCuentaExistente() {
        String idCuenta = "0212345678";

        Cuenta cuenta = bankifyValidacion.consultarCuenta(idCuenta, cuentas);

        assertNotNull(cuenta);
        assertEquals(idCuenta, cuenta.getIdCuenta());
    }

    @Test
    void testConsultarCuentaNoExistente() {
        String idCuenta = "9999999999";

        Cuenta cuenta = bankifyValidacion.consultarCuenta(idCuenta, cuentas);

        assertNull(cuenta);
    }

    @Test
    void testConsultarBancoExistente() {

        String nombreBanco = bankifyValidacion.consultarBanco("02", bancos);

        assertEquals("Bancolombia", nombreBanco);
    }

    @Test
    void testConsultarBancoNoExistente() {
        String nombreBanco = bankifyValidacion.consultarBanco("99", bancos);

        assertNull(nombreBanco);
    }
}

