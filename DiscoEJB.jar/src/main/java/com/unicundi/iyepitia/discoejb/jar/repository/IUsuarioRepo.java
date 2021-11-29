/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.discoejb.jar.repository;

import com.unicundi.iyepitia.discoejb.jar.dto.RolDto;
import com.unicundi.iyepitia.discoejb.jar.dto.Token;
import com.unicundi.iyepitia.discoejb.jar.entity.Rol;
import com.unicundi.iyepitia.discoejb.jar.entity.Usuario;

/**
 *
 * @author Ivan Espitia
 */
public interface IUsuarioRepo extends ICrud<Usuario, Integer>{
    public String loginToken (String email, String password);
    public Usuario login (String email, String password);
    public Usuario consultarUsuario (Integer id);
    public String consultarToken (Integer id);
    public void actualizarToken (String token, Integer id);
    public Rol consultarRol (Integer id);
}
