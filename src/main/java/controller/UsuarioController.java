package controller;

import gestion.UsuarioGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Usuario;

/**
 *
 * @author Grupo 7
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController extends Usuario implements Serializable {

    public UsuarioController() {}

    public String getUsuario() {
        Usuario usuario = UsuarioGestion.getUsuario(this.getnUsuario(), this.getCorreo_usuario(), this.getPw_usuario());
        if (usuario != null) {
            this.setId_usuario(usuario.getId_usuario());
            this.setNombre_usuario(usuario.getNombre_usuario());
            this.setApellido(usuario.getApellido());
            this.setApellido2(usuario.getApellido2());
            this.setId_rol(usuario.getId_rol());
            return "Principal.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario o contraseña invalida");
            FacesContext.getCurrentInstance().addMessage("loginForm:clave", msg);
            return "Login.xhtml";
        }
    }

} // Fin Clase UsuarioController
