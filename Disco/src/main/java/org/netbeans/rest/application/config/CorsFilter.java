/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Ivan Espitia
 */
@Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, 
      ContainerResponseContext responseContext) throws IOException {
       responseContext.getHeaders().add(
            "Access-Control-Allow-Origin", "*");
          responseContext.getHeaders().add(
            "Access-Control-Allow-Credentials", "true");
          responseContext.getHeaders().add(
           "Access-Control-Allow-Headers","*");
          responseContext.getHeaders().add(
            "Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
          responseContext.getHeaders().add("Access-Control-Max-Age", "86400");
    }
}