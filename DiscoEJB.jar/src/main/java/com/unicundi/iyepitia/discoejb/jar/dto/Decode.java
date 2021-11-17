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
public class Decode {
    private String sub;
    private String iat;
    private String exp;
    private Permisos permisos;

    public Decode() {
    }

    public Decode(String sub, String iat, String exp, Permisos permisos) {
        this.sub = sub;
        this.iat = iat;
        this.exp = exp;
        this.permisos = permisos;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getIat() {
        return iat;
    }

    public void setIat(String iat) {
        this.iat = iat;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public Permisos getPermisos() {
        return permisos;
    }

    public void setPermisos(Permisos permisos) {
        this.permisos = permisos;
    }
    
    
    
}
