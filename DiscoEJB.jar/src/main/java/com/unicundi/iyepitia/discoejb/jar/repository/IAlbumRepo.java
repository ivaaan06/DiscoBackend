/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.repository;

import com.unicundi.iyepitia.discoejb.jar.dto.AlbumDto;
import com.unicundi.iyepitia.discoejb.jar.entity.Album;
import com.unicundi.iyepitia.discoejb.jar.entity.Artista;
import com.unicundi.iyepitia.discoejb.jar.view.ViewArtistaAlbum;
import java.util.List;

/**
 *
 * @author Ivan Espitia
 */
public interface IAlbumRepo extends ICrud<Album, Integer>{
    public List<AlbumDto> obtener ();
    public List<AlbumDto> listarIdArtista (Integer id);
    public AlbumDto obtenerPorId(Integer id);
    public void guardarDto(AlbumDto obj);
    public void editarDto(AlbumDto obj);
    public void eliminarDto(Integer id);
    public List<ViewArtistaAlbum> listarCatalogo ();
}
