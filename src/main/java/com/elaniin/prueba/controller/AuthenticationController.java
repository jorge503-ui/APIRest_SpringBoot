/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elaniin.prueba.controller;
import com.elaniin.prueba.beans.AuthToken;
import com.elaniin.prueba.beans.AuthenticationBean;
import com.elaniin.prueba.config.TokenProvider;
import com.elaniin.prueba.helper.BaseRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Jorgep503
 */
@RestController
@RequestMapping
public class AuthenticationController extends BaseRestController{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;
    
    /**
     * @param request
     * @return
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody AuthenticationBean request) {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getMail(),
                        request.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);


        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }
}
