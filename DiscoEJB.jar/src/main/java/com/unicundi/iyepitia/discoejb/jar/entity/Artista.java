/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ivan Espitia
 */
@Entity
@Table(name="artista")
@NamedQueries({
    @NamedQuery(name="Artista.ListarTodos", query = "SELECT a FROM Artista a"),
    @NamedQuery(name="Artista.ListarNombreId", query= "SELECT a.nombre FROM Artista a WHERE a.id=:id"),
    @NamedQuery(name="Artista.ListarGenero", query= "SELECT a FROM Artista a WHERE a.genero=:genero"),
    @NamedQuery(name="Artista.ListarNacionalidad", query= "SELECT a FROM Artista a WHERE a.nacionalidad=:nacionalidad"),
    @NamedQuery(name="Artista.BuscarNombreArtistico", query= "SELECT a FROM Artista a WHERE a.nombreArtistico=:nombreArtistico")
})

public class Artista implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="nombre", nullable = false, length = 15)
    private String nombre;
    
    @Column(name="nombre_artistico", nullable = false, length = 15)
    private String nombreArtistico;
    
    @Column(name="genero", nullable = false, length = 15)
    private String genero;
    
    @Column(name="nacionalidad", nullable = false, length = 15)
    private String nacionalidad;
    
    @Column(name="imagen", nullable = false, length = 15, unique=true)
    private String imagen;
    
    @Column(name="fecha_nacimiento", nullable = false)
    private Date fNacimiento;
    
    @OneToMany(mappedBy = "artista", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Album> album;
    
    @OneToMany(mappedBy = "artista", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cancion> cancion;
    
    

    public Artista(Integer id, String nombre, String nombreArtistico, String genero, String nacionalidad, String imagen, Date fNacimiento, List<Album> albunes) {
        this.id = id;
        this.nombre = nombre;
        this.nombreArtistico = nombreArtistico;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.imagen = imagen;
        this.fNacimiento = fNacimiento;
    }

    
    public Artista() {
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

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Date getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public List<Cancion> getCanciones() {
        return cancion;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.cancion = canciones;
    }

    public List<Album> getAlbunes() {
        return album;
    }

    public void setAlbunes(List<Album> albunes) {
        this.album = albunes;
    }
    
    
    
}
