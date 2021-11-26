/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.dto;

import java.io.Serializable;

/**
 *
 * @author Ivan Espitia
 */
public class NombreArtistaDto implements Serializable{
    
    private String nombre_artistico;

    public NombreArtistaDto() {
        
    }

    public NombreArtistaDto(String nombre_artistico) {
        this.nombre_artistico = nombre_artistico;
    }

    public String getNombre_artistico() {
        return nombre_artistico;
    }

    public void setNombre_artistico(String nombre_artistico) {
        this.nombre_artistico = nombre_artistico;
    }

    
    
}
