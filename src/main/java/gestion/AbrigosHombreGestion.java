package gestion;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import model.AbrigosHombre;
import model.Conexion;

/**
 *
 * @author Grupo 7
 */
public class AbrigosHombreGestion {

    private static final String SQL_GETPRODUCTOS = "select * from producto where id_tipoproducto > 3 && id_tipoproducto <= 5";
    private static final String SQL_GETIMAGENES = "select * from producto where id_producto=?";

    //Metodo encargado de traer todos los abrigos de hombre
    public static ArrayList<AbrigosHombre> getProductos() {
        ArrayList<AbrigosHombre> list = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_GETPRODUCTOS);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                list.add(new AbrigosHombre(
                        rs.getInt(1), // ID
                        rs.getString(2), // NOMBRE
                        rs.getString(3), // DESCRIPCION
                        rs.getBinaryStream(4), // IMAGEN
                        rs.getFloat(5), // PRECIO
                        rs.getString(6).charAt(0), // GENERO
                        rs.getString(7), // TALLA
                        rs.getInt(8), // CANTIDAD
                        rs.getInt(9), // ID ENTREGA
                        rs.getInt(10) // ID TIPOPRODUCTO
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbrigosHombreGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void listarImagen(int id, HttpServletResponse response) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            outputStream = response.getOutputStream();
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_GETIMAGENES);
            sentencia.setInt(1, id);
            ResultSet rs = sentencia.executeQuery();
            if (rs != null && rs.next()) {
                inputStream = rs.getBinaryStream("Foto");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbrigosHombreGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

} // Fin Clase AbrigosHombreGestion
