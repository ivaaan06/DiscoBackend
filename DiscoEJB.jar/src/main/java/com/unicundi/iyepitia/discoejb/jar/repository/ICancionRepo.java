/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.repository;

import com.unicundi.iyepitia.discoejb.jar.entity.Cancion;
import java.util.List;

/**
 *
 * @author Ivan Espitia
 */
public interface ICancionRepo extends ICrud<Cancion, Integer>{
   public String ListarNombreid (Integer id);
   public List<Cancion> listarPrecio (Integer precio);
   public List<Cancion> listarNacionalidad (String nacionalidad);
   public Cancion buscarArtistaNomArtistico (String NomArtistico);
   public Cancion numeroVentas (Integer numVentas);
}
