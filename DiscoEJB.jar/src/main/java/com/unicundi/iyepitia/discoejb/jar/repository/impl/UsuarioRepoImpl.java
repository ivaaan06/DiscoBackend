/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.repository.impl;

import com.unicundi.iyepitia.discoejb.jar.dto.RolDto;
import com.unicundi.iyepitia.discoejb.jar.dto.Token;
import com.unicundi.iyepitia.discoejb.jar.entity.Rol;
import com.unicundi.iyepitia.discoejb.jar.entity.Usuario;
import com.unicundi.iyepitia.discoejb.jar.repository.IUsuarioRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ivan Espitia
 */
@Stateless
public class UsuarioRepoImpl implements IUsuarioRepo{

    @PersistenceContext(unitName= "conexionDisco")
    private EntityManager em;
    
    @Override
    public List<Usuario> listarTodos() {
       TypedQuery<Usuario> query = this.em.createNamedQuery("Usuario.ListarTodos",Usuario.class);
       return query.getResultList();
    }

    @Override
    public Usuario listarPorId(Integer id) {
       return this.em.find(Usuario.class, id);
    }

    @Override
    public void guardar(Usuario obj) {
        this.em.persist(obj);
    }

    @Override
    public void editar(Usuario obj) {
        this.em.merge(obj);
    }

    @Override
    public void eliminar(Usuario obj) {
        this.em.remove(obj);
    }

    @Override
    public Usuario login(String email, String password) {
       TypedQuery query = (TypedQuery) this.em.createNamedQuery("Usuario.login")
               .setParameter("email",email).setParameter("password",password );
       return (Usuario) query.getSingleResult();
    }

   

    @Override
    public void actualizarToken(String token, Integer id) {
       em.createNamedQuery("Usuario.actualizarToken",Usuario.class)
      .setParameter(1,token)
      .setParameter(2,id )
      .executeUpdate();
    }

    @Override
    public String consultarToken(Integer id) {
        TypedQuery query = (TypedQuery) this.em.createNamedQuery("Usuario.consutarToken").setParameter("id", id);
       return query.getSingleResult().toString();
    }

    @Override
    public String loginToken(String email, String password) {
         TypedQuery query = (TypedQuery) this.em.createNamedQuery("Usuario.LoginToken")
               .setParameter("email",email).setParameter("password",password );
       return  query.getSingleResult().toString();
    }

    @Override
    public Usuario consultarUsuario(Integer id) {
       TypedQuery query = (TypedQuery) this.em.createNamedQuery("Usuario.consutarUsuario").setParameter("id", id);
       return (Usuario) query.getSingleResult();
    }

    @Override
    public Rol consultarRol(Integer id) {
       TypedQuery query = (TypedQuery) this.em.createNamedQuery("Usuario.consutarRol",Rol.class).setParameter("id", id);
       return (Rol) query.getSingleResult();
    }

 
}
