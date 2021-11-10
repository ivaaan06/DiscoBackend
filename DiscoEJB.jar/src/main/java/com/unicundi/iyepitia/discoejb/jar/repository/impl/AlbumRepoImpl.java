/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.repository.impl;

import com.unicundi.iyepitia.discoejb.jar.entity.Album;
import com.unicundi.iyepitia.discoejb.jar.repository.IAlbumRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


/**
 *
 * @author Ivan Espitia
 */
@Stateless
public class AlbumRepoImpl implements IAlbumRepo{
    
    @PersistenceContext(unitName= "conexionDisco")
    private EntityManager em;
    
    
    @Override
    public List<Album> listarTodos() {
       TypedQuery<Album> query = this.em.createNamedQuery("Album.ListarTodos",Album.class);
       return query.getResultList();
    }

    @Override
    public Album listarPorId(Integer id) {
        return this.em.find(Album.class, id);
    }

    @Override
    public void guardar(Album obj) {
      this.em.persist(obj);
    }

    @Override
    public void editar(Album obj) {
        this.em.merge(obj);
    }

    @Override
    public void eliminar(Album obj) {
        this.em.remove(obj);
    }
   
}
