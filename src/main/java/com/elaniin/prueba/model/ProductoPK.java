/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elaniin.prueba.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jorgep503
 */
@Embeddable
public class ProductoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;

    public ProductoPK() {
    }

    public ProductoPK(long id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) cantidad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoPK)) {
            return false;
        }
        ProductoPK other = (ProductoPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.elaniin.prueba.model.ProductoPK[ id=" + id + ", cantidad=" + cantidad + " ]";
    }
    
}
