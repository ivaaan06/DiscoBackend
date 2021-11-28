/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.entity;

import com.unicundi.iyepitia.discoejb.jar.dto.CancionDto;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
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
@Table(name = "cancion")
@NamedQueries({
    @NamedQuery(name = "Cancion.ListarTodos", query = "SELECT c FROM CancionDto c"),
    @NamedQuery(name = "Cancion.ListarNombreId", query = "SELECT c.nombre FROM Cancion c WHERE c.id=:id"),
    @NamedQuery(name = "Cancion.ListarPrecio", query = "SELECT c FROM Cancion c WHERE c.precio=:precio "),
    @NamedQuery(name = "Cancion.ListarNacionalidad", query = "SELECT c FROM Cancion c WHERE c.nacionalidad=:nacionalidad")

})
@NamedNativeQueries({
    @NamedNativeQuery(name= "Cancion.ListaCancionesAlbum" , query="SELECT * FROM cancion c WHERE c.id_album = ? ",resultClass = CancionDto.class),
})
public class Cancion implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 30)
    private String descripcion;

    @Column(name = "duracion", nullable = false)
    private Integer duracion;

    @Column(name = "nacionalidad", nullable = false, length = 15)
    private String nacionalidad;

    @Column(name = "precio", nullable = false)
    private Integer precio;

    @Column(name = "imagen", nullable = false, length = 30)
    private String imagen;

    @Column(name = "fecha_lanzamiento", nullable = false)
    private Date fLanzamiento;

    @Column(name = "num_ventas", nullable = false)
    private Integer numVentas;

    @ManyToOne
    @JoinColumn(name = "id_artista", nullable = false)
    private Artista artista;

    @ManyToOne
    @JoinColumn(name = "id_album", nullable = false)
    private Album album;
    
    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = true)
    private Carrito carrito;

    public Cancion() {
    }

    public Cancion(String nombre, String descripcion, Integer duracion, String nacionalidad, Integer precio, String imagen, Date fLanzamiento, Integer numVentas, Artista artista, Album album, Carrito carrito) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.nacionalidad = nacionalidad;
        this.precio = precio;
        this.imagen = imagen;
        this.fLanzamiento = fLanzamiento;
        this.numVentas = numVentas;
        this.artista = artista;
        this.album = album;
        this.carrito = carrito;
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

    @JsonIgnore
    @XmlTransient
    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    
}
