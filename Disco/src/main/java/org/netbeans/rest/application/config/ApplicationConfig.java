/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Ivan Espitia
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.unicundi.iyepitia.disco.controller.AlbumController.class);
        resources.add(com.unicundi.iyepitia.disco.controller.ArtistaController.class);
        resources.add(com.unicundi.iyepitia.disco.controller.CancionController.class);
        resources.add(com.unicundi.iyepitia.disco.controller.UsuarioController.class);
        resources.add(com.unicundi.iyepitia.disco.controller.UtilitariosController.class);
        resources.add(com.unicundi.iyepitia.disco.exception.ExceptionHandler.class);
        resources.add(org.netbeans.rest.application.config.CorsFilter.class);
        resources.add(org.netbeans.rest.application.config.Interceptor.class);
    }
    
}
