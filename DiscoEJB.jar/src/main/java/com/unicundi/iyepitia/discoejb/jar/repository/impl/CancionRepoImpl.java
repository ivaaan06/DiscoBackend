/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.repository.impl;

import com.unicundi.iyepitia.discoejb.jar.entity.Cancion;
//import static com.unicundi.iyepitia.discoejb.jar.entity.Cancion_.id;
import com.unicundi.iyepitia.discoejb.jar.repository.ICancionRepo;
import com.unicundi.iyepitia.discoejb.jar.view.ViewArtistaCancion;
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
public class CancionRepoImpl implements ICancionRepo {

    @PersistenceContext(unitName = "conexionDisco")
    private EntityManager em;

    @Override
    public List<Cancion> listarTodos() {
        TypedQuery<Cancion> query = this.em.createNamedQuery("Cancion.ListarTodos", Cancion.class);
        return query.getResultList();
    }

    @Override
    public List<ViewArtistaCancion> listarCatalogo() {
        TypedQuery<ViewArtistaCancion> query = this.em.createNamedQuery("View.ListarCatalogoCanciones", ViewArtistaCancion.class);
        return query.getResultList();
    }

    @Override
    public Cancion listarPorId(Integer id) {
        return this.em.find(Cancion.class, id);
    }

    @Override
    public void guardar(Cancion obj) {
        this.em.persist(obj);
    }

    @Override
    public void editar(Cancion obj) {
        this.em.merge(obj);
    }

    @Override
    public void eliminar(Cancion obj) {
        this.em.remove(obj);
    }

    @Override
    public String ListarNombreid(Integer id) {
        TypedQuery query = (TypedQuery) this.em.createNamedQuery("Cancion.ListarNombreId").setParameter("id", id);
        return query.getSingleResult().toString();
    }

    /*@Override
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
    }*/
    @Override
    public List<Cancion> listarPrecio(Integer precio) {
        TypedQuery query = (TypedQuery) this.em.createNamedQuery("Cancion.ListarPrecio").setParameter("precio", precio);
        return query.getResultList();
    }

    @Override
    public List<Cancion> listarNacionalidad(String nacionalidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cancion buscarArtistaNomArtistico(String NomArtistico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cancion numeroVentas(Integer intgr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
