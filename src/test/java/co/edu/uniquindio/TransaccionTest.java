package co.edu.uniquindio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TransaccionTest {

    @Test
    void testCrearTransaccion() {
        Usuario usuario1 = new Usuario("1", "Juan", "Calle 123", "juan@example.com", "password", true);
        Usuario usuario2 = new Usuario("2", "Maria", "Calle 456", "maria@example.com", "password", true);

        BilleteraVirtual billeteraOrigen = new BilleteraVirtual("1234567890", 1000, new ArrayList<>(), usuario1);
        BilleteraVirtual billeteraDestino = new BilleteraVirtual("0987654321", 500, new ArrayList<>(), usuario2);

        Transaccion transaccion = new Transaccion("1", 300, LocalDateTime.now(), Categoria.FACTURAS, billeteraOrigen, billeteraDestino);

        assertEquals("1", transaccion.getId());
        assertEquals(300, transaccion.getMonto());
        assertEquals(Categoria.FACTURAS, transaccion.getCategoria());
        assertEquals(billeteraOrigen, transaccion.getOrigen());
        assertEquals(billeteraDestino, transaccion.getDestino());
    }
}