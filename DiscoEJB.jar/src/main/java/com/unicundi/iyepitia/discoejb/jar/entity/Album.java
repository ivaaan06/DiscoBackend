/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.entity;

import com.unicundi.iyepitia.discoejb.jar.dto.AlbumDto;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Ivan Espitia
 */
@Entity
@Table(name="album")
@NamedQueries({
    @NamedQuery(name="Album.ListarTodos", query = "SELECT a FROM Album a")
})
@NamedNativeQueries({
    @NamedNativeQuery(name= "Album.Obtener" , query="SELECT id,nombre, descripcion,duracion,precio,imagen,fecha_lanzamiento,num_ventas,id_artista FROM album",resultClass = AlbumDto.class),
    @NamedNativeQuery(name= "Album.ListarPorId" , query="SELECT * FROM album WHERE album.id = ?",resultClass = AlbumDto.class),
    @NamedNativeQuery(name= "Album.GuardarDto" , query="INSERT INTO public.album (nombre,descripcion,duracion,precio,imagen,fecha_lanzamiento,num_ventas,id_artista) VALUES (?,?,?,?,?,?,?,?)"),
    @NamedNativeQuery(name= "Album.EditarDto" , query="UPDATE public.album SET nombre = ? ,descripcion = ? ,duracion = ? ,precio = ? ,imagen = ? ,fecha_lanzamiento = ? ,num_ventas= ? ,id_artista = ? WHERE album.id = ? "),
    @NamedNativeQuery(name= "Album.EliminarDto" , query="DELETE FROM public.album WHERE album.id = ?")
})
public class Album implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="nombre", nullable = false, length = 15)
    private String nombre;
    
    @Column(name="descripcion", nullable = false, length = 30)
    private String descripcion;
    
    @Column(name="duracion", nullable = false)
    private Integer duracion;
    
    @Column(name="precio", nullable = false)
    private Integer precio;
    
    @Column(name="imagen", nullable = false, length = 15, unique=true)
    private String imagen;
    
    @Column(name="fecha_lanzamiento" , nullable = false)
    private Date fLanzamiento;
    
    @Column(name="num_ventas", nullable = false)
    private Integer numVentas;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="id_artista", nullable = false)
    private Artista artista;
    
    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cancion> cancion;

    public Album() {
    }

    public Album(Integer id, String nombre, String descripcion, Integer duracion, Integer precio, String imagen, Date fLanzamiento, Integer numVentas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.precio = precio;
        this.imagen = imagen;
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

    public List<Cancion> getCancion() {
        return cancion;
    }

    public void setCancion(List<Cancion> cancion) {
        this.cancion = cancion;
    }
    
    
}
