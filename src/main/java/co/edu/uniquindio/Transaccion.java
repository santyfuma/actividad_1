package co.edu.uniquindio;

import java.time.LocalDateTime;

public class Transaccion {
    private String id;
    private float monto;
    private LocalDateTime fecha;
    private Categoria categoria;
    private BilleteraVirtual origen;
    private BilleteraVirtual destino;

    public Transaccion(String id, float monto, LocalDateTime fecha, Categoria categoria, BilleteraVirtual origen, BilleteraVirtual destino) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.categoria = categoria;
        this.origen = origen;
        this.destino = destino;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public BilleteraVirtual getOrigen() {
        return origen;
    }

    public void setOrigen(BilleteraVirtual origen) {
        this.origen = origen;
    }

    public BilleteraVirtual getDestino() {
        return destino;
    }

    public void setDestino(BilleteraVirtual destino) {
        this.destino = destino;
    }
}
