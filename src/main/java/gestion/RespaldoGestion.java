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

    private static final String SQL_RESPALDOCARRITO = "select * from carrito";
    private static final String SQL_RESPALDODETALLE = "select * from detalle_orden";
    private static final String SQL_RESPALDOENTREGA = "select * from entrega";
    private static final String SQL_RESPALDOINFOPAGO = "select * from info_pago";
    private static final String SQL_RESPALDOLOGIN = "select * from login";
    private static final String SQL_RESPALDOMETODOPAGO = "select * from metodo_pago";
    private static final String SQL_RESPALDOORDEN = "select * from orden";
    private static final String SQL_RESPALDOPRODUCTO = "select * from producto";
    private static final String SQL_RESPALDOPROVEEDOR = "select * from proveedor";
    private static final String SQL_RESPALDOROL = "select * from rol";
    private static final String SQL_RESPALDOSUCURSAL = "select * from sucursal";
    private static final String SQL_RESPALDOTIPOPRODUCTO = "select * from tipo_producto";
    private static final String SQL_RESPALDOUSUARIO = "select * from usuario";

    public static String generarJson() {
        Respaldo respaldo = null;
        String fecha1 = "";
        String fecha2 = "";
        String fecha3 = "";
        String tiraJson = "";
        try {
            
            // CARRITO JSON
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_RESPALDOCARRITO);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                respaldo = new Respaldo(
                        rs.getInt(1), // id_carrito 
                        rs.getInt(2), // id_usuarioCarrito 
                        rs.getInt(3), // id_productoCarrito 
                        rs.getInt(4) // cantidadCarrito
                );
                JsonObjectBuilder creadorJson = Json.createObjectBuilder();
                JsonObject objectJson = creadorJson.add("id_carrito", respaldo.getId_carrito()) 
                        .add("id_usuarioCarrito", respaldo.getId_usuarioCarrito())
                        .add("id_productoCarrito", respaldo.getId_productoCarrito())
                        .add("cantidadCarrito", respaldo.getCantidadCarrito())
                        .build();
                StringWriter tira = new StringWriter();
                JsonWriter jsonWriter = Json.createWriter(tira);
                jsonWriter.writeObject(objectJson);
                if (tiraJson == null) {
                    tiraJson = tira.toString() + "\n";
                } else {
                    tiraJson = tiraJson + tira.toString() + "\n";
                }
            } // FIN CARRITO JSON
            
            // DETALLE JSON
            PreparedStatement sentencia2 = Conexion.getConexion().prepareStatement(SQL_RESPALDODETALLE);
            ResultSet rs2 = sentencia2.executeQuery();
            while (rs2 != null && rs2.next()) {
                respaldo = new Respaldo(
                        rs2.getInt(1), // id_detalle_orden 
                        rs2.getInt(2), // id_productoDetalle 
                        rs2.getInt(3), // id_ordenDetalle 
                        rs2.getInt(4), // cantidadDatalle
                        rs2.getFloat(5) // precioDetalle
                );
                JsonObjectBuilder creadorJson = Json.createObjectBuilder();
                JsonObject objectJson = creadorJson.add("id_detalle_orden", respaldo.getId_detalle_orden()) 
                        .add("id_productoDetalle", respaldo.getId_productoDetalle())
                        .add("id_ordenDetalle", respaldo.getId_ordenDetalle())
                        .add("cantidadDatalle", respaldo.getCantidadDetalle())
                        .add("precioDetalle", respaldo.getPrecio())
                        .build();
                StringWriter tira = new StringWriter();
                JsonWriter jsonWriter = Json.createWriter(tira);
                jsonWriter.writeObject(objectJson);
                if (tiraJson == null) {
                    tiraJson = tira.toString() + "\n";
                } else {
                    tiraJson = tiraJson + tira.toString() + "\n";
                }
            } // FIN DETALLE JSON
            
            // ENTREGA JSON
            PreparedStatement sentencia3 = Conexion.getConexion().prepareStatement(SQL_RESPALDOENTREGA);
            ResultSet rs3 = sentencia3.executeQuery();
            while (rs3 != null && rs3.next()) {
                respaldo = new Respaldo(
                        rs3.getInt(1), // id_entrega 
                        rs3.getString(2), // descipcion_entrega 
                        rs3.getDate(3), // fec_entrega 
                        rs3.getInt(4) // id_proveedorEntrega
                );
                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                fecha1 = sdf.format(respaldo.getFec_entrega());
                JsonObjectBuilder creadorJson = Json.createObjectBuilder();
                JsonObject objectJson = creadorJson.add("id_entrega", respaldo.getId_entrega()) 
                        .add("descipcion_entrega", respaldo.getDescipcion_entrega())
                        .add("fec_entrega", fecha1)
                        .add("id_proveedorEntrega", respaldo.getId_proveedorEntrega())
                        .build();
                StringWriter tira = new StringWriter();
                JsonWriter jsonWriter = Json.createWriter(tira);
                jsonWriter.writeObject(objectJson);
                if (tiraJson == null) {
                    tiraJson = tira.toString() + "\n";
                } else {
                    tiraJson = tiraJson + tira.toString() + "\n";
                }
            } // FIN ENTREGA JSON
            
            // INFO_PAGO JSON
            PreparedStatement sentencia4 = Conexion.getConexion().prepareStatement(SQL_RESPALDOINFOPAGO);
            ResultSet rs4 = sentencia4.executeQuery();
            while (rs4 != null && rs4.next()) {
                respaldo = new Respaldo(
                        rs4.getInt(1), // id_info_pago 
                        rs4.getString(2), // num_tarjeta 
                        rs4.getString(3), // dir_facturacion 
                        rs4.getString(4), // dir_facturacion2
                        rs4.getString(5), // localidad
                        rs4.getString(6), // codigo_postal
                        rs4.getString(7) // telefono
                );
                JsonObjectBuilder creadorJson = Json.createObjectBuilder();
                JsonObject objectJson = creadorJson.add("id_info_pago", respaldo.getId_info_pago()) 
                        .add("num_tarjeta", respaldo.getNum_tarjeta())
                        .add("dir_facturacion", respaldo.getDir_facturacion())
                        .add("dir_facturacion2", respaldo.getDir_facturacion2())
                        .add("localidad", respaldo.getLocalidad())
                        .add("codigo_postal", respaldo.getCodigo_postal())
                        .add("telefono", respaldo.getTelefono())
                        .build();
                StringWriter tira = new StringWriter();
                JsonWriter jsonWriter = Json.createWriter(tira);
                jsonWriter.writeObject(objectJson);
                if (tiraJson == null) {
                    tiraJson = tira.toString() + "\n";
                } else {
                    tiraJson = tiraJson + tira.toString() + "\n";
                }
            } // FIN INFO_PAGO JSON
            
            // LOGIN JSON
            PreparedStatement sentencia5 = Conexion.getConexion().prepareStatement(SQL_RESPALDOLOGIN);
            ResultSet rs5 = sentencia5.executeQuery();
            while (rs5 != null && rs5.next()) {
                respaldo = new Respaldo(
                        rs5.getInt(1), // id_login 
                        rs5.getString(2), // usuario 
                        rs5.getString(3), // pw_usuario 
                        rs5.getString(4) // correo_electronico
                );
                JsonObjectBuilder creadorJson = Json.createObjectBuilder();
                JsonObject objectJson = creadorJson.add("id_login", respaldo.getId_login()) 
                        .add("usuario", respaldo.getUsuario())
                        .add("pw_usuario", respaldo.getPw_usuario())
                        .add("correo_electronico", respaldo.getCorreo_electronico())
                        .build();
                StringWriter tira = new StringWriter();
                JsonWriter jsonWriter = Json.createWriter(tira);
                jsonWriter.writeObject(objectJson);
                if (tiraJson == null) {
                    tiraJson = tira.toString() + "\n";
                } else {
                    tiraJson = tiraJson + tira.toString() + "\n";
                }
            } // FIN LOGIN JSON
            
            // METODO_PAGO JSON
            PreparedStatement sentencia6 = Conexion.getConexion().prepareStatement(SQL_RESPALDOMETODOPAGO);
            ResultSet rs6 = sentencia6.executeQuery();
            while (rs6 != null && rs6.next()) {
                respaldo = new Respaldo(
                        rs6.getInt(1), // id_metodo_pago 
                        rs6.getString(2), // nombre_metodo_pago 
                        rs6.getInt(3) // null
                );
                JsonObjectBuilder creadorJson = Json.createObjectBuilder();
                JsonObject objectJson = creadorJson.add("id_metodo_pago", respaldo.getId_metodo_pago()) 
                        .add("nombre_metodo_pago", respaldo.getNombre_metodo_pago())
                        .build();
                StringWriter tira = new StringWriter();
                JsonWriter jsonWriter = Json.createWriter(tira);
                jsonWriter.writeObject(objectJson);
                if (tiraJson == null) {
                    tiraJson = tira.toString() + "\n";
                } else {
                    tiraJson = tiraJson + tira.toString() + "\n";
                }
            } // FIN METODO_PAGO JSON
            
            // ORDEN JSON
            PreparedStatement sentencia7 = Conexion.getConexion().prepareStatement(SQL_RESPALDOORDEN);
            ResultSet rs7 = sentencia7.executeQuery();
            while (rs7 != null && rs7.next()) {
                respaldo = new Respaldo(
                        rs7.getInt(1), // id_orden 
                        rs7.getInt(2), // id_info_pagoOrden 
                        rs7.getInt(3), // id_metodo_pagoOrden 
                        rs7.getInt(4), // id_usuarioOrden 
                        rs7.getDate(5), // fec_orden 
                        rs7.getFloat(6) // monto_total 
                );
                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                fecha2 = sdf.format(respaldo.getFec_orden());
                JsonObjectBuilder creadorJson = Json.createObjectBuilder();
                JsonObject objectJson = creadorJson.add("id_orden", respaldo.getId_orden()) 
                        .add("id_info_pagoOrden", respaldo.getId_info_pagoOrden())
                        .add("id_metodo_pagoOrden", respaldo.getId_metodo_pagoOrden())
                        .add("id_usuarioOrden", respaldo.getId_usuarioOrden())
                        .add("fec_orden", fecha2)
                        .add("monto_total", respaldo.getMonto_total())
                        .build();
                StringWriter tira = new StringWriter();
                JsonWriter jsonWriter = Json.createWriter(tira);
                jsonWriter.writeObject(objectJson);
                if (tiraJson == null) {
                    tiraJson = tira.toString() + "\n";
                } else {
                    tiraJson = tiraJson + tira.toString() + "\n";
                }
            } // FIN ORDEN JSON
            
            // PRODUCTO JSON
            PreparedStatement sentencia8 = Conexion.getConexion().prepareStatement(SQL_RESPALDOPRODUCTO);
            ResultSet rs8 = sentencia8.executeQuery();
            while (rs8 != null && rs8.next()) {
                respaldo = new Respaldo(
                        rs8.getInt(1), // id_producto 
                        rs8.getString(2), // nombre_producto 
                        rs8.getString(3), // descripcion 
                        rs8.getString(4), // urlImagen 
                        rs8.getFloat(5), // precio 
                        rs8.getString(6).charAt(0), // genero 
                        rs8.getString(7), // talla 
                        rs8.getInt(8), // cantidadProducto 
                        rs8.getInt(9), // id_entregaProducto 
                        rs8.getInt(10) // id_tipoproductoProducto 
                );
                JsonObjectBuilder creadorJson = Json.createObjectBuilder();
                JsonObject objectJson = creadorJson.add("id_producto", respaldo.getId_producto()) 
                        .add("nombre_producto", respaldo.getNombre_producto())
                        .add("descripcion", respaldo.getDescripcion())
                        .add("urlImagen", respaldo.getUrlImagen())
                        .add("precio", respaldo.getPrecio())
                        .add("genero", respaldo.getGenero())
                        .add("talla", respaldo.getTalla())
                        .add("cantidadProducto", respaldo.getCantidadProducto())
                        .add("id_entregaProducto", respaldo.getId_entregaProducto())
                        .add("id_tipoproductoProducto", respaldo.getId_tipoproductoProducto())
                        .build();
                StringWriter tira = new StringWriter();
                JsonWriter jsonWriter = Json.createWriter(tira);
                jsonWriter.writeObject(objectJson);
                if (tiraJson == null) {
                    tiraJson = tira.toString() + "\n";
                } else {
                    tiraJson = tiraJson + tira.toString() + "\n";
                }
            } // FIN PRODUCTO JSON
            
            // PROVEEDOR JSON
            PreparedStatement sentencia9 = Conexion.getConexion().prepareStatement(SQL_RESPALDOPROVEEDOR);
            ResultSet rs9 = sentencia9.executeQuery();
            while (rs9 != null && rs9.next()) {
                respaldo = new Respaldo(
                        rs9.getInt(1), // id_proveedor 
                        rs9.getString(2), // nombre_proveedor 
                        rs9.getString(3), // ced_juridica 
                        rs9.getDate(4), // fec_afiliacion 
                        rs9.getInt(5) // id_sucursalProveedor 
                );
                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                fecha3 = sdf.format(respaldo.getFec_afiliacion());
                JsonObjectBuilder creadorJson = Json.createObjectBuilder();
                JsonObject objectJson = creadorJson.add("id_proveedor", respaldo.getId_proveedor()) 
                        .add("nombre_proveedor", respaldo.getNombre_proveedor())
                        .add("ced_juridica", respaldo.getCed_juridica())
                        .add("fec_afiliacion", fecha3)
                        .add("id_sucursalProveedor", respaldo.getId_sucursalProveedor())
                        .build();
                StringWriter tira = new StringWriter();
                JsonWriter jsonWriter = Json.createWriter(tira);
                jsonWriter.writeObject(objectJson);
                if (tiraJson == null) {
                    tiraJson = tira.toString() + "\n";
                } else {
                    tiraJson = tiraJson + tira.toString() + "\n";
                }
            } // FIN PROVEEDOR JSON
            
            // ROL JSON
            PreparedStatement sentencia10 = Conexion.getConexion().prepareStatement(SQL_RESPALDOROL);
            ResultSet rs10 = sentencia10.executeQuery();
            while (rs10 != null && rs10.next()) {
                respaldo = new Respaldo(
                        rs10.getInt(1), // null
                        rs10.getInt(1), // id_rol 
                        rs10.getString(2) // rol 
                );
                JsonObjectBuilder creadorJson = Json.createObjectBuilder();
                JsonObject objectJson = creadorJson.add("id_rol", respaldo.getId_rol()) 
                        .add("rol", respaldo.getRol())
                        .build();
                StringWriter tira = new StringWriter();
                JsonWriter jsonWriter = Json.createWriter(tira);
                jsonWriter.writeObject(objectJson);
                if (tiraJson == null) {
                    tiraJson = tira.toString() + "\n";
                } else {
                    tiraJson = tiraJson + tira.toString() + "\n";
                }
            } // FIN ROL JSON
            
            // SUCURSAL JSON
            PreparedStatement sentencia11 = Conexion.getConexion().prepareStatement(SQL_RESPALDOSUCURSAL);
            ResultSet rs11 = sentencia11.executeQuery();
            while (rs11 != null && rs11.next()) {
                respaldo = new Respaldo(
                        rs11.getInt(1), // null
                        rs11.getInt(1), // null
                        rs11.getInt(1), // id_sucursal 
                        rs11.getString(2) // localidad_sucursal    
                );
                JsonObjectBuilder creadorJson = Json.createObjectBuilder();
                JsonObject objectJson = creadorJson.add("id_sucursal", respaldo.getId_sucursal()) 
                        .add("localidad_sucursal", respaldo.getLocalidad_sucursal())
                        .build();
                StringWriter tira = new StringWriter();
                JsonWriter jsonWriter = Json.createWriter(tira);
                jsonWriter.writeObject(objectJson);
                if (tiraJson == null) {
                    tiraJson = tira.toString() + "\n";
                } else {
                    tiraJson = tiraJson + tira.toString() + "\n";
                }
            } // FIN SUCURSAL JSON 
            
            // TIPO_PRODUCTO JSON
            PreparedStatement sentencia12 = Conexion.getConexion().prepareStatement(SQL_RESPALDOTIPOPRODUCTO);
            ResultSet rs12 = sentencia12.executeQuery();
            while (rs12 != null && rs12.next()) {
                respaldo = new Respaldo(
                        rs12.getInt(1), // id_tipoproducto 
                        rs12.getString(2) // tipo 
                );
                JsonObjectBuilder creadorJson = Json.createObjectBuilder();
                JsonObject objectJson = creadorJson.add("id_tipoproducto", respaldo.getId_tipoproducto()) 
                        .add("tipo", respaldo.getTipo())
                        .build();
                StringWriter tira = new StringWriter();
                JsonWriter jsonWriter = Json.createWriter(tira);
                jsonWriter.writeObject(objectJson);
                if (tiraJson == null) {
                    tiraJson = tira.toString() + "\n";
                } else {
                    tiraJson = tiraJson + tira.toString() + "\n";
                }
            } // FIN TIPO_PRODUCTO JSON 
            
            // USUARIO JSON
            PreparedStatement sentencia13 = Conexion.getConexion().prepareStatement(SQL_RESPALDOUSUARIO);
            ResultSet rs13 = sentencia13.executeQuery();
            while (rs13 != null && rs13.next()) {
                respaldo = new Respaldo(
                        rs13.getInt(1), // id_usuario 
                        rs13.getString(2), // nombre_usuario
                        rs13.getString(3), // apellido 
                        rs13.getString(4), // apellido2
                        rs13.getInt(5), // id_rolUsuario 
                        rs13.getInt(6) // id_loginUsuario
                );
                JsonObjectBuilder creadorJson = Json.createObjectBuilder();
                JsonObject objectJson = creadorJson.add("id_usuario", respaldo.getId_usuario()) 
                        .add("nombre_usuario", respaldo.getNombre_usuario())
                        .add("apellido", respaldo.getApellido())
                        .add("apellido2", respaldo.getApellido2())
                        .add("id_rolUsuario", respaldo.getId_rolUsuario())
                        .add("id_loginUsuario", respaldo.getId_loginUsuario())
                        .build();
                StringWriter tira = new StringWriter();
                JsonWriter jsonWriter = Json.createWriter(tira);
                jsonWriter.writeObject(objectJson);
                if (tiraJson == null) {
                    tiraJson = tira.toString() + "\n";
                } else {
                    tiraJson = tiraJson + tira.toString() + "\n";
                }
            } // FIN USUARIO JSON */
            
        } catch (SQLException ex) {
            Logger.getLogger(RespaldoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tiraJson;
    }

} // Fin Clase RespaldoGestion