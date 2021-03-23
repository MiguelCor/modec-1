package controller;

import gestion.CarritoGestion;
import gestion.ProductoGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Carrito;

/**
 *
 * @author Grupo 7
 */
@Named(value = "carritoController")
@SessionScoped
public class CarritoController extends Carrito implements Serializable {

    public CarritoController() {}
    
    public List<Carrito> getCarrito(int id_usuario) {
        return CarritoGestion.getCarrito(id_usuario);
    }
    
    public String insertCarrito(int id_usuario, int id_producto, int cantidad) {
        if (CarritoGestion.insertCarrito(id_usuario, id_producto, cantidad)) {
            return "Carrito.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Ocurrio un error al insertar el producto");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "Principal.xhtml";
        }
    }
    
} // Fin CDI BEAN CarritoController
