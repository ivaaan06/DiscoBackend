/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.service.impl;

import com.unicundi.iyepitia.discoejb.jar.entity.Artista;
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
    public Artista listarPorId(Integer id) {
        return this.repo.listarPorId(id);
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
    public void eliminar(Integer id) {
        Artista artista = this.listarPorId(id);
        this.repo.eliminar(artista);
    }
    

    @Override
    public void guardar(Artista obj) {
        this.repo.guardar(obj);
    }

    @Override
    public String ListarNombreid(Integer id) {
       return this.repo.ListarNombreid(id);
    }
     
     
}
