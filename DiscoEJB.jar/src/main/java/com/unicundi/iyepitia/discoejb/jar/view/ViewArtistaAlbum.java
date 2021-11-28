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
@Table(name = "ViewArtistaAlbum")
@NamedNativeQueries({
    @NamedNativeQuery(name = "ViewArtistaAlbum.ListarCatalogoAlbum", query = "SELECT id as id_artista,nombre_artistico as nombre_artistico , genero as genero ,id_album as id_album ,nombre_album as nombre_album , precio as precio ,imagen_album as imagen_album , fecha_lanzamiento as fecha_lanzamiento FROM public. \"ViewArtistaAlbum\"" , resultClass=ViewArtistaAlbum.class)
}) 
public class ViewArtistaAlbum {
    @Id
    private Integer id_artista;     
    
    @Column(name = "id_album")
    private String id_album;  
    
    @Column(name = "nombre_artistico")
    private String nombreArtistico;    
    
    @Column(name = "genero")
    private String genero;    
    
    @Column(name = "nombre_album")
    private String nombreAlbum;     
        
    @Column(name = "precio")
    private Integer precio;
    
    @Column(name = "imagen_cancion")
    private String imagen_cancion;
    
    @Column(name = "fecha_lanzamiento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fLanzamiento;

    public ViewArtistaAlbum() {
    }

    public ViewArtistaAlbum(Integer id_artista, String id_album, String nombreArtistico, String genero, String nombreAlbum, Integer precio, String imagen_cancion, Date fLanzamiento) {
        this.id_artista = id_artista;
        this.id_album = id_album;
        this.nombreArtistico = nombreArtistico;
        this.genero = genero;
        this.nombreAlbum = nombreAlbum;
        this.precio = precio;
        this.imagen_cancion = imagen_cancion;
        this.fLanzamiento = fLanzamiento;
    }

    public Integer getId_artista() {
        return id_artista;
    }

    
    public String getId_album() {
        return id_album;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public String getGenero() {
        return genero;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
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
