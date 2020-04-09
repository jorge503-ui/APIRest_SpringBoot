/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elaniin.prueba.service;
import com.elaniin.prueba.dao.UserRepository;
import com.elaniin.prueba.model.Usuario;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.userdetails.User;
/**
 *
 * @author Jorgep503
 */
@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService{

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = userRepository.findOneByMail(email).get();
		if(user == null){
			throw new UsernameNotFoundException("Correo o contraseña invalida");
		}
		return new User(user.getEmail(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(Usuario user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADM"));

	return authorities;
    }
    
    @Override
    public Usuario addUsuario(Usuario usuario) {
        return userRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return userRepository.save(usuario);
    }

    @Override
    public List<Usuario> allUsuario() {
        List<Usuario> usuario=new ArrayList<>();
        for (Usuario meeting:userRepository.findAll()) {
            usuario.add(meeting);
        }
        return usuario;
    }

//    @Override
//    public List<Usuario> allUsuario(String name) {
//        List<Usuario> usuario=new ArrayList<>();
//        for (usuario meeting:userRepository.fin(name)) {
//            usuario.add(meeting);
//        }
//        return usuario;
//    }

    @Override
    public void deleteUsuario(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Usuario> allUsuario(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario findByEmail(String email) {
        Usuario user = userRepository.findOneByMail(email).get();
	return user;
    }
    
}
