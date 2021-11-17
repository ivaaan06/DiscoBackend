/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.disco.controller;

import com.unicundi.iyepitia.discoejb.jar.entity.Usuario;
import com.unicundi.iyepitia.discoejb.jar.exception.BussinessException;
import com.unicundi.iyepitia.discoejb.jar.exception.ResourceNotFoundException;
import com.unicundi.iyepitia.discoejb.jar.service.IArtistaService;
import com.unicundi.iyepitia.discoejb.jar.service.IUsuarioService;
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
@Path("/Usuarios")
public class UsuarioController {
    
    @EJB
    private IUsuarioService services;
    
   
    @POST
    @Path("/guardar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(Usuario obj){
        this.services.guardar(obj);
        return Response.status(Response.Status.CREATED).build();
    }
    
    @GET
    @Path("/listarTodos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodos(){
        List<Usuario> usuarios = this.services.listarTodos();
        return Response.status(Response.Status.OK).entity(usuarios).build();
    }
    
    
    
    @GET
    @Path("/listarPorId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPorId(@PathParam("id") Integer id) throws ResourceNotFoundException{
        Usuario usuario = this.services.listarPorId(id);
        return Response.status(Response.Status.OK).entity(usuario).build();
    }
    
    
    @PUT
    @Path("/editar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(Usuario usuario){
        this.services.editar(usuario);
        return Response.status(Response.Status.OK).build();
    }
    
    @DELETE
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") Integer id) throws ResourceNotFoundException{
            this.services.eliminar(id);
            return Response.status(Response.Status.NO_CONTENT).build();
    }
    
    
    
}
