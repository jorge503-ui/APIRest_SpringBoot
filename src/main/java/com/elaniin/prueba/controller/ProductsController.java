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
import java.util.List;
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
     * @param produto
     * @return
     */
    @PostMapping(value = "produtos", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<?> addProducto(@RequestBody Producto produto) {
        Map<String, Object> hasmap = new HashMap<>();        
        if(produto.getNombre() !=null && !produto.getNombre().isEmpty() && produto.getCantidad() != 0 && produto.getPrecio() != 0.0){
            generateResponseOk(productServices.addProducto(produto));
            hasmap.put("status", true);
            hasmap.put("message", "Producto agregado exitosamente");
        }else{
            hasmap.put("status", false);
            hasmap.put("message", "Hay campos obligatorios vacios, favor validar.");
        }
        
        return generateResponseOk(hasmap);
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
        Map<String, Object> hasmap = new HashMap<>();        
        if(produto.getNombre() !=null && !produto.getNombre().isEmpty() && produto.getCantidad() != 0 && produto.getPrecio() != 0.0){
            generateResponseOk(productServices.updateProducto(produto));
            hasmap.put("status", true);
            hasmap.put("message", "Producto agregado exitosamente");
        }else{
            hasmap.put("status", false);
            hasmap.put("message", "Hay campos obligatorios vacios, favor validar.");
        }
        
        return generateResponseOk(hasmap);
    }

    /**
     * Return all data
     * @param page
     * @param limit
     * @return
     */
    @GetMapping(value = "produtos", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<?> allProductos(@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "30") int limit) {
        return generateResponseOk(productServices.allProducto(page, limit));
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
        Map<String, Object> hasmap = new HashMap<>();
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
