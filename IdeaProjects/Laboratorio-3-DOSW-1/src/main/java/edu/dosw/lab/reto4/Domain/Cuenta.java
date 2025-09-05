package reto4.Domain;

public class Cuenta {
    private String idCuenta;
    private Integer saldoCuenta;
    private BancoRegistrado banco;

    public Cuenta(String idCuenta, Integer saldoCuenta, BancoRegistrado banco) {
        this.idCuenta = idCuenta;
        this.saldoCuenta = saldoCuenta;
        this.banco = banco;
    }

    public String getIdCuenta() {
        return idCuenta;
    }
    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Integer getSaldoCuenta() {
        return saldoCuenta;
    }
    public void setSaldoCuenta(Integer saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    public BancoRegistrado getBanco() {
        return banco;
    }
    public void setBanco(BancoRegistrado banco) {
        this.banco = banco;
    }

    public void depositar(Deposito deposito) {
        saldoCuenta += deposito.getValor();
    }
}
