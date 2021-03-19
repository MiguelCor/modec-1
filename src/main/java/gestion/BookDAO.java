/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import model.Book;
import model.Conexion;

/**
 *
 * @author maria
 */
public class BookDAO {

    private static final String SQL_GETIMAGEN = "SELECT * FROM producto where id_producto=?";
    private static final String SQL_GETIMAGENES = "SELECT imagen FROM producto";

    public static Book get(int id) throws SQLException, IOException {
        Book book = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_GETIMAGEN);
            sentencia.setInt(1, id);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {

                book = new Book();
                String title = rs.getString("nombre_producto");
                String author = rs.getString("descripcion");
                Blob blob = rs.getBlob("imagen");

                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();

                book.setTitle(title);
                book.setAuthor(author);
                book.setBase64Image(base64Image);
            }
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return book;
    }

}
