package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Grafico;

/**
 *
 * @author Grupo 7
 */
public class GraficoGestion {
    
    private static final String SQL_COUNTARTICULOSCARRITO = "select nombre_producto as nombre, count(*) total from carrito inner join producto on carrito.id_producto = producto.id_producto group by nombre";
    
    //Metodo encargado de traer los nombre de los articulos y cuantas veces se han agregado al carrito
    public static ArrayList<Grafico> getCountArticulosCarrito() {
        ArrayList<Grafico> list = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_COUNTARTICULOSCARRITO);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                list.add(new Grafico(
                        rs.getString(1),
                        rs.getInt(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GraficoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
} // Fin Clase GraficoGestion
