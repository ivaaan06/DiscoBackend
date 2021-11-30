/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.disco.controller;

import com.unicundi.iyepitia.discoejb.jar.dto.AlbumDto;
import com.unicundi.iyepitia.discoejb.jar.entity.Album;
import com.unicundi.iyepitia.discoejb.jar.entity.Carrito;
import com.unicundi.iyepitia.discoejb.jar.service.IAlbumService;
import com.unicundi.iyepitia.discoejb.jar.service.ICarritoService;
import com.unicundi.iyepitia.discoejb.jar.view.ViewArtistaAlbum;
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
 * @author Joseph
 */
@Stateless
@Path("/Carrito")
public class CarritoController {
    
    @EJB
    private ICarritoService services;
    
    @POST
    @Path("/guardar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(Carrito obj){
        this.services.guardar(obj);
        return Response.status(Response.Status.CREATED).build();
    }
    
    
    
    @GET
    @Path("/listarTodos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodos(){
        List<Carrito> albumes = this.services.listarTodos();
        return Response.status(Response.Status.OK).entity(albumes).build();
    }
    
    @GET
    @Path("/listarPorId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPorId(@PathParam("id") Integer id){
        Carrito Album = this.services.listarPorId(id);
        return Response.status(Response.Status.OK).entity(Album).build();
    }
    
    
}
