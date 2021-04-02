/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.RespaldoGestion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import model.Respaldo;

/**
 *
 * @author maria
 */
@Named(value = "respaldoController")
@SessionScoped
public class RespaldoController extends Respaldo implements Serializable {

    public RespaldoController() {}
    
    public void respaldo() {
        ZipOutputStream out = null;
        try {
            String json = RespaldoGestion.generarJson();
            File f = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/respaldo") + "modec.zip");
            out = new ZipOutputStream(new FileOutputStream(f));
            ZipEntry e = new ZipEntry("modec.json");
            out.putNextEntry(e);
            byte[] data = json.getBytes();
            out.write(data, 0, data.length);
            out.closeEntry();
            out.close();
            File zipPath = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/respaldo") + "modec.zip");
            byte[] zip = Files.readAllBytes(zipPath.toPath());
            HttpServletResponse respuesta = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            ServletOutputStream flujo = respuesta.getOutputStream();
            respuesta.setContentType("application/pdf");
            respuesta.addHeader("Content-disposition", "attachment; filename=modec.zip");
            flujo.write(zip);
            flujo.flush();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RespaldoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RespaldoController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(RespaldoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
} // Fin CDI BEAN RespaldoController
