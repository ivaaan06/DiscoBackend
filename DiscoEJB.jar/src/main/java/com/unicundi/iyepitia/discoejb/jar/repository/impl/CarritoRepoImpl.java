/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.repository.impl;

import com.unicundi.iyepitia.discoejb.jar.entity.Carrito;
import com.unicundi.iyepitia.discoejb.jar.repository.ICarritoRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Joseph
 */
@Stateless
public class CarritoRepoImpl implements ICarritoRepo{

    @PersistenceContext(unitName= "conexionDisco")
    private EntityManager em;
    
    @Override
    public List<Carrito> listarTodos() {
        TypedQuery<Carrito> query = this.em.createNamedQuery("carrito.ListarTodos",Carrito.class);
        return query.getResultList();
    }

    @Override
    public Carrito listarPorId(Integer id) {
        return this.em.find(Carrito.class, id);
    }

    @Override
    public void guardar(Carrito obj) {
        this.em.persist(obj);
    }

    @Override
    public void editar(Carrito obj) {
        this.em.merge(obj);
    }

    @Override
    public void eliminar(Carrito obj) {
        this.em.remove(obj);
    }
    
}
