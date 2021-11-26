/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.disco.controller;

import com.unicundi.iyepitia.discoejb.jar.dto.AlbumDto;
import com.unicundi.iyepitia.discoejb.jar.entity.Album;
import com.unicundi.iyepitia.discoejb.jar.service.IAlbumService;
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
 */
@Stateless
@Path("/Albums")
public class AlbumController {
    @EJB
    private IAlbumService services;
    
    @POST
    @Path("/guardar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(AlbumDto obj){
        this.services.guardarDto(obj);
        return Response.status(Response.Status.CREATED).build();
    }
    
    @GET
    @Path("/obtener")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtener(){
        List<AlbumDto> albums = this.services.obtener();
        return Response.status(Response.Status.OK).entity(albums).build();
    }
    
    @GET
    @Path("/obtenerPorId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerPorId(@PathParam("id")Integer id){
        AlbumDto album = this.services.obtenerPorId(id);
        return Response.status(Response.Status.OK).entity(album).build();
    }
    
    
    @GET
    @Path("/listarTodos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodos(){
        List<Album> artistas = this.services.listarTodos();
        return Response.status(Response.Status.OK).entity(artistas).build();
    }
    
    @GET
    @Path("/listarPorId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPorId(@PathParam("id") Integer id){
        Album Album = this.services.listarPorId(id);
        return Response.status(Response.Status.OK).entity(Album).build();
    }
    
    @PUT
    @Path("/editar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(AlbumDto album){
        this.services.editarDto(album);
        return Response.status(Response.Status.OK).build();
    }
    
    @DELETE
    @Path("/eliminarDto/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarDto(@PathParam("id") Integer id) {
            this.services.eliminarDto(id);
            return Response.status(Response.Status.NO_CONTENT).build();
    }
    
    @DELETE
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") Integer id) {
            this.services.eliminar(id);
            return Response.status(Response.Status.NO_CONTENT).build();
    }
    
}
