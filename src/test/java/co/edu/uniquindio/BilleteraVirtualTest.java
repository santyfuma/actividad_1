package co.edu.uniquindio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BilleteraVirtualTest {

    @Test
    void testCrearBilleteraVirtual() {
        Usuario usuario = new Usuario("1", "Juan", "Calle 123", "juan@example.com", "password", true);
        BilleteraVirtual billetera = new BilleteraVirtual("1234567890", 1000, new ArrayList<>(), usuario);

        assertEquals("1234567890", billetera.getNumero());
        assertEquals(1000, billetera.getSaldo());
        assertEquals(usuario, billetera.getUsuario());
    }

    @Test
    void testRecargarSaldo() {
        Usuario usuario = new Usuario("1", "Juan", "Calle 123", "juan@example.com", "password", true);
        BilleteraVirtual billetera = new BilleteraVirtual("1234567890", 1000, new ArrayList<>(), usuario);

        billetera.recargarSaldo(500);
        assertEquals(1500, billetera.getSaldo());
    }

    @Test
    void testRealizarTransaccion() throws Exception {
        Usuario usuario1 = new Usuario("1", "Juan", "Calle 123", "juan@example.com", "password", true);
        Usuario usuario2 = new Usuario("2", "Maria", "Calle 456", "maria@example.com", "password", true);

        BilleteraVirtual billeteraOrigen = new BilleteraVirtual("1234567890", 1000, new ArrayList<>(), usuario1);
        BilleteraVirtual billeteraDestino = new BilleteraVirtual("0987654321", 500, new ArrayList<>(), usuario2);

        billeteraOrigen.realizarTransaccion("1", billeteraDestino, 300, Categoria.FACTURAS);

        assertEquals(700, billeteraOrigen.getSaldo()); // 1000 - 300
        assertEquals(800, billeteraDestino.getSaldo()); // 500 + 300
    }
}