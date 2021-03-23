package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Usuario;

/**
 *
 * @author Grupo 7
 */
public class UsuarioGestion {

    private static final String SQL_GETUSUARIO = "select usuario.id_usuario, usuario.nombre_usuario, usuario.apellido, usuario.apellido2, usuario.id_rol from usuario inner join login on usuario.id_login = login.id_login where (login.usuario=? or login.correo_electronico=?) and login.pw_usuario=md5(?)";

    public static Usuario getUsuario(String nUsuario, String correoUsuario, String pwUsuario) {
        Usuario usuario = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_GETUSUARIO);
            sentencia.setString(1, nUsuario);
            sentencia.setString(2, correoUsuario);
            sentencia.setString(3, pwUsuario);
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId_usuario(rs.getInt(1));
                usuario.setNombre_usuario(rs.getString(2)); 
                usuario.setApellido(rs.getString(3)); 
                usuario.setApellido2(rs.getString(4));
                usuario.setId_rol(rs.getString(5)); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

} // Fin Clase UsuarioGestion
