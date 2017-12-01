/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model.dao;

import com.almoxarifado.model.Entidades.Funcionario;

/**
 *
 * @author Daniel
 */
public interface FuncionarioInterface extends DaoGenerico <Funcionario>{
   
    
    public Funcionario queryByMatricula(String matricula);
}
