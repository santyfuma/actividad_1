package co.edu.uniquindio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BancoTest {

    @Test
    void testCrearUsuario() throws Exception {
        Banco banco = new Banco();
        Usuario usuario = new Usuario("1", "Juan", "Calle 123", "juan@example.com", "password", true);
        banco.crearUsuario(usuario);

        assertEquals(usuario, banco.obtenerUsuario("1"));
    }

    @Test
    void testCrearBilleteraVirtual() throws Exception {
        Banco banco = new Banco();
        Usuario usuario = new Usuario("1", "Juan", "Calle 123", "juan@example.com", "password", true);
        banco.crearUsuario(usuario);
        banco.crearBilleteraVirtual(usuario);

        BilleteraVirtual billetera = banco.obtenerBilletera(usuario.getBilletera().getNumero());
        assertNotNull(billetera);
        assertEquals(usuario, billetera.getUsuario());
    }

    @Test
    void testRealizarTransaccion() throws Exception {
        Banco banco = new Banco();
        Usuario usuario1 = new Usuario("1", "Juan", "Calle 123", "juan@example.com", "password", true);
        Usuario usuario2 = new Usuario("2", "Maria", "Calle 456", "maria@example.com", "password", true);

        banco.crearUsuario(usuario1);
        banco.crearUsuario(usuario2);
        banco.crearBilleteraVirtual(usuario1);
        banco.crearBilleteraVirtual(usuario2);

        banco.recargarBilletera(usuario1.getBilletera().getNumero(), 1000);
        banco.realizarTransaccion(usuario1.getBilletera().getNumero(), usuario2.getBilletera().getNumero(), 500, Categoria.FACTURAS);

        assertEquals(300, banco.obtenerBilletera(usuario1.getBilletera().getNumero()).getSaldo()); // 1000 - 500 - 200 (tarifa)
        assertEquals(500, banco.obtenerBilletera(usuario2.getBilletera().getNumero()).getSaldo());
    }
}{

}