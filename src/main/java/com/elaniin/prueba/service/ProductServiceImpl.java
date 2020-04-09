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
    public List<Producto> allProducto(String param) {
        List<Producto> producto=new ArrayList<>();
        for (Producto meeting:productRepository.findByParamLike(param.toUpperCase())) {
            producto.add(meeting);
        }
        return producto;
    }

    @Override
    public void deleteProducto(Integer id) {
        productRepository.deleteById(id);
    }
    
}
