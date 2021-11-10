/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.service.impl;

import com.unicundi.iyepitia.discoejb.jar.entity.Cancion;
import com.unicundi.iyepitia.discoejb.jar.repository.ICancionRepo;
import com.unicundi.iyepitia.discoejb.jar.service.ICancionService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ivan Espitia
 */
@Stateless
public class CancionServiceImpl implements ICancionService{

    @EJB
    private ICancionRepo repo;
    
    @Override
    public Cancion listarPorId(Integer id) {
       Cancion cancion = this.repo.listarPorId(id);
       return cancion;
    }

    @Override
    public List<Cancion> listarTodos() {
        return this.repo.listarTodos();
    }

    @Override
    public void editar(Cancion obj) {
       this.repo.editar(obj);
    }

    @Override
    public void eliminar(Integer id) {
        Cancion cancion = this.listarPorId(id);
        this.repo.eliminar(cancion);
    }

    @Override
    public void guardar(Cancion obj) {
       this.repo.guardar(obj);
    }
    
}
