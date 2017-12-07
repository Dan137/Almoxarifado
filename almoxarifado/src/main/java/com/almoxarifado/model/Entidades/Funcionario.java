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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Daniel
 */
@Entity
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue()
    private Integer codigo;
    @Column(length = 25)
    private String matricula;
    @Column(length = 50)
    private String nome;
    @Column(length = 40)
    private String cargo;
    @Column(length = 20)
    private String cpf;
    @Column(length = 20)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAdmissao;
    @Column(length = 25)
    private String telefone;
   
//     @OneToMany(targetEntity = Insumo.class, mappedBy = "funcionario", cascade = CascadeType.ALL,
//                fetch = FetchType.EAGER)
//    private List<Insumo> materiais;

    public Funcionario() {
    }

    public Funcionario(Integer codigo, String matricula, String nome, String cargo, String cpf, Date dataAdmissao, String telefone /*List<Material> material*/) {
        this.codigo = codigo;
        
        this.matricula = matricula;
        this.nome = nome;
        this.cargo = cargo;
        this.cpf = cpf;
        this.dataAdmissao = dataAdmissao;
        this.telefone = telefone;
//        this.materiais = materiais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

   
//    public List<Insumo> getMateriais() {
//        return materiais;
//    }
//
//    public void setMateriais(List<Insumo> materiais) {
//        this.materiais = materiais;
//    }

}
