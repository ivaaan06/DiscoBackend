/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.entity;

import java.io.Serializable;
import java.sql.Date;
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
import javax.persistence.Table;

/**
 *
 * @author Ivan Espitia
 */
@Entity
@Table(name="usuario")
@NamedQueries({
    @NamedQuery(name="Usuario.ListarTodos", query = "SELECT u FROM Usuario u"),
     @NamedQuery(name="Usuario.login", query = "SELECT u FROM Usuario u WHERE u.email=:email AND u.password=:password"),
     @NamedQuery(name="Usuario.consutarToken", query = "SELECT u.token FROM Usuario u WHERE u.id=:id"),
})
@NamedNativeQueries({
    @NamedNativeQuery( name= "Usuario.actualizarToken", query ="UPDATE usuario SET token = ? WHERE id=?"),
})
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="nombre", nullable = false, length = 15)
    private String nombre;
    
    @Column(name="documento", nullable = false, length = 15)
    private String documento;
    
    @Column(name="imagen", nullable = false, length = 15)
    private String imagen;
    
    @Column(name="email", nullable = false, length = 25)
    private String email;
    
    @Column(name="password", nullable = false, length = 25)
    private String password;
    
    @Column(name="fecha_nacimiento", nullable = false)
    private Date fNacimiento;
    
    @Column(name="token", nullable = true, columnDefinition = "text")
    private String token;

    @ManyToOne
    @JoinColumn(name="rol", nullable = false)
    private Rol rol;

    public Usuario(int id, String nombre, String documento, String imagen, String email, String password, Date fNacimiento, String token, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.imagen = imagen;
        this.email = email;
        this.password = password;
        this.fNacimiento = fNacimiento;
        this.token = token;
        this.rol = rol;
    }

    public Usuario() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 
  public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }
    
    
    
}
