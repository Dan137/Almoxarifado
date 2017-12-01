/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model.Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "Insumo")
public class Insumo implements Serializable {

    @Id
    @GeneratedValue
    private Integer codigo;
    @Column(length = 50)
    private String nome;
    @Column(length = 200)
    private String descricao;
    @Column(length = 40)
    private String estado;
    @ManyToOne
    @JoinColumn(name = "compraAutorizada_id")
    private ComprasAutorizadas compraAutorizada;
    @ManyToOne
    @JoinColumn(name = "emprestimo_id")
    private Emprestimo emprestimo;
//    @ManyToOne
//    @JoinColumn(name = "funcionario_id")
//    private Funcionario funcionario;
    @Column(length = 40)
    private String tipo;

    public Insumo() {
    }

    public Insumo(Integer codigo, String nome, String descricao, String estado, ComprasAutorizadas compraAutorizada, Emprestimo emprestimo, /*Funcionario funcionario,*/ String tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.compraAutorizada = compraAutorizada;
        this.emprestimo = emprestimo;
        this.estado = estado;
//        this.funcionario = funcionario;
        this.tipo = tipo;

    }

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

//    public Funcionario getFuncionario() {
//        return funcionario;
//    }
//
//    public void setFuncionario(Funcionario funcionario) {
//        this.funcionario = funcionario;
//    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ComprasAutorizadas getCompraAutorizada() {
        return compraAutorizada;
    }

    public void setCompraAutorizada(ComprasAutorizadas compraAutorizada) {
        this.compraAutorizada = compraAutorizada;
    }

    @Override
    public String toString() {
        return "Insumo{" + "codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", estado=" + /*funcionario */ ", tipo=" + tipo + '}';
    }

}
