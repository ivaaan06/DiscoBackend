/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.service;

import com.unicundi.iyepitia.discoejb.jar.entity.Cancion;
import com.unicundi.iyepitia.discoejb.jar.view.ViewArtistaCancion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ivan Espitia
 */
@Local
public interface ICancionService{
    public Cancion listarPorId(Integer id);
    public List<Cancion> listarTodos();
    public void editar(Cancion obj);
    public void eliminar(Integer id);
    public void guardar(Cancion obj);
    public List<ViewArtistaCancion> listarCatalogoCancion ();
}
