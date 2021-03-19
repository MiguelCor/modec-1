package controller;

import gestion.CamisasHombreGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import model.CamisasHombre;

/**
 *
 * @author maria
 */
@Named(value = "camisasHombreController")
@SessionScoped
public class CamisasHombreController implements Serializable {

    /**
     * Creates a new instance of CamisasHombreController
     */
    public CamisasHombreController() {
    }
    
    public List<CamisasHombre> getProductos() {
        return CamisasHombreGestion.getProductos();
    }
    
}
