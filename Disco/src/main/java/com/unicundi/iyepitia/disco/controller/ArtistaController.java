/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.disco.controller;

import com.unicundi.iyepitia.discoejb.jar.entity.Artista;
import com.unicundi.iyepitia.discoejb.jar.exception.ResourceNotFoundException;
import com.unicundi.iyepitia.discoejb.jar.service.IArtistaService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Ivan Espitia
 *
 */
@Stateless
@Path("/Artistas")
public class ArtistaController {
    @EJB
    private IArtistaService services;
    
   
    @POST
    @Path("/guardar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(Artista obj){
        this.services.guardar(obj);
        return Response.status(Response.Status.CREATED).build();
    }
    
    @GET
    @Path("/listarTodos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodos(){
        List<Artista> artistas = this.services.listarTodos();
        return Response.status(Response.Status.OK).entity(artistas).build();
    }
    
    @GET
    @Path("/listarPorId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPorId(@PathParam("id") Integer id) throws ResourceNotFoundException{
        Artista artista = this.services.listarPorId(id);
        return Response.status(Response.Status.OK).entity(artista).build();
    }
    
    @GET
    @Path("/listarNombreId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarNombreId(@PathParam("id") Integer id){
        String artista = this.services.ListarNombreid(id);
        return Response.status(Response.Status.OK).entity(artista).build();
    }
    
    @PUT
    @Path("/editar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(Artista artista){
        this.services.editar(artista);
        return Response.status(Response.Status.OK).build();
    }
    
    @DELETE
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") Integer id) throws ResourceNotFoundException{
            this.services.eliminar(id);
            return Response.status(Response.Status.NO_CONTENT).build();
    }
    
    @GET
    @Path("/listarGenero/{genero}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarGenero(@PathParam("genero") String genero){
        List<Artista> artistas = this.services.listarGenero(genero);
        return Response.status(Response.Status.OK).entity(artistas).build();
    }
    
    @GET
    @Path("/listarNacionalidad/{nacionalidad}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarNacionalidad(@PathParam("nacionalidad") String nacionalidad){
        List<Artista> artistas = this.services.listarNacionalidad(nacionalidad);
        return Response.status(Response.Status.OK).entity(artistas).build();
    }
    
    @GET
    @Path("/buscarNomArtistico/{NomArtistico}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarNomArtistico(@PathParam("NomArtistico") String NomArtistico){
        Artista artista = this.services.BuscarNomArtistico(NomArtistico);
        return Response.status(Response.Status.OK).entity(artista).build();
    }
    
}
