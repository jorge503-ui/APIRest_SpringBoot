/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elaniin.prueba.service;

import com.elaniin.prueba.model.Usuario;
import java.util.List;

/**
 *
 * @author Jorgep503
 */
public interface UserService {
    Usuario addUsuario(Usuario usuario);
    Usuario updateUsuario(Usuario usuario);
    List<Usuario> allUsuario();
    List<Usuario> allUsuario(String title);
    void deleteUsuario(Integer id);
}
