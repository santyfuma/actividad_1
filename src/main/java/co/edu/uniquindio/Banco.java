package co.edu.uniquindio;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Banco {
    private ArrayList<Usuario> usuarios;
    private ArrayList<BilleteraVirtual> billeteras;

    Banco(){
        this.usuarios = new ArrayList<>();
        this.billeteras = new ArrayList<>();

    }

    /**
     * Metodo para añadir un nuevo usuario a la lista de usuarior del bancom  validandoque este no exista en la lista
     * @param usuario
     * @throws Exception
     */
    public void crearUsuario(Usuario usuario) throws  Exception{

        Usuario usuarioBuscado = obtenerUsuario(usuario.getId());

        // Si el Usuario ya existe, lanzar una excepción
        if(usuarioBuscado!=null){
            throw new Exception("Usuario ya existe");
        } else{
            usuarios.add(usuario);
        }
    }


    public void actualizarUsuario(String id,String nuevoNombre,String nuevaDireccion,String nuevoEmail, String nuevaPassword) throws Exception {
            Usuario usuario= obtenerUsuario(id);
                if (usuario==null) {
                    throw new Exception("Usuario no encontrado");
                }
                usuario.setNombre(nuevoNombre);
                usuario.setDireccion(nuevaDireccion);
                usuario.setEmail(nuevoEmail);
                usuario.setPassword(nuevaPassword);

    }

    public void eliminarUsuario(String id) throws Exception{
          Usuario usuario = obtenerUsuario(id);
          if (usuario == null){
              throw new Exception("Usuario no encontrado");
          }
          else {
              usuarios.remove(usuario);
          }
    }

    /**
     * Metodo para añadir una nueva billetera virtual a lista del banco, validando que esta no exista en la lista de billeteras del banco
     * @param billeteraVirtual
     * @throws Exception
     */
    public void crearBilleteraVirtual(BilleteraVirtual billeteraVirtual) throws Exception{
        BilleteraVirtual  billeteraBuscada = obtenerBilletera(billeteraVirtual.getNumero());

        if (billeteraBuscada!=null) {
            throw new Exception("Ya existe una billetera con este numero");
        }
        else {
            billeteras.add(billeteraVirtual);
        }

    }

    /**
     * metodo que busca una billetera para saber si esta existe
     * @param numero
     */
    public BilleteraVirtual  obtenerBilletera(String numero){

        return billeteras
                .stream()
                .filter(b->b.getNumero().equals(numero))
                .findFirst()
                .orElse(null);

    }

    /**
     * Metodo que busca un usuario para saber si este existe.
     * @param id
     * @return Si encuentra un usuario retorna el el usuario encontrado, de lo contrario retorna else
     */
    public Usuario obtenerUsuario(String id){
        // Buscar el Usuario con el ID dado (se usa programación funcional)
        return usuarios
                .stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);

    }

    public void realizarTransaccion( ){


    }



}
