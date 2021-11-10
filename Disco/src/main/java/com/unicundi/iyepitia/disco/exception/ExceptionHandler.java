/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.disco.exception;

import com.unicundi.iyepitia.discoejb.jar.exception.BussinessException;
import com.unicundi.iyepitia.discoejb.jar.exception.ResourceNotFoundException;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Ivan Espitia
 */
@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception ex) {
        ExceptionWrraper wrraper;

        if (ex instanceof BussinessException) {
            wrraper = new ExceptionWrraper("400", "BAD_REQUEST", ex.getMessage(), ((BussinessException) ex).getUrl());
            return Response.status(Response.Status.BAD_REQUEST).entity(wrraper).build();
        } else if (ex instanceof NotAllowedException) {
            wrraper = new ExceptionWrraper("405", "METHOD_NOT_ALLOWED", "El tipo de metodo no es compatible con esta url", "");
            return Response.status(Response.Status.METHOD_NOT_ALLOWED).entity(wrraper).build();
        }  else if (ex instanceof ResourceNotFoundException) {
            wrraper = new ExceptionWrraper("404", "NOT FOUND", ex.getMessage(), ""/*((ObjectException) ex).getUrl()*/);
            return Response.status(Response.Status.NOT_FOUND).entity(wrraper).build();
        } else {
            wrraper = new ExceptionWrraper("500", "INTERNAL_SERVER_ERROR", "", "");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(wrraper).build();
        }
    }

  

}

