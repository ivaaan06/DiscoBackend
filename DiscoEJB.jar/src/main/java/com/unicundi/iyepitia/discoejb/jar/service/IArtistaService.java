/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.service;

import com.unicundi.iyepitia.discoejb.jar.entity.Artista;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ivan Espitia
 */
@Local
public interface IArtistaService {
    public Artista listarPorId(Integer id);
    public List<Artista> listarTodos();
    public void editar(Artista obj);
    public void eliminar(Integer id);
    public void guardar(Artista obj);
    public String ListarNombreid (Integer id);
}
