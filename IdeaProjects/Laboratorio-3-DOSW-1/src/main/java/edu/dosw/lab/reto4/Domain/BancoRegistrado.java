package reto4.Domain;

public class BancoRegistrado {
    private String idBanco;
    private String nombreBanco;

    public BancoRegistrado(String idBanco, String nombreBanco) {
        this.idBanco = idBanco;
        this.nombreBanco = nombreBanco;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public String getIdBanco() {
        return idBanco;
    }
}
