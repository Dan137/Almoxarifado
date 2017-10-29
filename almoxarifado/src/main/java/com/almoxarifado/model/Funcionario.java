/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Daniel
 */
@Entity
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue()
    private Integer codigo;
    @Column(length =20)
    private String matricula;
    @Column(length = 50)
    private String nome;
    @Column(length = 40)
    private String cargo;
    @Column(length = 11)
    private String cpf;
    @Column(length = 8)
    private String dataAdmissao;
    @Column(length = 15)
    private String telefone;

    public Funcionario() {
    }
    
    

    public Funcionario(Integer codigo, String nome, String matricula, String cargo, String cpf, String dataAdmissao, String telefone) {
        this.codigo=codigo;
        this.nome = nome;
        this.matricula=matricula;
        this.cargo = cargo;
        this.cpf = cpf;
        this.dataAdmissao = dataAdmissao;
        this.telefone = telefone;
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

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
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

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    

}
