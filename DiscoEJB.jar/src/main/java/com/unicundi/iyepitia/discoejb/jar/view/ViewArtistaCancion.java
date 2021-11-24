/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.view;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Joseph
 */

@Entity
@Table(name = "ViewArtistaCancion")
@NamedNativeQueries({
    @NamedNativeQuery(name = "View.ListarCatalogoCanciones", query = "SELECT id as id_artista,nombre_artistico as nombre_artistico , genero as genero , nombre_cancion as nombre_cancion , precio as precio ,imagen_cancion as imagen_cancion , fecha_lanzamiento as fecha_lanzamiento FROM public. \"ViewArtistaCancion\"" , resultClass=ViewArtistaCancion.class)
})

public class ViewArtistaCancion {
    @Id
    private Integer id_artista;          
    
    @Column(name = "nombre_artistico")
    private String nombreArtistico;    
    
    @Column(name = "genero")
    private String genero;    
    
    @Column(name = "nombre_cancion")
    private String nombreCancion;     
        
    @Column(name = "precio")
    private Integer precio;
    
    @Column(name = "imagen_cancion")
    private String imagen_cancion;
     
    @Column(name = "fecha_lanzamiento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fLanzamiento;
    
    public ViewArtistaCancion() {
    }

    public ViewArtistaCancion(Integer id_artista, String nombreArtistico, String genero, String nombreCancion, Integer precio, String imagen_cancion, Date fLanzamiento) {
        this.id_artista = id_artista;
        this.nombreArtistico = nombreArtistico;
        this.genero = genero;
        this.nombreCancion = nombreCancion;
        this.precio = precio;
        this.imagen_cancion = imagen_cancion;
        this.fLanzamiento = fLanzamiento;
    }

    public Integer getId_artista() {
        return id_artista;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public String getGenero() {
        return genero;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public String getImagen_cancion() {
        return imagen_cancion;
    }

    public Date getfLanzamiento() {
        return fLanzamiento;
    }   
}
