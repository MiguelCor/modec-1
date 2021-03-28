package controller;

import gestion.ProductoGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Producto;

/**
 *
 * @author Grupo 7
 */
@Named(value = "productoController")
@SessionScoped
public class ProductoController extends Producto implements Serializable {

    public ProductoController() {
    }

    public List<Producto> getProductos(int tipoProducto) {
        return ProductoGestion.getProductos(tipoProducto);
    }

    //Metodo encargado de mostrar un unico producto
    public String detallesProducto(int id_producto) {
        Producto p = ProductoGestion.getProducto(id_producto);
        if (p != null) {
            this.setId_producto(p.getId_producto());
            this.setNombre_producto(p.getNombre_producto());
            this.setDescripcion(p.getDescripcion());
            this.setUrlImagen(p.getUrlImagen());
            this.setPrecio(p.getPrecio());
            this.setGenero(p.getGenero());
            this.setTalla(p.getTalla());
            this.setCantidad(p.getCantidad());
            return "DetallesProducto.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente el registro no exista");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "Principal.xhtml";
        }
    }
    

} // Fin Clase ProductoController
