/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name="compraautorizada")
public class ComprasAutorizadas implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    @OneToMany(targetEntity = Insumo.class, mappedBy = "compraAutorizada", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Insumo> insumos;

    public ComprasAutorizadas() {

    }

    public ComprasAutorizadas(Integer id, Date dataCompra, List<Insumo> insumos) {
        this.dataCompra = dataCompra;
        this.id = id;
        this.insumos = insumos;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Insumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<Insumo> insumos) {
        this.insumos = insumos;
    }

}
