/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elaniin.prueba.service;

import com.elaniin.prueba.model.Producto;
import java.util.List;
/**
 *
 * @author Jorgep503
 */
public interface ProductServices {
    Producto addProducto(Producto producto);
    Producto updateProducto(Producto producto);
    List<Producto> allProducto();
    List<Producto> findProductoByNombreAndSku(String nombre, String SKU);
    void deleteProducto(Integer id);
    List<Producto> allProducto(int page, int limit);
    List<Producto> allProductoBySKU(String SKU);
    List<Producto> allProductoByNombre(String nombre);
}
