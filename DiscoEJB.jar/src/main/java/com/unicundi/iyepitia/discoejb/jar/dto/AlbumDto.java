/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.dto;

import com.unicundi.iyepitia.discoejb.jar.entity.Artista;
import com.unicundi.iyepitia.discoejb.jar.entity.Cancion;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ivan Espitia
 */
@Entity
@Table(name="album")
public class AlbumDto implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="descripcion")
    private String descripcion;
    
    @Column(name="duracion")
    private Integer duracion;
    
    @Column(name="precio")
    private Integer precio;
    
    @Column(name="imagen")
    private String imagen;
    
    @Column(name="fecha_lanzamiento" )
    private Date fLanzamiento;
    
    @Column(name="num_ventas")
    private Integer numVentas;
    
    @Column(name="id_artista")
    private Integer idArtista;
    
    public AlbumDto() {
    }

    public AlbumDto(Integer id, String nombre, String descripcion, Integer duracion, Integer precio, String imagen, Date fLanzamiento, Integer numVentas, Integer idArtista) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.precio = precio;
        this.imagen = imagen;
        this.fLanzamiento = fLanzamiento;
        this.numVentas = numVentas;
        this.idArtista = idArtista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Date getfLanzamiento() {
        return fLanzamiento;
    }

    public void setfLanzamiento(Date fLanzamiento) {
        this.fLanzamiento = fLanzamiento;
    }

    public Integer getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(Integer numVentas) {
        this.numVentas = numVentas;
    }

    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }
    
    
   
    
    
    
}
