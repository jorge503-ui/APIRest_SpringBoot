/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elaniin.prueba.controller;

import com.elaniin.prueba.helper.BaseRestController;
import com.elaniin.prueba.model.Usuario;
import com.elaniin.prueba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityNotFoundException;
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

    /**
     * Add a new usuarios endpoint
     * @param usuarios
     * @return
     */
    @PostMapping(value = "usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<?> addUsuario(@RequestBody Usuario user) {
        return generateResponseOk(userService.addUsuario(user));
    }

    /**
     * Update a usuarios
     * @param usuarios
     * @return
     */
    @PutMapping(value = "usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<?> updateUsuario(@RequestBody Usuario user) {
        return generateResponseOk(userService.updateUsuario(user));
    }

    /**
     * Return all data
     * @return
     */
    @GetMapping(value = "usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<?> allUsuario() {
        return generateResponseOk(userService.allUsuario());
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
        Map<String, Object> hasmap = new HashMap<String, Object>();
        hasmap.put("status",true);
        hasmap.put("message","Usuario deleted successfully");
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
