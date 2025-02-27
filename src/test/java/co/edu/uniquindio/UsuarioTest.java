package co.edu.uniquindio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void testCrearUsuario() {
        Usuario usuario = new Usuario("1", "Juan", "Calle 123", "juan@example.com", "password", true);
        assertEquals("1", usuario.getId());
        assertEquals("Juan", usuario.getNombre());
        assertEquals("Calle 123", usuario.getDireccion());
        assertEquals("juan@example.com", usuario.getEmail());
        assertEquals("password", usuario.getPassword());
        assertTrue(usuario.isEstado());
    }

    @Test
    void testActualizarUsuario() {
        Usuario usuario = new Usuario("1", "Juan", "Calle 123", "juan@example.com", "password", true);
        usuario.setNombre("Juan Pérez");
        usuario.setDireccion("Calle 456");
        usuario.setEmail("juan.perez@example.com");
        usuario.setPassword("newpassword");
        usuario.setEstado(false);

        assertEquals("Juan Pérez", usuario.getNombre());
        assertEquals("Calle 456", usuario.getDireccion());
        assertEquals("juan.perez@example.com", usuario.getEmail());
        assertEquals("newpassword", usuario.getPassword());
        assertFalse(usuario.isEstado());
    }
}