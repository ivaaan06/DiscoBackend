/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.service;

import com.unicundi.iyepitia.discoejb.jar.dto.CancionDto;
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
    public CancionDto listarPorId(Integer id);
    public List<CancionDto> listarTodos();
    public void editar(CancionDto obj);
    public void eliminar(Integer id);
    public void guardar(CancionDto obj);
    public List<ViewArtistaCancion> listarCatalogoCancion ();
    public List<CancionDto> listaCancionesAlbum(Integer id_album);
}
