/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elaniin.prueba.dao;

import com.elaniin.prueba.model.Producto;
import org.springframework.data.repository.query.Param;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
/**
 *
 * @author Jorgep503
 */
public interface ProductRepository extends PagingAndSortingRepository<Producto, Long>{
    
    List<Producto> findByParamLike(@Param("parametro") String parametro);
}
