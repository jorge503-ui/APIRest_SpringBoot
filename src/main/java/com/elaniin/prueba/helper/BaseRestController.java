/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elaniin.prueba.helper;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/**
 *
 * @author Jorgep503
 */
public class BaseRestController {
    public ResponseEntity<?> generateResponseOk(Object object){
        return new ResponseEntity<>(object, HttpStatus.OK);
    }
}
