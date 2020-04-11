/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elaniin.prueba.service;
import com.elaniin.prueba.dao.ProductRepository;
import com.elaniin.prueba.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
/**
 *
 * @author Jorgep503
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductServices{

    @Autowired
    ProductRepository productRepository;
    
    @Override
    public Producto addProducto(Producto producto) {
        return productRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Producto producto) {
        return productRepository.save(producto);
    }

    @Override
    public List<Producto> allProducto() {
        List<Producto> producto=new ArrayList<>();
        for (Producto meeting:productRepository.findAll()) {
            producto.add(meeting);
        }
        return producto;
    }

    @Override
    public List<Producto> findProductoByNombreAndSku(String nombre, String SKU) {
        List<Producto> producto=new ArrayList<>();
        for (Producto meeting : productRepository.findProductoByNombreAndSku(nombre.toUpperCase(),SKU.toUpperCase())) {
            producto.add(meeting);
        }
        return producto;
    }

    @Override
    public void deleteProducto(Integer id) {
        productRepository.deleteById(id.longValue());
    }

    @Override
    public List<Producto> allProducto(int page, int limit) {
        Pageable pageableRequest = PageRequest.of(page, limit);
        Page<Producto> productos = productRepository.findAll(pageableRequest);
        List<Producto> productEntities = productos.getContent();
        return productEntities;
    }

    @Override
    public List<Producto> allProductoBySKU(String SKU) {
        return productRepository.findBySkuContainingIgnoreCase(SKU.toUpperCase());
    }

    @Override
    public List<Producto> allProductoByNombre(String nombre) {
        return productRepository.findByNombreContainingIgnoreCase(nombre.toUpperCase());
    }
    
}
