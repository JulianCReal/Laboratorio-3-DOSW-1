package reto4.Domain;

import java.util.HashMap;
import java.util.Map;

public class BankifyValidacion {
    public boolean validarCuenta (String idCuenta, HashMap<String, BancoRegistrado> bancos, HashMap<String, Cuenta> cuentas) {
        if(idCuenta.length() != 10 || cuentas.containsKey(idCuenta)) {
            return false;
        }

        String inicioCuenta = idCuenta.substring(0,2);
        return bancos.values().stream().anyMatch(b -> b.getIdBanco().equals(inicioCuenta));
    }

    public Cuenta consultarCuenta(String idCuenta, HashMap<String, Cuenta> cuentasRegistradas){
        Cuenta cuenta;
        cuenta = cuentasRegistradas.entrySet().stream().filter(entry -> entry.getKey().equals(idCuenta)).map(Map.Entry::getValue).findFirst().orElse(null);
        return cuenta;
    }

    public String consultarBanco(String idBanco, HashMap<String, BancoRegistrado> bancos) {
        for (String nombreBanco : bancos.keySet()) {
            if (bancos.get(nombreBanco).getIdBanco().equals(idBanco)) {
                return nombreBanco;
            }
        }
        return null;
    }
}
