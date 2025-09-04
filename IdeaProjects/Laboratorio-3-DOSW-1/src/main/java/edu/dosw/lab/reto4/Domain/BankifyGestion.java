package edu.dosw.lab.reto4.Domain;

import java.util.ArrayList;
import java.util.HashMap;

import edu.dosw.lab.reto4.Util.RegistrarBancos;

public class BankifyGestion {
    private HashMap<String, BancoRegistrado> bancosRegistrados;
    private HashMap<String, Cuenta> cuentasRegistradas;
    private BankifyValidacion bankifyValidacion;
    private Cliente cliente;

    public BankifyGestion(Cliente cliente) {
        this.bancosRegistrados = RegistrarBancos.getBancos();
        this.cuentasRegistradas = new HashMap<>();
        this.bankifyValidacion = new BankifyValidacion();
        this.cliente = cliente;
    }

    public void crearCuenta (String nombreCliente, String idCuenta, String nombreBanco, int saldo){
        if(bankifyValidacion.validarCuenta(idCuenta, bancosRegistrados, cuentasRegistradas) && saldo > 0){
            Cuenta cuenta = new Cuenta(idCuenta, saldo, bancosRegistrados.get(nombreBanco));
            System.out.println("Cuenta creada con éxito");
            cuentasRegistradas.put(idCuenta, cuenta);
        }else{
            System.out.println("Cuenta no valida. El id ingresado ya existe o no cumple con los requisitos del sistema");
        }
    }
    public Cuenta consultarCuenta(String idCuenta) {
        return bankifyValidacion.consultarCuenta(idCuenta, cuentasRegistradas);
    }

    public int consultarSaldo (String idCuenta){
        return cuentasRegistradas.get(idCuenta).getSaldoCuenta();
    }

    public void realizarDeposito(int monto){
        cliente.realizarDeposito(monto);
    }
    public ArrayList<Deposito> consultarDepositos (){
        ArrayList<Deposito> depositos = cliente.getDepositos();
        return cliente.getDepositos();
    }
}
