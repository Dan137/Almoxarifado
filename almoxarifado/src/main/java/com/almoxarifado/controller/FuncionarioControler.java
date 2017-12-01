/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.controller;

import com.almoxarifado.Util.Messages;
import com.almoxarifado.model.Entidades.Funcionario;
import com.almoxarifado.model.dao.FuncionarioDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Daniel
 */
@ManagedBean(name="funcionaroBean")
@SessionScoped
public class FuncionarioControler {

    private Funcionario funcionario;

    public FuncionarioControler() {
        funcionario = new Funcionario();
    }

    public void cadastrar(Funcionario funcionario) {
        FuncionarioDao.getInstance().cadastrar(funcionario);
        limpar();
   Messages.getInstance().adicionarMensagem(null, "Funcionario cadastrado com sucesso!", FacesMessage.SEVERITY_INFO);
        
    }

    public void alterar(Funcionario funcionario) {
        FuncionarioDao.getInstance().alterar(funcionario);
        limpar();
        Messages.getInstance().adicionarMensagem(null, "Funcionario Alterado com sucesso!", FacesMessage.SEVERITY_INFO);
   
    }

    public List<Funcionario> listarTodos() {
        return FuncionarioDao.getInstance().listarTudo();
    }

    public Funcionario consultaPorMatricula(String matricula) {
        return FuncionarioDao.getInstance().queryByMatricula(matricula);
    }

    public Funcionario consultaPorId(Integer id) {
        return FuncionarioDao.getInstance().listaId(id);
    }
    public void limpar(){
        funcionario = new Funcionario();
    }

    public void deletar(Funcionario funcionario) {
        FuncionarioDao.getInstance().deletar(funcionario);
        Messages.getInstance().adicionarMensagem(null, "Funcionario Deletado com sucesso!", FacesMessage.SEVERITY_INFO);
   
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
