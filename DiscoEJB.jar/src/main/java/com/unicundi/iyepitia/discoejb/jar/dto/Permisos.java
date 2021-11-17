/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.dto;

/**
 *
 * @author Ivan Espitia
 */
public class Permisos {
    private String rol;
    private String rolname;

    public Permisos(String rol, String rolname) {
        this.rol = rol;
        this.rolname = rolname;
    }

    public Permisos() {
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getRolname() {
        return rolname;
    }

    public void setRolname(String rolname) {
        this.rolname = rolname;
    }
    
    
}
