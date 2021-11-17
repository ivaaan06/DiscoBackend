/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.disco.controller;

import com.unicundi.iyepitia.discoejb.jar.dto.Login;
import com.unicundi.iyepitia.discoejb.jar.dto.Token;
import com.unicundi.iyepitia.discoejb.jar.entity.Usuario;
import com.unicundi.iyepitia.discoejb.jar.exception.BussinessException;
import com.unicundi.iyepitia.discoejb.jar.exception.ResourceNotFoundException;
import com.unicundi.iyepitia.discoejb.jar.service.IUsuarioService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
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
@Path("/auth")
public class UtilitariosController {
   @EJB
   private IUsuarioService service;
   
    @POST
    @Path("/token")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginToken(Login usuario)throws BussinessException{
        Token token = this.service.loginToken(usuario);
        return Response.status(Response.Status.OK).entity(token).build();
    }
    
    @PUT
    @Path("/actualizarToken/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarToken(@PathParam("id") Integer id)throws BussinessException, ResourceNotFoundException{
        this.service.actualizarToken(id);
        return Response.status(Response.Status.OK).entity(id).build();
    }
    @PUT
    @Path("/cerrarSession/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response cerrarSession(@PathParam("id") Integer id)throws BussinessException, ResourceNotFoundException{
        this.service.cerrarSession(id);
        return Response.status(Response.Status.OK).entity("Session cerrada").build();
    }
    
}
