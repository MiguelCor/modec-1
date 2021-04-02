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

    // Atributos Detalle_Orden
    private int id_detalle_orden;
    private int id_productoDetalle; // FK
    private int id_ordenDetalle; // FK
    private int cantidadDetalle;
    private float precioDetalle;
    
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
    private String nombre_producto;
    private String descripcion;
    private String urlImagen;
    private float precio; 
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
    private int id_usuario;
    private String nombre_usuario;
    private String apellido;
    private String apellido2; 
    private int id_rolUsuario; // FK
    private int id_loginUsuario; // FK 
     
    // Constructores
    public Respaldo() {}

    // Constructor Carrito
    public Respaldo(int id_carrito, int id_usuarioCarrito, int id_productoCarrito, int cantidadCarrito) {
        this.id_carrito = id_carrito;
        this.id_usuarioCarrito = id_usuarioCarrito;
        this.id_productoCarrito = id_productoCarrito;
        this.cantidadCarrito = cantidadCarrito;
    }

    // Constructor Detalle_Orden
    public Respaldo(int id_detalle_orden, int id_productoDetalle, int id_ordenDetalle, int cantidadDetalle, float precioDetalle) {
        this.id_detalle_orden = id_detalle_orden;
        this.id_productoDetalle = id_productoDetalle;
        this.id_ordenDetalle = id_ordenDetalle;
        this.cantidadDetalle = cantidadDetalle;
        this.precioDetalle = precioDetalle;
    }

    // Constructor Entrega
    public Respaldo(int id_entrega, String descipcion_entrega, Date fec_entrega, int id_proveedorEntrega) {
        this.id_entrega = id_entrega;
        this.descipcion_entrega = descipcion_entrega;
        this.fec_entrega = fec_entrega;
        this.id_proveedorEntrega = id_proveedorEntrega;
    }

    // Constructor Info_Pago
    public Respaldo(int id_info_pago, String num_tarjeta, String dir_facturacion, String dir_facturacion2, String localidad, String codigo_postal, String telefono) {
        this.id_info_pago = id_info_pago;
        this.num_tarjeta = num_tarjeta;
        this.dir_facturacion = dir_facturacion;
        this.dir_facturacion2 = dir_facturacion2;
        this.localidad = localidad;
        this.codigo_postal = codigo_postal;
        this.telefono = telefono;
    }

    // Constructor Login
    public Respaldo(int id_login, String usuario, String pw_usuario, String correo_electronico) {
        this.id_login = id_login;
        this.usuario = usuario;
        this.pw_usuario = pw_usuario;
        this.correo_electronico = correo_electronico;
    }

    // Constructor Metodo_Pago
    public Respaldo(int id_metodo_pago, String nombre_metodo_pago, int id_orden) {
        this.id_metodo_pago = id_metodo_pago;
        this.nombre_metodo_pago = nombre_metodo_pago;
    } 

    // Constructor Orden
    public Respaldo(int id_orden, int id_info_pagoOrden, int id_metodo_pagoOrden, int id_usuarioOrden, Date fec_orden, float monto_total) {
        this.id_orden = id_orden;
        this.id_info_pagoOrden = id_info_pagoOrden;
        this.id_metodo_pagoOrden = id_metodo_pagoOrden;
        this.id_usuarioOrden = id_usuarioOrden;
        this.fec_orden = fec_orden;
        this.monto_total = monto_total;
    }

    // Constructor Producto
    public Respaldo(int id_producto, String nombre_producto, String descripcion, String urlImagen, float precio, char genero, String talla, int cantidadProducto, int id_entregaProducto, int id_tipoproductoProducto) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.precio = precio;
        this.genero = genero;
        this.talla = talla;
        this.cantidadProducto = cantidadProducto;
        this.id_entregaProducto = id_entregaProducto;
        this.id_tipoproductoProducto = id_tipoproductoProducto;
    }

    // Constructor Proveedor
    public Respaldo(int id_proveedor, String nombre_proveedor, String ced_juridica, Date fec_afiliacion, int id_sucursalProveedor) {
        this.id_proveedor = id_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.ced_juridica = ced_juridica;
        this.fec_afiliacion = fec_afiliacion;
        this.id_sucursalProveedor = id_sucursalProveedor;
    }

    // Constructor Rol
    public Respaldo(int id_usuario, int id_rol, String rol) {
        this.id_rol = id_rol;
        this.rol = rol;
    }

    // Constructor Sucursal
    public Respaldo(int id_proveedor, int id_rolUsuario, int id_sucursal, String localidad_sucursal) {
        this.id_sucursal = id_sucursal;
        this.localidad_sucursal = localidad_sucursal;
    } 

    // Constructor Tipo_Producto
    public Respaldo(int id_tipoproducto, String tipo) {
        this.id_tipoproducto = id_tipoproducto;
        this.tipo = tipo;
    }

    // Constructor Usuario
    public Respaldo(int id_usuario, String nombre_usuario, String apellido, String apellido2, int id_rolUsuario, int id_loginUsuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.id_rolUsuario = id_rolUsuario;
        this.id_loginUsuario = id_loginUsuario;
    }
    
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

    public int getId_detalle_orden() {
        return id_detalle_orden;
    }

    public void setId_detalle_orden(int id_detalle_orden) {
        this.id_detalle_orden = id_detalle_orden;
    }

    public int getId_productoDetalle() {
        return id_productoDetalle;
    }

    public void setId_productoDetalle(int id_productoDetalle) {
        this.id_productoDetalle = id_productoDetalle;
    }

    public int getId_ordenDetalle() {
        return id_ordenDetalle;
    }

    public void setId_ordenDetalle(int id_ordenDetalle) {
        this.id_ordenDetalle = id_ordenDetalle;
    }

    public int getCantidadDetalle() {
        return cantidadDetalle;
    }

    public void setCantidadDetalle(int cantidadDetalle) {
        this.cantidadDetalle = cantidadDetalle;
    }

    public float getPrecioDetalle() {
        return precioDetalle;
    }

    public void setPrecioDetalle(float precioDetalle) {
        this.precioDetalle = precioDetalle;
    }

    public int getId_entrega() {
        return id_entrega;
    }

    public void setId_entrega(int id_entrega) {
        this.id_entrega = id_entrega;
    }

    public String getDescipcion_entrega() {
        return descipcion_entrega;
    }

    public void setDescipcion_entrega(String descipcion_entrega) {
        this.descipcion_entrega = descipcion_entrega;
    }

    public Date getFec_entrega() {
        return fec_entrega;
    }

    public void setFec_entrega(Date fec_entrega) {
        this.fec_entrega = fec_entrega;
    }

    public int getId_proveedorEntrega() {
        return id_proveedorEntrega;
    }

    public void setId_proveedorEntrega(int id_proveedorEntrega) {
        this.id_proveedorEntrega = id_proveedorEntrega;
    }

    public int getId_info_pago() {
        return id_info_pago;
    }

    public void setId_info_pago(int id_info_pago) {
        this.id_info_pago = id_info_pago;
    }

    public String getNum_tarjeta() {
        return num_tarjeta;
    }

    public void setNum_tarjeta(String num_tarjeta) {
        this.num_tarjeta = num_tarjeta;
    }

    public String getDir_facturacion() {
        return dir_facturacion;
    }

    public void setDir_facturacion(String dir_facturacion) {
        this.dir_facturacion = dir_facturacion;
    }

    public String getDir_facturacion2() {
        return dir_facturacion2;
    }

    public void setDir_facturacion2(String dir_facturacion2) {
        this.dir_facturacion2 = dir_facturacion2;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPw_usuario() {
        return pw_usuario;
    }

    public void setPw_usuario(String pw_usuario) {
        this.pw_usuario = pw_usuario;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public int getId_metodo_pago() {
        return id_metodo_pago;
    }

    public void setId_metodo_pago(int id_metodo_pago) {
        this.id_metodo_pago = id_metodo_pago;
    }

    public String getNombre_metodo_pago() {
        return nombre_metodo_pago;
    }

    public void setNombre_metodo_pago(String nombre_metodo_pago) {
        this.nombre_metodo_pago = nombre_metodo_pago;
    }

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public int getId_info_pagoOrden() {
        return id_info_pagoOrden;
    }

    public void setId_info_pagoOrden(int id_info_pagoOrden) {
        this.id_info_pagoOrden = id_info_pagoOrden;
    }

    public int getId_metodo_pagoOrden() {
        return id_metodo_pagoOrden;
    }

    public void setId_metodo_pagoOrden(int id_metodo_pagoOrden) {
        this.id_metodo_pagoOrden = id_metodo_pagoOrden;
    }

    public int getId_usuarioOrden() {
        return id_usuarioOrden;
    }

    public void setId_usuarioOrden(int id_usuarioOrden) {
        this.id_usuarioOrden = id_usuarioOrden;
    }

    public Date getFec_orden() {
        return fec_orden;
    }

    public void setFec_orden(Date fec_orden) {
        this.fec_orden = fec_orden;
    }

    public float getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(float monto_total) {
        this.monto_total = monto_total;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
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

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getId_entregaProducto() {
        return id_entregaProducto;
    }

    public void setId_entregaProducto(int id_entregaProducto) {
        this.id_entregaProducto = id_entregaProducto;
    }

    public int getId_tipoproductoProducto() {
        return id_tipoproductoProducto;
    }

    public void setId_tipoproductoProducto(int id_tipoproductoProducto) {
        this.id_tipoproductoProducto = id_tipoproductoProducto;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getCed_juridica() {
        return ced_juridica;
    }

    public void setCed_juridica(String ced_juridica) {
        this.ced_juridica = ced_juridica;
    }

    public Date getFec_afiliacion() {
        return fec_afiliacion;
    }

    public void setFec_afiliacion(Date fec_afiliacion) {
        this.fec_afiliacion = fec_afiliacion;
    }

    public int getId_sucursalProveedor() {
        return id_sucursalProveedor;
    }

    public void setId_sucursalProveedor(int id_sucursalProveedor) {
        this.id_sucursalProveedor = id_sucursalProveedor;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getLocalidad_sucursal() {
        return localidad_sucursal;
    }

    public void setLocalidad_sucursal(String localidad_sucursal) {
        this.localidad_sucursal = localidad_sucursal;
    }

    public int getId_tipoproducto() {
        return id_tipoproducto;
    }

    public void setId_tipoproducto(int id_tipoproducto) {
        this.id_tipoproducto = id_tipoproducto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public int getId_rolUsuario() {
        return id_rolUsuario;
    }

    public void setId_rolUsuario(int id_rolUsuario) {
        this.id_rolUsuario = id_rolUsuario;
    }

    public int getId_loginUsuario() {
        return id_loginUsuario;
    }

    public void setId_loginUsuario(int id_loginUsuario) {
        this.id_loginUsuario = id_loginUsuario;
    }

} // Fin Clase Respaldo
