/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.repository.impl;

import com.unicundi.iyepitia.discoejb.jar.entity.Cancion;
import com.unicundi.iyepitia.discoejb.jar.repository.ICancionRepo;
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
public class CancionRepoImpl implements ICancionRepo{

    @PersistenceContext(unitName= "conexionDisco")
    private EntityManager em;
    
    @Override
    public List<Cancion> listarTodos() {
       TypedQuery<Cancion> query = this.em.createNamedQuery("Cancion.ListarTodos",Cancion.class);
       return query.getResultList();
    }

    @Override
    public Cancion listarPorId(Integer id) {
       return this.em.find(Cancion.class, id);
    }

    @Override
    public void guardar(Cancion obj) {
        this.em.persist(obj);
    }

    @Override
    public void editar(Cancion obj) {
       this.em.merge(obj);
    }

    @Override
    public void eliminar(Cancion obj) {
         this.em.remove(obj);
    }
    
}
