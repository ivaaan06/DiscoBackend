/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.service;

import com.unicundi.iyepitia.discoejb.jar.entity.Carrito;
import java.util.List;

/**
 *
 * @author Joseph
 */
public interface ICarritoService {
    public Carrito listarPorId(Integer id);
    public List<Carrito> listarTodos();
    public void editar(Carrito obj);
    public void eliminar(Integer id);
    public void guardar(Carrito obj);
}
