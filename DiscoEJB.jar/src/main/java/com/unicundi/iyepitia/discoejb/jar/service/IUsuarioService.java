/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.service;

import com.unicundi.iyepitia.discoejb.jar.dto.Login;
import com.unicundi.iyepitia.discoejb.jar.dto.RolDto;
import com.unicundi.iyepitia.discoejb.jar.dto.Token;
import com.unicundi.iyepitia.discoejb.jar.entity.Rol;
import com.unicundi.iyepitia.discoejb.jar.entity.Usuario;
import com.unicundi.iyepitia.discoejb.jar.exception.BussinessException;
import com.unicundi.iyepitia.discoejb.jar.exception.ResourceNotFoundException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ivan Espitia
 */
@Local
public interface IUsuarioService {
    public Usuario listarPorId(Integer id) throws ResourceNotFoundException;
    public List<Usuario> listarTodos() ;
    public void editar(Usuario obj);
    public void eliminar(Integer id) throws ResourceNotFoundException;
    public void guardar(Usuario obj);
    public Usuario login(String email, String password) throws Exception;
    public String loginString(String email, String password);
    public Token loginToken(Login obj) throws BussinessException;
    public String consultarToken (Integer Id);
    public void actualizarToken (Integer id)throws ResourceNotFoundException, BussinessException;
    public void cerrarSession (Integer id)throws ResourceNotFoundException, BussinessException;
    public Rol consultarRol(Integer id);
}
