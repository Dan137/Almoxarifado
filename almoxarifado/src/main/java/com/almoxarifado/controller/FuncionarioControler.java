/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.controller;

import com.almoxarifado.model.Funcionario;
import com.almoxarifado.model.dao.FuncionarioDao;

/**
 *
 * @author Daniel
 */
public class FuncionarioControler {
    private Funcionario funcionario;

    public FuncionarioControler() {
        funcionario = new Funcionario();
    }
    
    public void cadastrar(Funcionario funcionario){
        FuncionarioDao.getInstance().cadastrar(funcionario);
    }
    
     public void alterar (Funcionario funcionario){
        FuncionarioDao.getInstance().alterar(funcionario);
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
}
