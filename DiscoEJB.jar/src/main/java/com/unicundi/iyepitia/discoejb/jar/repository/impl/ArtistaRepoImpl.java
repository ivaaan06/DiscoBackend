/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.repository.impl;

import com.unicundi.iyepitia.discoejb.jar.entity.Artista;
import com.unicundi.iyepitia.discoejb.jar.repository.IArtistaRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ivan Espitia
 */
@Stateless
public class ArtistaRepoImpl implements IArtistaRepo{

    @PersistenceContext(unitName= "conexionDisco")
    private EntityManager em;
    
    @Override
    public List<Artista> listarTodos() {
       TypedQuery<Artista> query = this.em.createNamedQuery("Artista.ListarTodos",Artista.class);
       return query.getResultList();
    }

    @Override
    public Artista listarPorId(Integer id) {
         return this.em.find(Artista.class, id);
    }

    @Override
    public void guardar(Artista obj) {
       this.em.persist(obj);
    }

    @Override
    public void editar(Artista obj) {
       this.em.merge(obj);
    }

    @Override
    public void eliminar(Artista obj) {
        this.em.remove(obj);
    }

    @Override
    public String ListarNombreid(Integer id) {
        TypedQuery query = (TypedQuery) this.em.createNamedQuery("Artista.ListarNombreId").setParameter("id", id);
       return query.getSingleResult().toString();
    }

    @Override
    public List<Artista> listarGenero(String genero) {
       TypedQuery<Artista> query = this.em.createNamedQuery("Artista.ListarGenero",Artista.class).setParameter("genero", genero);
       return query.getResultList();
    }

    @Override
    public List<Artista> listarNacionalidad(String nacionalidad) {
       TypedQuery<Artista> query = this.em.createNamedQuery("Artista.ListarNacionalidad",Artista.class).setParameter("nacionalidad", nacionalidad);
       return query.getResultList();
    }

    @Override
    public Artista buscarArtistaNomArtistico(String nombreArtistico) {
       TypedQuery query = (TypedQuery) this.em.createNamedQuery("Artista.BuscarNombreArtistico")
               .setParameter("nombreArtistico", nombreArtistico);
       return (Artista) query.getSingleResult();
    }
    
}
