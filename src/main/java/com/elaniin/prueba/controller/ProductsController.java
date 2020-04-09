/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elaniin.prueba.controller;

import com.elaniin.prueba.helper.BaseRestController;
import com.elaniin.prueba.model.Producto;
import com.elaniin.prueba.service.ProductServices;
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
 * endpoints for products CRUD
 */
@RestController
@RequestMapping
public class ProductsController extends BaseRestController{
    @Autowired
    private ProductServices productServices;

    /**
     * Add a new produto endpoint
     * @param produtos
     * @return
     */
    @PostMapping(value = "produtos", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<?> addProducto(@RequestBody Producto produto) {
        return generateResponseOk(productServices.addProducto(produto));
    }

    /**
     * Update a produto
     * @param produto
     * @return
     */
    @PutMapping(value = "produtos", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<?> updateProducto(@RequestBody Producto produto) {
        return generateResponseOk(productServices.addProducto(produto));
    }

    /**
     * Return all data
     * @return
     */
    @GetMapping(value = "produtos", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<?> allProductos() {
        return generateResponseOk(productServices.allProducto());
    }

    /**
     * Delete a specific produto
     * @param id
     * @return
     */
    @DeleteMapping(value = "produtos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<?> deleteProductos(@PathVariable(name = "id") int id) {
        productServices.deleteProducto(id);
        Map<String, Object> hasmap = new HashMap<String, Object>();
        hasmap.put("status",true);
        hasmap.put("message","Produto eliminado exitosamente");
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
