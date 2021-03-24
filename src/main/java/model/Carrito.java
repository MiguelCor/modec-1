package model;

/**
 *
 * @author Grupo 7
 */
public class Carrito {
    
    // Atributos
    private String nombre_producto;
    private float precio;
    private String urlImagen;
    private int id_carrito;
    private int id_usuario;
    private int id_producto;
    private int cantidad;

    // Constructores
    public Carrito() {}

    // Lista
    public Carrito(String nombre_producto, float precio, String urlImagen, int id_carrito, int id_usuario, int cantidad) {
        this.nombre_producto = nombre_producto;
        this.precio = precio;
        this.urlImagen = urlImagen;
        this.id_carrito = id_carrito;
        this.id_usuario = id_usuario;
        this.cantidad = cantidad;
    }
    
    // Insertar
    public Carrito(int id_carrito, int id_usuario, int id_producto, int cantidad) {
        this.id_carrito = id_carrito;
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }

    // Getters & Setters
    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public int getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
} // Fin Clase Carrito
