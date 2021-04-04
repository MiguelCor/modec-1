package model;

/**
 *
 * @author Grupo 7
 */
public class Grafico {
    
    // Atributos
    private String nombre_articulo;
    private int total;

    // Constructores
    public Grafico() {}

    public Grafico(String nombre_articulo, int total) {
        this.nombre_articulo = nombre_articulo;
        this.total = total;
    }

    // Getters & Setters
    public String getNombre_articulo() {
        return nombre_articulo;
    }

    public void setNombre_articulo(String nombre_articulo) {
        this.nombre_articulo = nombre_articulo;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
     
} // Fin Clase Grafico
