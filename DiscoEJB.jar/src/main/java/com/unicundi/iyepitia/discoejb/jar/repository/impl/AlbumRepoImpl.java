/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.repository.impl;

import com.unicundi.iyepitia.discoejb.jar.dto.AlbumDto;
import com.unicundi.iyepitia.discoejb.jar.entity.Album;
import com.unicundi.iyepitia.discoejb.jar.repository.IAlbumRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ivan Espitia
 */
@Stateless
public class AlbumRepoImpl implements IAlbumRepo {

    @PersistenceContext(unitName = "conexionDisco")
    private EntityManager em;

    @Override
    public List<Album> listarTodos() {
        TypedQuery<Album> query = this.em.createNamedQuery("Album.ListarTodos", Album.class);
        return query.getResultList();
    }

    @Override
    public Album listarPorId(Integer id) {
        return this.em.find(Album.class, id);
    }

    @Override
    public void guardar(Album obj) {
        this.em.persist(obj);
    }

    @Override
    public void editar(Album obj) {
        this.em.merge(obj);
    }

    @Override
    public void eliminar(Album obj) {
        this.em.remove(obj);
    }

    @Override
    public List<AlbumDto> obtener() {
        Query query = em.createNamedQuery("Album.Obtener", AlbumDto.class);
        List<AlbumDto> result = query.getResultList();
        return result;
    }

    @Override
    public AlbumDto obtenerPorId(Integer id) {
        Query query = em.createNamedQuery("Album.ListarPorId");
        query.setParameter(1, id);
        AlbumDto result = (AlbumDto) query.getSingleResult();
        return result;
    }

    @Override
    public void guardarDto(AlbumDto obj) {
        this.em.createNamedQuery("Album.GuardarDto")
                .setParameter(1, obj.getNombre())
                .setParameter(2, obj.getDescripcion())
                .setParameter(3, obj.getDuracion())
                .setParameter(4, obj.getPrecio())
                .setParameter(5, obj.getImagen())
                .setParameter(6, obj.getfLanzamiento())
                .setParameter(7, obj.getNumVentas())
                .setParameter(8, obj.getIdArtista())
                .executeUpdate();
    }

    @Override
    public void editarDto(AlbumDto obj) {
        this.em.createNamedQuery("Album.EditarDto")
                .setParameter(1, obj.getNombre())
                .setParameter(2, obj.getDescripcion())
                .setParameter(3, obj.getDuracion())
                .setParameter(4, obj.getPrecio())
                .setParameter(5, obj.getImagen())
                .setParameter(6, obj.getfLanzamiento())
                .setParameter(7, obj.getNumVentas())
                .setParameter(8, obj.getIdArtista())
                .setParameter(9, obj.getId()).executeUpdate();
    }

    @Override
    public void eliminarDto(Integer id) {
        this.em.createNamedQuery("Album.EliminarDto")
                .setParameter(1, id)
                .executeUpdate();
    }

}
