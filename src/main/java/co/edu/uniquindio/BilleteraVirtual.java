package co.edu.uniquindio;

import java.time.LocalDateTime;
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
        System.out.println("saldo de billetera"+numero+":$"+saldo);

    }
    public void consultarTransacciones(){

    }
    public void realizarTransaccion(String id, BilleteraVirtual destino, float monto, Categoria categoria) throws Exception{
        // Validaciones Previos
        if (destino == null) {
            throw new IllegalArgumentException("La billetera de destino no puede ser nula.");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero.");
        }
        if (this.saldo < monto) {
            throw new Exception("Saldo insuficiente en la billetera de origen.");
        }
        if (this.equals(destino)) {
            throw new Exception("No se puede transferir saldo a la misma billetera.");
        }
        // Crear la transaccion
        Transaccion transaccion= new Transaccion(id,monto, LocalDateTime.now(),categoria,this, destino);

        // Realizar la transaccion, Debitar y acreditar saldo
        this.saldo -=monto;
        destino.saldo=monto;
        //Reguistrar en la billetara
        this.transacciones.add(transaccion);
        destino.transacciones.add(transaccion);
        System.out.println("Transaccion realizada con exito"+transaccion);


    }
    public void obtenerPorcentajeGastosIngresos() {
        // Verifica si la billetera tiene transacciones registradas
        if (transacciones.isEmpty())
            System.out.prinln("No hay transacciones registradas en la billetera " + numero);
        }
        return;
    // Variables para almacenar el total de gastos e ingresos
        float totalesGastos=0;
        float totalIngresos=0;
    // Recorre la lista de transacciones para clasificar los montos
    for (transacciones t : transacciones){
        if (t.getDestino().equals(this)) {
            totalIngresos += t.getMonto();
            // Si esta billetera es el origen, significa que es un gasto
        }   else if (t.getOrigen().equals(this)) {
            totalGastos += t.getMonto();
        }
    }
    // Calcula el total de transacciones (suma de ingresos y gastos)
    float totalTransacciones = totalGastos + totalIngresos;
    // Si no hay transacciones válidas, se notifica al usuario
    if (totalTransacciones == 0) {
        System.out.println("No hay transacciones válidas para calcular porcentajes.");
        return;
    }
    // Cálculo de porcentajes de gastos e ingresos
    float porcentajeGastos = (totalGastos / totalTransacciones) * 100;
    float porcentajeIngresos = (totalIngresos / totalTransacciones) * 100;
// Muestra los resultados en un formato claro
    System.out.println("Resumen de transacciones para la billetera " + numero + ":");
    System.out.println("Total Gastos: $" + totalGastos + " (" + String.format("%.2f", porcentajeGastos) + "%)");
    System.out.println("Total Ingresos: $" + totalIngresos + " (" + String.format("%.2f", porcentajeIngresos) + "%)");
}

    public void recargarSaldo(float monto){
        this.saldo=(saldo+monto);

    }

    public void  agregarTransaccion(Transaccion transaccion){
        this.transacciones.add(transaccion);
    }
}
