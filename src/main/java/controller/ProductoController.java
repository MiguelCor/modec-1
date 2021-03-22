package controller;

import gestion.ProductoGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import model.Producto;

/**
 *
 * @author Grupo 7
 */
@Named(value = "productoController")
@SessionScoped
public class ProductoController implements Serializable {


    public ProductoController() {
    }
    
    public List<Producto> getProductos(int tipoProducto) {
        return ProductoGestion.getProductos(tipoProducto);
    }
    
} // Fin Clase ProductoController
