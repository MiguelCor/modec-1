package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Carrito;
import model.Conexion;

/**
 *
 * @author Grupo 7
 */
public class CarritoGestion {
    
    private static final String SQL_GETPRODUCTOS = "select producto.nombre_producto,carrito.cantidad, producto.precio, producto.urlImagen from producto inner join carrito on producto.id_producto = carrito.id_producto where carrito.id_usuario=?";
    private static final String SQL_INSERTPRODUCTO = "insert into carrito(id_usuario,id_producto,cantidad) values(?,?,?)";

    //Metodo encargado de traer los productos del carrito
    public static ArrayList<Carrito> getCarrito(int id_usuario) {
        ArrayList<Carrito> list = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_GETPRODUCTOS);
            sentencia.setInt(1, id_usuario);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                list.add(new Carrito(
                        rs.getString(1), // NOMBRE_PRODUCTO
                        rs.getInt(2), // Cantidad
                        rs.getFloat(3), // PRECIO
                        rs.getString(4), // URLIMAGEN
                        rs.getInt(id_usuario) // ID_USUARIO
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    // Metodo encargado de insertar productos en el carrito
    public static boolean insertCarrito(int id_usuario, int id_producto, int cantidad) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_INSERTPRODUCTO);
            sentencia.setInt(1, id_usuario);
            sentencia.setInt(2, id_producto);
            sentencia.setInt(3, cantidad);
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
} // Fin Clase CarritoGestion
