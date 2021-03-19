/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.AbrigosHombreGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import model.AbrigosHombre;


/**
 *
 * @author maria
 */
@Named(value = "abrigosHombreController")
@SessionScoped
public class AbrigosHombreController extends AbrigosHombre implements Serializable {

    /**
     * Creates a new instance of AbrigosHombreController
     */
    public AbrigosHombreController() {
    }
    
    public List<AbrigosHombre> getProductos() {
        return AbrigosHombreGestion.getProductos();
    }
    
}
