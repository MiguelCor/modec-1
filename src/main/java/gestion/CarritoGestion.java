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

    private static final String SQL_GETCARRITO = "select producto.nombre_producto,producto.precio,producto.urlImagen,carrito.id_carrito,carrito.cantidad from producto inner join carrito on producto.id_producto = carrito.id_producto where carrito.id_usuario=?";
    private static final String SQL_INSERTCARRITO = "insert into carrito(id_usuario,id_producto,cantidad) values(?,?,?)";
    private static final String SQL_DELETECARRITO = "delete from carrito where id_carrito=?";

    //Metodo encargado de traer los productos del carrito
    public static ArrayList<Carrito> getCarrito(int id_usuario) {
        ArrayList<Carrito> list = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_GETCARRITO);
            sentencia.setInt(1, id_usuario);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                list.add(new Carrito(
                        rs.getString(1), // NOMBRE_PRODUCTO
                        rs.getFloat(2), // PRECIO
                        rs.getString(3), // URLIMAGEN
                        rs.getInt(4), // ID_CARRITO
                        rs.getInt(5), // CANTIDAD
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
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_INSERTCARRITO);
            sentencia.setInt(1, id_usuario);
            sentencia.setInt(2, id_producto);
            sentencia.setInt(3, cantidad);
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Metodo encargado de eliminar productos en el carrito
    public static boolean deleteCarrito(int id_carrito) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_DELETECARRITO);
            sentencia.setInt(1, id_carrito);
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    // Metodo encargado de contar cuantos productos hay en el carrito
    public static int countCarrito(int id_usuario) {
        ArrayList<Carrito> list = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_GETCARRITO);
            sentencia.setInt(1, id_usuario);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                list.add(new Carrito(
                        rs.getString(1), // NOMBRE_PRODUCTO
                        rs.getFloat(2), // PRECIO
                        rs.getString(3), // URLIMAGEN
                        rs.getInt(4), // ID_CARRITO
                        rs.getInt(5), // CANTIDAD
                        rs.getInt(id_usuario) // ID_USUARIO
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list.size();
    }

} // Fin Clase CarritoGestion
