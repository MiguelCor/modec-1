package model;

import java.sql.Date;

/**
 *
 * @author Grupo 7
 */
public class Respaldo {

    // Atributos Carrito
    private int id_carrito;
    private int id_usuarioCarrito; // FK
    private int id_productoCarrito; // FK
    private int cantidadCarrito;

    /*
    // Atributos Detalle_Orden
    private int id_detalle_orden;
    private int id_productoDetalle; // FK
    private int id_ordenDetalle; // FK
    private int cantidadDetalle;
    
    // Atributos Entrega
    private int id_entrega;
    private String descipcion_entrega;
    private Date fec_entrega;
    private int id_proveedorEntrega; // FK
    
    // Atributos Info_Pago
    private int id_info_pago;
    private String num_tarjeta;
    private String dir_facturacion;
    private String dir_facturacion2;
    private String localidad;
    private String codigo_postal;
    private String telefono;
    
    // Atributos Login
    private int id_login;
    private String usuario;
    private String pw_usuario;
    private String correo_electronico;
    
    // Atributos Metodo_Pago
    private int id_metodo_pago;
    private String nombre_metodo_pago;
    
    // Atributos Orden
    private int id_orden;
    private int id_info_pagoOrden; // FK
    private int id_metodo_pagoOrden; // FK
    private int id_usuarioOrden; // FK
    private Date fec_orden;
    private float monto_total;
    
    // Atributos Producto
    private int id_producto;
 */ private String nombre_producto;
    private String descripcion;
    private String urlImagen;
    private float precio; /*
    private char genero;
    private String talla;
    private int cantidadProducto;
    private int id_entregaProducto; // FK
    private int id_tipoproductoProducto; // FK
    
    // Atributos Proveedor
    private int id_proveedor;
    private String nombre_proveedor;
    private String ced_juridica;
    private Date fec_afiliacion;
    private int id_sucursalProveedor; // FK
    
    // Atributos Rol
    private int id_rol;
    private String rol;
    
    // Atributos Sucursal
    private int id_sucursal;
    private String localidad_sucursal;
    
    // Atributos Tipo_Producto
    private int id_tipoproducto;
    private String tipo;
    
    // Atributos Usuario
 */ private int id_usuario;
    private String nombre_usuario;
    private String apellido;
    private String apellido2; 
 /* private int id_rolUsuario; // FK
    private int id_loginUsuario; // FK */
     
    
    // Constructor - Ordenado segun atributos
    public Respaldo() {}

    public Respaldo(int id_carrito, int id_usuarioCarrito, int id_productoCarrito, int cantidadCarrito) {
        this.id_carrito = id_carrito;
        this.id_usuarioCarrito = id_usuarioCarrito;
        this.id_productoCarrito = id_productoCarrito;
        this.cantidadCarrito = cantidadCarrito;
    }

    public Respaldo(int id_carrito, int id_usuarioCarrito, int id_productoCarrito, int cantidadCarrito, String nombre_producto, String descripcion, String urlImagen, float precio) {
        this.id_carrito = id_carrito;
        this.id_usuarioCarrito = id_usuarioCarrito;
        this.id_productoCarrito = id_productoCarrito;
        this.cantidadCarrito = cantidadCarrito;
        this.nombre_producto = nombre_producto;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.precio = precio;
    }

    public Respaldo(int id_carrito, int id_usuarioCarrito, int id_productoCarrito, int cantidadCarrito, String nombre_producto, String descripcion, String urlImagen, float precio, int id_usuario, String nombre_usuario, String apellido, String apellido2) {
        this.id_carrito = id_carrito;
        this.id_usuarioCarrito = id_usuarioCarrito;
        this.id_productoCarrito = id_productoCarrito;
        this.cantidadCarrito = cantidadCarrito;
        this.nombre_producto = nombre_producto;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.precio = precio;
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido = apellido;
        this.apellido2 = apellido2;
    }

