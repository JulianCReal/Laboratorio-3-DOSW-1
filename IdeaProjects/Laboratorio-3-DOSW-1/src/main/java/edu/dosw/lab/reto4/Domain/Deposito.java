package reto4.Domain;

import java.time.LocalDate;
import java.util.UUID;

public class Deposito {
    private String idDeposito;
    private LocalDate fechaDeposito;
    private Integer valor;

    public Deposito(Integer valor) {
        this.idDeposito = UUID.randomUUID().toString();
        this.fechaDeposito = LocalDate.now();
        this.valor = valor;
    }

    public String getIdDeposito() {
        return idDeposito;
    }

    public LocalDate getFechaDeposito() {
        return fechaDeposito;
    }

    public Integer getValor() {
        return valor;
    }

}
