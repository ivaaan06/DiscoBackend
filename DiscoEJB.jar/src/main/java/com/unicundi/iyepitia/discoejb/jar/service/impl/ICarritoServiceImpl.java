/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.service.impl;

import com.unicundi.iyepitia.discoejb.jar.entity.Carrito;
import com.unicundi.iyepitia.discoejb.jar.repository.ICarritoRepo;
import com.unicundi.iyepitia.discoejb.jar.service.ICarritoService;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Joseph
 */
public class ICarritoServiceImpl implements ICarritoService{

    @EJB
    private ICarritoRepo repo;

    @Override
    public Carrito listarPorId(Integer id) {
        Carrito carrito = this.repo.listarPorId(id);
        return carrito;
    }

    @Override
    public List<Carrito> listarTodos() {
        return this.repo.listarTodos();
    }

    @Override
    public void editar(Carrito obj) {
        this.repo.editar(obj);
    }

    @Override
    public void eliminar(Integer id) {
        Carrito carrito = this.listarPorId(id);
        this.repo.eliminar(carrito);
    }

    @Override
    public void guardar(Carrito obj) {
        this.repo.guardar(obj);
    }

}
