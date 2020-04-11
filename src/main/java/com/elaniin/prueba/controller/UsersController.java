/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elaniin.prueba.controller;

import com.elaniin.prueba.helper.BaseRestController;
import com.elaniin.prueba.helper.Utilidades;
import com.elaniin.prueba.model.Usuario;
import com.elaniin.prueba.service.UserService;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityNotFoundException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
/**
 *
 * @author Jorgep503
 * endpoints for users CRUD
 */
@RestController
@RequestMapping
public class UsersController extends BaseRestController{
    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSender mailSender;
    
    Utilidades utils = new Utilidades();
    /**
     * Add a new usuarios endpoint
     * @param user
     * @return
     */
    @PostMapping(value = "usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole('ADM')")
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<?> addUsuario(@RequestBody Usuario user) {
        Map<String, Object> hasmap = new HashMap<>();
        String result = "";
        try {
            if (utils.isNumeric(user.getTelefono())) {
                generateResponseOk(userService.addUsuario(user));
                hasmap.put("status", true);
                hasmap.put("message", "Usuario agregado exitosamente");
            } else {
                hasmap.put("status", false);
                hasmap.put("message", "Telefono no valido, debe ser numerico");
            }
        } catch (Exception e) {
            hasmap.put("status", false);
            hasmap.put("message", "No se guardo usuario favor validar, error " + e.getMessage());
        }

        return generateResponseOk(hasmap);
    }

    /**
     * Update a usuarios
     * @param user
     * @return
     */
    @PutMapping(value = "usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<?> updateUsuario(@RequestBody Usuario user) {
        Map<String, Object> hasmap = new HashMap<>();
        String result = "";
        try {
            if (utils.isNumeric(user.getTelefono())) {
                generateResponseOk(userService.updateUsuario(user));
                hasmap.put("status", true);
                hasmap.put("message", "Usuario agregado exitosamente");
            } else {
                hasmap.put("status", false);
                hasmap.put("message", "Telefono no valido, debe ser numerico");
            }
        } catch (Exception e) {
            hasmap.put("status", false);
            hasmap.put("message", "No se guardo usuario favor validar, error " + e.getMessage());
        }

        return generateResponseOk(hasmap);
    }

    /**
     * Return all data
     * @param page
     * @param limit
     * @return
     */
    @GetMapping(value = "usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<?> allUsuario(@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "30") int limit) {
        return generateResponseOk(userService.allUsuario(page, limit));
    }

    /**
     * Delete a specific Usuarios
     * @param id
     * @return
     */
    @DeleteMapping(value = "usuarios/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<?> deleteUsuarios(@PathVariable(name = "id") int id) {
        userService.deleteUsuario(id);
        Map<String, Object> hasmap = new HashMap<>();
        hasmap.put("status",true);
        hasmap.put("message","Usuario eliminado exitosamente");
        return generateResponseOk(hasmap);
    }
    
    /**
    * Recuperacion de contraseña
    * @param email
    * @return 
    */
    @PostMapping(value = "usuarios/recuperarcontrasenia/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<?> recuperarContrasenia(@PathVariable(name = "email") String email) {
        Map<String, Object> hasmap = new HashMap<>();
        SimpleMailMessage emailMessage = new SimpleMailMessage();
        Usuario usuario = new Usuario();
        usuario = userService.findByEmail(email);
        if(usuario != null){
            emailMessage.setTo(email);
            emailMessage.setSubject("Recuperacion de contrasenia");
            emailMessage.setText("Ingrese a este link para recuperar su contrasenia:\n"
                    + "http://localhost:8080/recuperarcontrasenia/123456");
            mailSender.send(emailMessage);
            hasmap.put("status",true);
            hasmap.put("message","Correo envia exitosamente.");
        }else{
            hasmap.put("status",false);
            hasmap.put("message","Usuario no encontrado");
        }
        return generateResponseOk(hasmap);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(EntityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
