/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.service;

import com.unicundi.iyepitia.discoejb.jar.entity.Artista;
import com.unicundi.iyepitia.discoejb.jar.exception.ResourceNotFoundException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ivan Espitia
 */
@Local
public interface IArtistaService {
    public Artista listarPorId(Integer id) throws ResourceNotFoundException;
    public List<Artista> listarTodos() ;
    public void editar(Artista obj);
    public void eliminar(Integer id) throws ResourceNotFoundException;
    public void guardar(Artista obj);
    public String ListarNombreid (Integer id);
    public List<Artista> listarGenero(String genero);
    public List<Artista> listarNacionalidad(String nacionalidad);
    public Artista BuscarNomArtistico(String NomArtistico);
}
