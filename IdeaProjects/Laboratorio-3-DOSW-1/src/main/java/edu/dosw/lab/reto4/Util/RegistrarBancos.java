package reto4.Util;

import java.util.HashMap;
import reto4.Domain.BancoRegistrado;

/**
 * Clase encargada de registrar los bancos disponibles en el sistema.
 */
public class RegistrarBancos {
    private static final HashMap<String, BancoRegistrado> BANCOS = new HashMap<>();

    static {
        BANCOS.put("Banco de Bogotá", new BancoRegistrado("01", "Banco de Bogotá"));
        BANCOS.put("Bancolombia", new BancoRegistrado("02", "Bancolombia"));
        BANCOS.put("Davivienda", new BancoRegistrado("03", "Davivienda"));
        BANCOS.put("Banco Popular", new BancoRegistrado("04", "Banco Popular"));
        BANCOS.put("Banco de Occidente", new BancoRegistrado("05", "Banco de Occidente"));
        BANCOS.put("BBVA Colombia", new BancoRegistrado("06", "BBVA Colombia"));
        BANCOS.put("Banco AV Villas", new BancoRegistrado("07", "Banco AV Villas"));
        BANCOS.put("Banco Agrario", new BancoRegistrado("08", "Banco Agrario"));
        BANCOS.put("Scotiabank Colpatria", new BancoRegistrado("09", "Scotiabank Colpatria"));
        BANCOS.put("Itaú Colombia", new BancoRegistrado("10", "Itaú Colombia"));
        BANCOS.put("Banco Pichincha", new BancoRegistrado("11", "Banco Pichincha"));
        BANCOS.put("Finandina", new BancoRegistrado("12", "Finandina"));
        BANCOS.put("Banco Falabella", new BancoRegistrado("13", "Banco Falabella"));
        BANCOS.put("Banco Cooperativo Coopcentral", new BancoRegistrado("14", "Banco Cooperativo Coopcentral"));
        BANCOS.put("GNB Sudameris", new BancoRegistrado("15", "GNB Sudameris"));
    }

    public static HashMap<String, BancoRegistrado> getBancos() {
        return BANCOS;
    }
}


