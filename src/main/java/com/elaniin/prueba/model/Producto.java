/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elaniin.prueba.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorgep503
 */
@Entity
@Table(name = "PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.productoPK.id = :id"),
    @NamedQuery(name = "Producto.findBySku", query = "SELECT p FROM Producto p WHERE p.sku = :sku"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByCantidad", query = "SELECT p FROM Producto p WHERE p.productoPK.cantidad = :cantidad"),
    @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductoPK productoPK;
    @Size(max = 50)
    @Column(name = "SKU")
    private String sku;
    @Size(max = 150)
    @Column(name = "NOMBRE")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO")
    private BigDecimal precio;
    @Size(max = 300)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Lob
    @Size(max = 32700)
    @Column(name = "IMAGEN")
    private String imagen;

    public Producto() {
    }

    public Producto(ProductoPK productoPK) {
        this.productoPK = productoPK;
    }

    public Producto(long id, int cantidad) {
        this.productoPK = new ProductoPK(id, cantidad);
    }

    public ProductoPK getProductoPK() {
        return productoPK;
    }

    public void setProductoPK(ProductoPK productoPK) {
        this.productoPK = productoPK;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoPK != null ? productoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.productoPK == null && other.productoPK != null) || (this.productoPK != null && !this.productoPK.equals(other.productoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.elaniin.prueba.model.Producto[ productoPK=" + productoPK + " ]";
    }
    
}
