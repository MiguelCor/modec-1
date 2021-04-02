package controller;

import gestion.CarritoGestion;
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

    public CarritoController() {
    }

    // Metodo que devuelve la lista de articulos dentro del carrito
    public List<Carrito> getCarrito(int id_usuario) {
        return CarritoGestion.getCarrito(id_usuario);
    }

    // Metodo que inserta un producto dentro del carrito
    public String insertCarrito(int id_usuario, int id_producto, int cantidad) {
        if (CarritoGestion.insertCarrito(id_usuario, id_producto, cantidad)) {
            return "cliente/carrito/Carrito.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrio un error al insertar el producto");
            FacesContext.getCurrentInstance().addMessage("catalogo:mensaje", msg);
            return "Principal.xhtml";
        }
    }

    // Metodo que borra un producto dentro del carrito AJAX
    public void deleteCarrito(int id_carrito) {
        if (CarritoGestion.deleteCarrito(id_carrito)) {
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrio un error al insertar el producto");
            FacesContext.getCurrentInstance().addMessage("carrito:msj", msg);
        }
    }

    // Devuelve la cantidad de articulos en el carrito, esta en el menu principal
    public int countCarrito(int id_usuario) {
        return CarritoGestion.countCarrito(id_usuario);
    }

} // Fin CDI BEAN CarritoController
