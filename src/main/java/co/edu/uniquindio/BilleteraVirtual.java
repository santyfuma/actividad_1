package co.edu.uniquindio;

import java.util.ArrayList;

public class BilleteraVirtual {
    private  String numero;
    private float saldo;
    private ArrayList<Transaccion> transacciones;
    private  Usuario usuario;

    public BilleteraVirtual(String numero, float saldo, ArrayList<Transaccion> transacciones, Usuario usuario) {
        this.numero = numero;
        this.saldo = saldo;
        this.transacciones = transacciones;
        this.usuario = usuario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(ArrayList<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void consultarSaldo(){

    }
    public void consultarTransacciones(){

    }
    public void realizarTransaccion(){

    }
    public void obtenerPorcentajeGastosIngresos(){

    }
}
