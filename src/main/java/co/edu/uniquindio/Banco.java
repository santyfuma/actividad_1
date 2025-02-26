package co.edu.uniquindio;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Banco {
    private ArrayList<Usuario> usuarios;
    private ArrayList<BilleteraVirtual> billeteras;

    Banco() {
        this.usuarios = new ArrayList<>();
        this.billeteras = new ArrayList<>();

    }

    /**
     * Metodo para añadir un nuevo usuario a la lista de usuarior del banco  validando que este no exista en la lista
     *
     * @param usuario
     * @throws Exception
     */
    public void crearUsuario(Usuario usuario) throws Exception {

        Usuario usuarioBuscado = obtenerUsuario(usuario.getId());

        // Si el Usuario ya existe, lanzar una excepción
        if (usuarioBuscado != null) {
            throw new Exception("Usuario ya existe");
        } else {
            usuarios.add(usuario);
        }
    }

    /**
     * Metodo  para actualizar los datos de un usuario por medio de su id,validando que este exista en la lista de usuarios
     *
     * @param id
     * @param nuevoNombre
     * @param nuevaDireccion
     * @param nuevoEmail
     * @param nuevaPassword
     * @throws Exception
     */
    public void actualizarUsuario(String id, String nuevoNombre, String nuevaDireccion, String nuevoEmail, String nuevaPassword) throws Exception {
        Usuario usuario = obtenerUsuario(id);
        if (usuario == null) {
            throw new Exception("Usuario no encontrado");
        }
        usuario.setNombre(nuevoNombre);
        usuario.setDireccion(nuevaDireccion);
        usuario.setEmail(nuevoEmail);
        usuario.setPassword(nuevaPassword);

    }

    /**
     * Metodo para eliminar un usuario por medio de su id,validando que exista en la lista de usuarios
     *
     * @param id
     * @throws Exception
     */
    public void eliminarUsuario(String id) throws Exception {
        Usuario usuario = obtenerUsuario(id);
        if (usuario == null) {
            throw new Exception("Usuario no encontrado");
        } else {
            usuarios.remove(usuario);
        }
    }

    /**
     * Metodo para añadir una nueva billetera virtual a lista del banco, validando que esta no exista en la lista de billeteras del banco
     *
     * @param billeteraVirtual
     * @throws Exception
     */
    public void crearBilleteraVirtual(BilleteraVirtual billeteraVirtual) throws Exception {
        BilleteraVirtual billeteraBuscada = obtenerBilletera(billeteraVirtual.getNumero());

        if (billeteraBuscada != null) {
            throw new Exception("Ya existe una billetera con este numero");
        } else {
            billeteras.add(billeteraVirtual);
        }

    }

    /**
     * metodo que busca una billetera para saber si esta existe
     *
     * @param numero
     */
    public BilleteraVirtual obtenerBilletera(String numero) {

        return billeteras
                .stream()
                .filter(b -> b.getNumero().equals(numero))
                .findFirst()
                .orElse(null);

    }

    /**
     * Metodo que busca un usuario para saber si este existe.
     *
     * @param id
     * @return Si encuentra un usuario retorna el el usuario encontrado, de lo contrario retorna else
     */
    public Usuario obtenerUsuario(String id) {
        // Buscar el Usuario con el ID dado (se usa programación funcional)
        return usuarios
                .stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);

    }

    public void recargarBilletera(String numeroBilletera, Float monto) throws Exception {
        if (monto <= 0) {
            throw  new Exception("El monto debe ser positivo");
        }
        BilleteraVirtual billetera = obtenerBilletera(numeroBilletera);
        if (billetera == null) {
            throw new Exception("El billetera no existe");
        }
        billetera.recargarSaldo(monto);
    }

    public void realizarTransaccion(String idOrigen, String idDestino, float monto, Categoria categoria) throws Exception {
        BilleteraVirtual origen = obtenerBilletera(idOrigen);
        BilleteraVirtual destino = obtenerBilletera(idDestino);

        // Validaciones
        if (origen == null || destino == null) {
            throw new Exception("La billetera de origen o la billetera de destino no existe");
        }
        if (origen.getSaldo() < monto + 200) {
            throw new Exception("Saldo insuficiente para realizar la transacción");
        }

        // Realizar la transacción
        origen.recargarSaldo(-(monto - 200)); // Se descuenta el monto más la tarifa de $200
        destino.recargarSaldo(monto); // Se recarga el monto en la billetera destino

        // Crear objeto Transacción
        Transaccion transaccion = new Transaccion(
                UUID.randomUUID().toString(), // ID único para la transacción
                monto,
                LocalDateTime.now(),
                categoria,
                origen,
                destino
        );

        // Registrar la transacción en ambas billeteras
        origen.agregarTransaccion(transaccion);
        destino.agregarTransaccion(transaccion);

    }
}

