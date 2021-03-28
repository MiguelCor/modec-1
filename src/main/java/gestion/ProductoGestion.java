package gestion;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import model.Producto;
import model.Conexion;

/**
 *
 * @author Grupo 7
 */
public class ProductoGestion {

    private static final String SQL_GETPRODUCTOS = "select * from producto where id_tipoproducto =?";
    private static final String SQL_GETPRODUCTO = "select * from producto where id_producto =?";

    //Metodo encargado de traer los productos
    public static ArrayList<Producto> getProductos(int tipoProducto) {
        ArrayList<Producto> list = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_GETPRODUCTOS);
            sentencia.setInt(1, tipoProducto);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                list.add(new Producto(
                        rs.getInt(1), // ID
                        rs.getString(2), // NOMBRE
                        rs.getString(3), // DESCRIPCION
                        rs.getString(4), // IMAGEN
                        rs.getFloat(5), // PRECIO
                        rs.getString(6).charAt(0), // GENERO
                        rs.getString(7), // TALLA
                        rs.getInt(8), // CANTIDAD
                        rs.getInt(9), // ID ENTREGA
                        rs.getInt(10) // ID TIPOPRODUCTO
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    // Metodo encargado de devolver un unico producto
    public static Producto getProducto(int id_producto) {
        Producto producto = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_GETPRODUCTO);
            sentencia.setInt(1, id_producto);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                producto = new Producto(
                        rs.getInt(1), // ID
                        rs.getString(2), // NOMBRE
                        rs.getString(3), // DESCRIPCION
                        rs.getString(4), // IMAGEN
                        rs.getFloat(5), // PRECIO
                        rs.getString(6).charAt(0), // GENERO
                        rs.getString(7), // TALLA
                        rs.getInt(8), // CANTIDAD
                        rs.getInt(9), // ID ENTREGA
                        rs.getInt(10) // ID TIPOPRODUCTO
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producto;
    }

} // Fin Clase CamisasHombreGestion
