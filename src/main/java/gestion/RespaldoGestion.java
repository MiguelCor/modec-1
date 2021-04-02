package gestion;

import java.io.StringWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import model.Conexion;
import model.Respaldo;

/**
 *
 * @author Grupo 7
 */
public class RespaldoGestion {

    private static final String SQL_RESPALDOCOMPLETO = "select carrito.id_carrito, carrito.id_usuario, carrito.id_producto, carrito.cantidad, producto.nombre_producto, producto.descripcion, producto.urlImagen, producto.precio, usuario.id_usuario, usuario.nombre_usuario, usuario.apellido, usuario.apellido2 from carrito inner join producto on carrito.id_producto = producto.id_producto inner join usuario on carrito.id_usuario = usuario.id_usuario";

    public static String generarJson() {
        Respaldo respaldo = null;
        String tiraJson = "";
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_RESPALDOCOMPLETO);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                respaldo = new Respaldo(
                        rs.getInt(1), // id_carrito 
                        rs.getInt(2), // id_usuarioCarrito 
                        rs.getInt(3), // id_productoCarrito 
                        rs.getInt(4), // cantidadCarrito
                        rs.getString(5), // nombre_producto 
                        rs.getString(6), // descripcion 
                        rs.getString(7), // urlImagen 
                        rs.getFloat(8), // precio 
                        rs.getInt(9), // id_usuario 
                        rs.getString(10), // nombre_usuario 
                        rs.getString(11), // apellido 
                        rs.getString(12) // apellido2 
                );
                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                /* fecha1 = sdf.format(respaldo.getFec_entrega());
                fecha2 = sdf.format(respaldo.getFec_orden());
                fecha3 = sdf.format(respaldo.getFec_afiliacion()); */
                JsonObjectBuilder creadorJson = Json.createObjectBuilder();
                JsonObject objectJson = creadorJson.add("id_carrito", respaldo.getId_carrito()) // INICIA CARRITO
                        .add("id_usuarioCarrito", respaldo.getId_usuarioCarrito())
                        .add("id_productoCarrito", respaldo.getId_productoCarrito())
                        .add("cantidadCarrito", respaldo.getCantidadCarrito())
                        .add("nombre_producto", respaldo.getNombre_producto())
                        .add("descripcion", respaldo.getDescripcion())
                        .add("urlImagen", respaldo.getUrlImagen())
                        .add("precio", respaldo.getPrecio())
                        .add("id_usuario", respaldo.getId_usuario()) // INICIA USUARIO
                        .add("nombre_usuario", respaldo.getNombre_usuario())
                        .add("apellido", respaldo.getApellido())
                        .add("apellido2", respaldo.getApellido2())
                        .build();
                StringWriter tira = new StringWriter();
                JsonWriter jsonWriter = Json.createWriter(tira);
                jsonWriter.writeObject(objectJson);
                if (tiraJson == null) {
                    tiraJson = tira.toString() + "\n";
                } else {
                    tiraJson = tiraJson + tira.toString() + "\n";
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RespaldoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tiraJson;
    }

} // Fin Clase RespaldoGestion

                        /* rs.getInt(5), // id_detalle_orden 
                        rs.getInt(6), // id_productoDetalle 
                        rs.getInt(7), // id_ordenDetalle 
                        rs.getInt(8), // cantidadDetalle 
                        // AQUI ME FALTO EL PRECIO DE DETALLE
                        rs.getInt(9), // id_entrega 
                        rs.getString(10), // descipcion_entrega 
                        rs.getDate(11), // fec_entrega 
                        rs.getInt(12), // id_proveedorEntrega 
                        rs.getInt(13), // id_info_pago 
                        rs.getString(14), // num_tarjeta 
                        rs.getString(15), // dir_facturacion 
                        rs.getString(16), // dir_facturacion2 
                        rs.getString(17), // localidad 
                        rs.getString(18), // codigo_postal 
                        rs.getString(19), // telefono 
                        rs.getInt(20), // id_login 
                        rs.getString(21), // usuario 
                        rs.getString(22), // pw_usuario 
                        rs.getString(23), // correo_electronico 
                        rs.getInt(24), // id_metodo_pago 
                        rs.getString(25), // nombre_metodo_pago 
                        rs.getInt(26), // id_orden 
                        rs.getInt(27), // id_info_pagoOrden 
                        rs.getInt(28), // id_metodo_pagoOrden 
                        rs.getInt(29), // id_usuarioOrden 
                        rs.getDate(30), // fec_orden 
                        rs.getFloat(31), // monto_total 
                        rs.getInt(32), // id_producto */
                        /* rs.getString(37).charAt(0), // genero 
                        rs.getString(38), // talla 
                        rs.getInt(39), // cantidadProducto 
                        rs.getInt(40), // id_entregaProducto 
                        rs.getInt(41), // id_tipoproductoProducto 
                        rs.getInt(42), // id_proveedor 
                        rs.getString(43), // nombre_proveedor 
                        rs.getString(44), // ced_juridica 
                        rs.getDate(45), // fec_afiliacion 
                        rs.getInt(46), // id_sucursalProveedor 
                        rs.getInt(47), // id_rol 
                        rs.getString(48), // rol 
                        rs.getInt(49), // id_sucursal 
                        rs.getString(50), // localidad_sucursal 
                        rs.getInt(51), // id_tipoproducto 
                        rs.getString(52), // tipo */
                        /* rs.getInt(57), // id_rolUsuario 
                        rs.getInt(59) // id_loginUsuario */


                    /*  .add("id_detalle_orden", respaldo.getId_detalle_orden()) // INICIA DETALLE_ORDEN
                        .add("id_productoDetalle", respaldo.getId_productoDetalle())
                        .add("id_ordenDetalle", respaldo.getId_ordenDetalle())
                        .add("cantidadDetalle", respaldo.getCantidadDetalle())
                        // AQUI ME FALTO EL PRECIO DE DETALLE
                        .add("id_entrega", respaldo.getId_entrega()) // INICIA ENTREGA
                        .add("descipcion_entrega", respaldo.getDescipcion_entrega())
                        .add("fec_entrega", fecha1)
                        .add("id_proveedorEntrega", respaldo.getId_proveedorEntrega())
                        .add("id_info_pago", respaldo.getId_info_pago()) // INICIA INFO_PAGO
                        .add("num_tarjeta", respaldo.getNum_tarjeta())
                        .add("dir_facturacion", respaldo.getDir_facturacion())
                        .add("dir_facturacion2", respaldo.getDir_facturacion2())
                        .add("localidad", respaldo.getLocalidad())
                        .add("codigo_postal", respaldo.getCodigo_postal())
                        .add("telefono", respaldo.getTelefono())
                        .add("id_login", respaldo.getId_login()) // INICIA LOGIN
                        .add("usuario", respaldo.getUsuario())
                        .add("pw_usuario", respaldo.getPw_usuario())
                        .add("correo_electronico", respaldo.getCorreo_electronico())
                        .add("id_metodo_pago", respaldo.getId_metodo_pago()) // INICIA METODO_PAGO
                        .add("nombre_metodo_pago", respaldo.getNombre_metodo_pago())
                        .add("id_orden", respaldo.getId_orden()) // INICIA ORDEN
                        .add("id_info_pagoOrden", respaldo.getId_info_pagoOrden())
                        .add("id_metodo_pagoOrden", respaldo.getId_metodo_pagoOrden())
                        .add("id_usuarioOrden", respaldo.getId_usuarioOrden())
                        .add("fec_orden", fecha2)
                        .add("monto_total", respaldo.getMonto_total())
                        .add("id_producto", respaldo.getId_producto()) // INICIA PRODUCTO */
                    /*  .add("genero", respaldo.getGenero())
                        .add("talla", respaldo.getTalla())
                        .add("cantidadProducto", respaldo.getCantidadProducto())
                        .add("id_entregaProducto", respaldo.getId_entregaProducto())
                        .add("id_tipoproductoProducto", respaldo.getId_tipoproductoProducto())
                        .add("id_proveedor", respaldo.getId_proveedor()) // INICIA PROVEEDOR
                        .add("nombre_proveedor", respaldo.getNombre_proveedor())
                        .add("ced_juridica", respaldo.getCed_juridica())
                        .add("fec_afiliacion", fecha3)
                        .add("id_sucursalProveedor", respaldo.getId_sucursalProveedor())
                        .add("id_rol", respaldo.getId_rol()) // INICIA ROL
                        .add("rol", respaldo.getRol())
                        .add("id_sucursal", respaldo.getId_sucursal()) // INICIA SUCURSAL
                        .add("localidad_sucursal", respaldo.getLocalidad_sucursal())
                        .add("id_tipoproducto", respaldo.getId_tipoproducto()) // INICIA TIPO_PRODUCTO
                        .add("tipo", respaldo.getTipo()) */
                    /*  .add("id_rolUsuario", respaldo.getId_rolUsuario())
                        .add("id_loginUsuario", respaldo.getId_loginUsuario())  */
