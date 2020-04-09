/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elaniin.prueba.dao;
import com.elaniin.prueba.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
/**
 *
 * @author Jorgep503
 */
public interface UserRepository extends CrudRepository<Usuario, Integer>{
    Optional<Usuario> findByEmail(String email);
}
