/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model.Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daniel
 */
@Entity
public class Emprestimo implements Serializable{

    @Id
    @GeneratedValue()
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    private Funcionario funcionario;
    @OneToMany(targetEntity = Insumo.class, mappedBy = "emprestimo",cascade = CascadeType.ALL, fetch = FetchType.EAGER) 
    private List<Insumo> insumos;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Emprestimo() {
    }

    public Emprestimo(Integer id, Funcionario funcionario, List<Insumo> insumos, Date date) {
        this.id = id;
        this.funcionario = funcionario;
        this.insumos = insumos;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Insumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<Insumo> insumos) {
        this.insumos = insumos;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
