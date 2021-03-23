package model;
/**
 *
 * @author Grupo 7
 */
public class Usuario {
    
    // Atributos
    private int id_usuario;
    private String nUsuario;
    private String pw_usuario;
    private String correo_usuario;
    private String nombre_usuario;
    private String apellido;
    private String apellido2;
    private String id_rol;

    // Constructores
    public Usuario() {}

    public Usuario(int id_usuario, String nUsuario, String pw_usuario, String correo_usuario, String nombre_usuario, String apellido, String apellido2, String id_rol) {
        this.id_usuario = id_usuario;
        this.nUsuario = nUsuario;
        this.pw_usuario = pw_usuario;
        this.correo_usuario = correo_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.id_rol = id_rol;
    }
    
    // Getters & Setters
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getnUsuario() {
        return nUsuario;
    }

    public void setnUsuario(String nUsuario) {
        this.nUsuario = nUsuario;
    }

    public String getPw_usuario() {
        return pw_usuario;
    }

    public void setPw_usuario(String pw_usuario) {
        this.pw_usuario = pw_usuario;
    }

    public String getCorreo_usuario() {
        return correo_usuario;
    }

    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
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

    public String getId_rol() {
        return id_rol;
    }

    public void setId_rol(String id_rol) {
        this.id_rol = id_rol;
    }
 
} // Fin Clase Usuario
