/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elaniin.prueba.dao;

import com.elaniin.prueba.model.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
/**
 *
 * @author Jorgep503
 */
public interface ProductRepository extends CrudRepository<Producto, Integer>{
    
    @Query("SELECT p FROM Producto p WHERE upper(p.nombre) LIKE %:parametro% or upper(p.sku) LIKE %:parametro%" )
    List<Producto> findByParamLike(@Param("Parametro") String parametro);
}