    /*
    public Respaldo(int id_carrito, int id_usuarioCarrito, int id_productoCarrito, int cantidadCarrito, int id_detalle_orden, int id_productoDetalle, int id_ordenDetalle, int cantidadDetalle, int id_entrega, String descipcion_entrega, Date fec_entrega, int id_proveedorEntrega, int id_info_pago, String num_tarjeta, String dir_facturacion, String dir_facturacion2, String localidad, String codigo_postal, String telefono, int id_login, String usuario, String pw_usuario, String correo_electronico, int id_metodo_pago, String nombre_metodo_pago, int id_orden, int id_info_pagoOrden, int id_metodo_pagoOrden, int id_usuarioOrden, Date fec_orden, float monto_total, int id_producto, String nombre_producto, String descripcion, String urlImagen, float precio, char genero, String talla, int cantidadProducto, int id_entregaProducto, int id_tipoproductoProducto, int id_proveedor, String nombre_proveedor, String ced_juridica, Date fec_afiliacion, int id_sucursalProveedor, int id_rol, String rol, int id_sucursal, String localidad_sucursal, int id_tipoproducto, String tipo, int id_usuario, String nombre_usuario, String apellido, String apellido2, int id_rolUsuario, int id_loginUsuario) {
        this.id_carrito = id_carrito;
        this.id_usuarioCarrito = id_usuarioCarrito;
        this.id_productoCarrito = id_productoCarrito;
        this.cantidadCarrito = cantidadCarrito; // Fin Carrito
        this.id_detalle_orden = id_detalle_orden;
        this.id_productoDetalle = id_productoDetalle;
        this.id_ordenDetalle = id_ordenDetalle;
        this.cantidadDetalle = cantidadDetalle; // Fin Detalle_Orden
        this.id_entrega = id_entrega;
        this.descipcion_entrega = descipcion_entrega;
        this.fec_entrega = fec_entrega;
        this.id_proveedorEntrega = id_proveedorEntrega; // Fin Entrega
        this.id_info_pago = id_info_pago;
        this.num_tarjeta = num_tarjeta;
        this.dir_facturacion = dir_facturacion;
        this.dir_facturacion2 = dir_facturacion2;
        this.localidad = localidad;
        this.codigo_postal = codigo_postal;
        this.telefono = telefono; // Fin Info_Pago
        this.id_login = id_login;
        this.usuario = usuario;
        this.pw_usuario = pw_usuario;
        this.correo_electronico = correo_electronico; // Fin Login
        this.id_metodo_pago = id_metodo_pago;
        this.nombre_metodo_pago = nombre_metodo_pago; // Fin Metodo_Pago
        this.id_orden = id_orden;
        this.id_info_pagoOrden = id_info_pagoOrden;
        this.id_metodo_pagoOrden = id_metodo_pagoOrden;
        this.id_usuarioOrden = id_usuarioOrden;
        this.fec_orden = fec_orden;
        this.monto_total = monto_total; // Fin Orden
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.precio = precio;
        this.genero = genero;
        this.talla = talla;
        this.cantidadProducto = cantidadProducto;
        this.id_entregaProducto = id_entregaProducto;
        this.id_tipoproductoProducto = id_tipoproductoProducto; // Fin Producto
        this.id_proveedor = id_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.ced_juridica = ced_juridica;
        this.fec_afiliacion = fec_afiliacion;
        this.id_sucursalProveedor = id_sucursalProveedor; // Fin Proveedor
        this.id_rol = id_rol;
        this.rol = rol; // Fin Rol
        this.id_sucursal = id_sucursal;
        this.localidad_sucursal = localidad_sucursal; // Fin Sucursal
        this.id_tipoproducto = id_tipoproducto;
        this.tipo = tipo; // Fin Tipo_Producto
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.id_rolUsuario = id_rolUsuario;
        this.id_loginUsuario = id_loginUsuario; // Fin Usuario
    }
     */
    
    // Getters & Setters
    public int getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }

    public int getId_usuarioCarrito() {
        return id_usuarioCarrito;
    }

    public void setId_usuarioCarrito(int id_usuarioCarrito) {
        this.id_usuarioCarrito = id_usuarioCarrito;
    }

    public int getId_productoCarrito() {
        return id_productoCarrito;
    }

    public void setId_productoCarrito(int id_productoCarrito) {
        this.id_productoCarrito = id_productoCarrito;
    }

    public int getCantidadCarrito() {
        return cantidadCarrito;
    }

    public void setCantidadCarrito(int cantidadCarrito) {
        this.cantidadCarrito = cantidadCarrito;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }   

} // Fin Clase Respaldo
