/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.service.impl;

import com.unicundi.iyepitia.discoejb.jar.entity.Artista;
import com.unicundi.iyepitia.discoejb.jar.exception.ResourceNotFoundException;
import com.unicundi.iyepitia.discoejb.jar.repository.IArtistaRepo;
import com.unicundi.iyepitia.discoejb.jar.service.IArtistaService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ivan Espitia
 */
@Stateless
public class ArtistaServiceImpl implements IArtistaService{
     @EJB
    private IArtistaRepo repo;

    @Override
    public Artista listarPorId(Integer id) throws ResourceNotFoundException{
        Artista artista = this.repo.listarPorId(id);
        if (artista != null) {
            return artista;
        } else {
            throw new ResourceNotFoundException("Alumno no encontrado", "/listarPorId");
        }
    }

    @Override
    public List<Artista> listarTodos() {
        return this.repo.listarTodos();
    }

    @Override
    public void editar(Artista obj) {
        this.repo.editar(obj);
    }

    @Override
    public void eliminar(Integer id) throws ResourceNotFoundException{
         Artista artista = this.repo.listarPorId(id);
        if (artista != null) {
            this.repo.eliminar(artista);
        } else {
            throw new ResourceNotFoundException("Alumno no encontrado", "/eliminar");
        }
    }
    

    @Override
    public void guardar(Artista obj) {
        this.repo.guardar(obj);
    }

    @Override
    public String ListarNombreid(Integer id) {
       return this.repo.ListarNombreid(id);
    }

    @Override
    public List<Artista> listarGenero(String genero) {
       //exepcion
       return this.repo.listarGenero(genero);
    }

    @Override
    public List<Artista> listarNacionalidad(String nacionalidad) {
       return this.repo.listarNacionalidad(nacionalidad);
    }

    @Override
    public Artista BuscarNomArtistico(String NomArtistico) {
       return this.repo.buscarArtistaNomArtistico(NomArtistico);
    }
     
     
}
