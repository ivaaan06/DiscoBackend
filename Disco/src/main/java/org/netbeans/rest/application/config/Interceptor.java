/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import com.unicundi.iyepitia.disco.exception.ExceptionWrraper;
import com.unicundi.iyepitia.discoejb.jar.dto.Token;
import com.unicundi.iyepitia.discoejb.jar.entity.Usuario;

import com.unicundi.iyepitia.discoejb.jar.service.IUsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import java.io.IOException;
import javax.ejb.EJB;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.DatatypeConverter;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author Ivan Espitia
 */
@Provider
@PreMatching
public class Interceptor implements ContainerRequestFilter {

    @EJB
    private IUsuarioService services;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        //estraer url de donde se esta haciendo la peticion

        String url = requestContext.getUriInfo().getAbsolutePath().toString();
        ExceptionWrraper wrraper;

        //urls que no necesitan token
if (url.contains("/auth/token")) {
return;
}
if (url.contains("/auth/login")) {
return;
}
if (url.contains("/auth/actualizarToken")) {
return;
}
if (url.contains("/auth/consultarRol")) {
return;
}
//temporal
if(url.contains("/Albums/obtener")){
return;
}
if(url.contains("/Albums/obtenerPorId")){
return;
}
if(url.contains("/Albums/listarIdArtista")){
return;
}
if(url.contains("/Albums/guardar")){
return;
}
if(url.contains("/Albums/eliminar")){
return;
}
if(url.contains("/Albums/editar")){
return;
}
if (url.contains("/Albums/listarCatalogo")) {
return;
}
if(url.contains("/Artistas/listarPorId")){
return;
}
if(url.contains("/Artistas/listarTodos")){
return;
}
if(url.contains("/Artistas/guardar")){
return;
}
if(url.contains("/Artistas/eliminar")){
return;
}
if(url.contains("/Artistas/editar")){
return;
}
if(url.contains("/Artistas/listarPorId")){
return;
}
if (url.contains("/Canciones/listarCatalogo")) {
return;
}
if (url.contains("/Canciones/listarTodos")) {
return;
}
if (url.contains("/Canciones/listarPorId")) {
return;
}
if (url.contains("/Canciones/guardar")) {
return;
}
if (url.contains("/Canciones/editar")) {
return;
}
if (url.contains("/Canciones/eliminar")) {
return;
}
if (url.contains("/Canciones/listarCancionesAlbum")) {
return;
}
if (url.contains("/Canciones/listarCatalogo")) {
return;
}
        String token = requestContext.getHeaderString("Authorization");
        if (token == null) {
            wrraper = new ExceptionWrraper("401", "UNAUTHORIZED", "TOKEN INVALIDO", url);
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(wrraper).build());
            return;
        } else {
            String key = "IG95Jup^";
            try {
                Claims claims = Jwts.parser()
                        .setSigningKey(DatatypeConverter.parseBase64Binary(key))
                        .parseClaimsJws(token).getBody();

                //claims.toString();
                //claims.getExpiration().toString();
                //claims.getSubject();
                JSONObject objetoJson = new JSONObject(claims.toString());
                String id = objetoJson.getString("sub");
                Usuario usuario = this.services.listarPorId(Integer.valueOf(id));
                System.out.println(token);
                String tokendb = this.services.consultarToken(Integer.valueOf(id));
                System.out.println(tokendb);
                if (tokendb.equals(token)) {
                    
                    if (url.contains("/Artistas") && claims.toString().contains("Administrador")) {
                        return;
                    }
                    if (url.contains("/Canciones") && claims.toString().contains("Administrador")) {
                        return;
                    }
                    if (url.contains("/Albums") && claims.toString().contains("Administrador")) {
                        return;
                    }
                } else {
                    wrraper = new ExceptionWrraper("401", "UNAUTHORIZED", "TOKEN INVALIDO, INICIE SESSION", url);
                    requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(wrraper).build()); 
                }

            } catch (ExpiredJwtException e) {
                wrraper = new ExceptionWrraper("401", "UNAUTHORIZED", "TOKEN CADUCADO", url);
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(wrraper).build());
            } catch (Exception e) {
                wrraper = new ExceptionWrraper("500", "UNAUTHORIZED", "ERROR AL DECIFRAR EL TOKEN", url);
                requestContext.abortWith(Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(wrraper).build());
            }

        }
    }

}
