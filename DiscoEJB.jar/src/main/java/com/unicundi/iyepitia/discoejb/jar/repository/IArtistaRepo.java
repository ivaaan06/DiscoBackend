/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.repository;

import com.unicundi.iyepitia.discoejb.jar.entity.Artista;
import java.util.List;

/**
 *
 * @author Ivan Espitia
 */
public interface IArtistaRepo extends ICrud<Artista, Integer>{
   public String ListarNombreid (Integer id);
   public List<Artista> listarGenero (String genero);
   public List<Artista> listarNacionalidad (String nacionalidad);
   public Artista buscarArtistaNomArtistico (String NomArtistico);
}
