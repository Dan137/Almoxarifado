/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model;

import com.almoxarifado.Util.Messages;
import com.almoxarifado.model.Entidades.Funcionario;
import com.almoxarifado.model.dao.FuncionarioDao;
import javax.faces.application.FacesMessage;

/**
 *
 * @author Daniel
 */
public class FuncionarioModel {
    private Funcionario funcionario = new Funcionario();
    public FuncionarioModel() {
    }
 
    public void salvar(Funcionario fun){
     try{
         funcionario = FuncionarioDao.getInstance().queryByMatricula(fun.getCpf());
         if(funcionario == null){
    FuncionarioDao.getInstance().cadastrar(fun);
         Messages.getInstance().adicionarMensagem(null, "Funcionario cadastrado com sucesso!", FacesMessage.SEVERITY_INFO);
         }
         }catch(Exception ex){
         System.out.println("Erro ao salvar funcionarioModel");
     }
     }
}
