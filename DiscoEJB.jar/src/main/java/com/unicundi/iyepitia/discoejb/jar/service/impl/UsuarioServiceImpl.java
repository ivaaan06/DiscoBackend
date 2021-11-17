/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.service.impl;

import com.unicundi.iyepitia.discoejb.jar.dto.Login;
import com.unicundi.iyepitia.discoejb.jar.dto.Token;
import com.unicundi.iyepitia.discoejb.jar.entity.Cancion;
import com.unicundi.iyepitia.discoejb.jar.entity.Usuario;
import com.unicundi.iyepitia.discoejb.jar.exception.BussinessException;
import com.unicundi.iyepitia.discoejb.jar.exception.ResourceNotFoundException;
import com.unicundi.iyepitia.discoejb.jar.repository.IUsuarioRepo;
import com.unicundi.iyepitia.discoejb.jar.service.IUsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ivan Espitia
 */
@Stateless
public class UsuarioServiceImpl implements IUsuarioService{

     @EJB
     private IUsuarioRepo repo;
    
    @Override
    public Usuario login(String email, String password) throws BussinessException {
        Usuario usuario = repo.login(email, password);
        if (usuario != null) {
            return usuario;
        } else {
            throw new BussinessException("Correo y/o contrasena incorrectos", "/login");
        }
    }

    @Override
    public Usuario listarPorId(Integer id) throws ResourceNotFoundException {
           Usuario usuario = this.repo.listarPorId(id);
        if (usuario != null) {
            return usuario;
        } else {
            throw new ResourceNotFoundException("Usuario no encontrado", "/listarPorId");
        }
    }

    @Override
    public List<Usuario> listarTodos() {
      return this.repo.listarTodos();
    }

    @Override
    public void editar(Usuario usr) {
        this.repo.editar(usr);
    }

    @Override
    public void eliminar(Integer id) throws ResourceNotFoundException {
      Usuario usuario = this.repo.listarPorId(id);
        if (usuario != null) {
            this.repo.eliminar(usuario);
        } else {
            throw new ResourceNotFoundException("Usuario no encontrado", "/eliminar");
        }
    }

    @Override
    public void guardar(Usuario usr) {
       this.repo.guardar(usr);
    }

    @Override
    public Token loginToken(Login obj) throws BussinessException {
        
        Usuario usuario = this.repo.login(obj.getEmail(), obj.getPassword());
        if (usuario != null) {
            String key = "IG95Jup^";
            long tiempo = System.currentTimeMillis();
            
            Map<String, Object> permisos = new HashMap<>();
            permisos.put(usuario.getRol().getId().toString(),usuario.getRol().getNombre());
            String id = Integer.toString(usuario.getId());
            String jwt = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS512, key)
                    .setSubject(id)
                    .setIssuedAt(new Date(tiempo))
                    .setExpiration(new Date(tiempo+900000) )
                    .claim("permisos", permisos)
                    .compact();
            
            Token token = new Token(jwt);
            this.repo.actualizarToken(token.getToken(), usuario.getId());
            return token; 
        }else{
            throw new BussinessException("Correo y/o contrasena incorrecta, por favor verifique","/auto/login");
        }
        
    }

   

    @Override
    public void actualizarToken(Integer intgr) throws ResourceNotFoundException, BussinessException {
      Usuario usuario = this.listarPorId(intgr);
      Login login = new Login();
      login.setEmail(usuario.getEmail());
      login.setPassword(usuario.getPassword());
      Token token = this.loginToken(login);
      this.repo.actualizarToken(token.getToken(), usuario.getId());
    }

    @Override
    public void cerrarSession(Integer id) throws ResourceNotFoundException, BussinessException {
     Usuario usuario = this.listarPorId(id);
      Login login = new Login();
      login.setEmail(usuario.getEmail());
      login.setPassword(usuario.getPassword());
      Token token = new Token(null);
      this.repo.actualizarToken(token.getToken(), usuario.getId());
    }

    @Override
    public String consultarToken(Integer intgr){
        return this.repo.consultarToken(intgr);
    }

    
    
}
