/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.service.impl;

import com.unicundi.iyepitia.discoejb.jar.dto.AlbumDto;
import com.unicundi.iyepitia.discoejb.jar.entity.Album;
import com.unicundi.iyepitia.discoejb.jar.repository.IAlbumRepo;
import com.unicundi.iyepitia.discoejb.jar.service.IAlbumService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ivan Espitia
 */
@Stateless
public class AlbumServiceImpl implements IAlbumService{

    @EJB
    private IAlbumRepo repo;
    
    @Override
    public Album listarPorId(Integer id) { 
        Album album = this.repo.listarPorId(id);
       return album;
    }

    @Override
    public List<Album> listarTodos() {
        return this.repo.listarTodos();
    }

    @Override
    public void editar(Album obj) {
        this.repo.editar(obj);
    }

    @Override
    public void eliminar(Integer id) {
        Album album= listarPorId(id);
        this.repo.eliminar(album);
    }

    @Override
    public void guardar(Album obj) {
     this.repo.guardar(obj);
    }

    @Override
    public List<AlbumDto> obtener() {
        return this.repo.obtener();
    }

    @Override
    public AlbumDto obtenerPorId(Integer intgr) {
       return this.repo.obtenerPorId(intgr);
    }

    @Override
    public void guardarDto(AlbumDto obj) {
        this.repo.guardarDto(obj);
    }

    @Override
    public void editarDto(AlbumDto obj) {
        this.repo.editarDto(obj);
    }

    @Override
    public void eliminarDto(Integer id) {
        this.repo.eliminarDto(id);
    }
    
}
