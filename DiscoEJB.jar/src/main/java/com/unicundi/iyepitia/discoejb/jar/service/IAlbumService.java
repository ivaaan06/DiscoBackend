/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.service;

import com.unicundi.iyepitia.discoejb.jar.dto.AlbumDto;
import com.unicundi.iyepitia.discoejb.jar.entity.Album;
import com.unicundi.iyepitia.discoejb.jar.entity.Artista;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ivan Espitia
 */
@Local
public interface IAlbumService {
    public List<AlbumDto> obtener() ;
    public Album listarPorId(Integer id);
    public List<Album> listarTodos();
    public void editar(Album obj);
    public void eliminar(Integer id);
    public void guardar(Album obj);
    public AlbumDto obtenerPorId(Integer id);
    public void guardarDto(AlbumDto obj) ;
    public void editarDto(AlbumDto obj) ;
    public void eliminarDto(Integer id);
    public List<AlbumDto> listarIdArtista(Integer id);   
}
