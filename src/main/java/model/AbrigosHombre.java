package model;

import java.io.InputStream;
import java.sql.Blob;

/**
 *
 * @author Grupo 7
 */
public class AbrigosHombre {

    // Atributos
    private int id_producto;
    private String nombre_producto;
    private String descripcion;
    private InputStream imagen;
    private float precio;
    private char genero;
    private String talla;
    private int cantidad;
    private int id_entrega;
    private int id_tipoproducto;

    // Constructores
    public AbrigosHombre() {}

    public AbrigosHombre(int id_producto, String nombre_producto, String descripcion, InputStream imagen, float precio, char genero, String talla, int cantidad, int id_entrega, int id_tipoproducto) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.genero = genero;
        this.talla = talla;
        this.cantidad = cantidad;
        this.id_entrega = id_entrega;
        this.id_tipoproducto = id_tipoproducto;
    }
    
    // Getters & Setters
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

    public InputStream getImagen() {
        return imagen;
    }

    public void setImagen(InputStream imagen) {
        this.imagen = imagen;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_entrega() {
        return id_entrega;
    }

    public void setId_entrega(int id_entrega) {
        this.id_entrega = id_entrega;
    }

    public int getId_tipoproducto() {
        return id_tipoproducto;
    }

    public void setId_tipoproducto(int id_tipoproducto) {
        this.id_tipoproducto = id_tipoproducto;
    }
    
} // Fin Clase Producto
