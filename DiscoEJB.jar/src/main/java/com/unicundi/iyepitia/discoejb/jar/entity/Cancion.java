/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Ivan Espitia
 */
@Entity
@Table(name="cancion")
@NamedQueries({
    @NamedQuery(name="Cancion.ListarTodos", query = "SELECT c FROM Cancion c")
})
public class Cancion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="nombre", nullable = false, length = 15)
    private String nombre;
    
    @Column(name="descripcion", nullable = false, length = 30)
    private String descripcion;
    
    @Column(name="duracion", nullable = false)
    private Integer duracion;
    
    @Column(name="nacionalidad", nullable = false, length = 15)
    private String nacionalidad;
    
    @Column(name="precio", nullable = false)
    private Integer precio;
    
    @Column(name="imagen", nullable = false, length = 30)
    private String imagen;
    
    @Column(name="fecha_lanzamiento", nullable = false)
    private Date fLanzamiento;
    
    @Column(name="num_ventas", nullable = false)
    private Integer numVentas;
    
    @ManyToOne
    @JoinColumn(name="id_artista", nullable = false)
    private Artista artista;
    
    @ManyToOne
    @JoinColumn(name="id_album", nullable = false)
    private Album album;

    public Cancion() {
    }

    public Cancion(Integer id, String nombre, String descripcion, Integer duracion, String nacionalidad, Integer precio, Date fLanzamiento, Integer numVentas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.nacionalidad = nacionalidad;
        this.precio = precio;
        this.fLanzamiento = fLanzamiento;
        this.numVentas = numVentas;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
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

    @JsonIgnore
    @XmlTransient
    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @JsonIgnore
    @XmlTransient
    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
    
    
    
}
