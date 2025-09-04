package reto4.Domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Cliente {
    private String idCliente;
    private String nombre;
    private String documentoCliente;
    private Cuenta cuenta;
    private Deposito deposito;
    private ArrayList<Deposito> depositos;

    private Set<String> idsGenerados = new HashSet<>();

    public Cliente(String nombre, String documentoCliente, Cuenta cuenta) {
        this.idCliente = generarIdUnico();
        this.nombre = nombre;
        this.documentoCliente = documentoCliente;
        this.cuenta = cuenta;
        this.depositos = new ArrayList<>();
    }

    private String generarIdUnico() {
        String nuevoId;
        do {
            nuevoId = UUID.randomUUID().toString();
        } while (idsGenerados.contains(nuevoId));
        idsGenerados.add(nuevoId);
        return nuevoId;
    }

    public String getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }
    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public void realizarDeposito (int cantidad) {
        deposito = new Deposito(cantidad);
        cuenta.depositar(deposito);
        depositos.add(deposito);
    }
    public ArrayList<Deposito> getDepositos() {
        return depositos;
    }
}
