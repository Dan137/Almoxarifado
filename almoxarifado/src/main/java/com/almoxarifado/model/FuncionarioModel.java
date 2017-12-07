/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model;

import com.almoxarifado.Util.Messages;
import com.almoxarifado.controller.FuncionarioControler;
import com.almoxarifado.model.Entidades.Funcionario;
import com.almoxarifado.model.dao.DaoGenerico;
import com.almoxarifado.model.dao.FuncionarioDao;
import java.util.List;
import javax.faces.application.FacesMessage;

/**
 *
 * @author Daniel
 */
public class FuncionarioModel {

    private DaoGenerico<Funcionario> dao;
    private Funcionario func;

    public FuncionarioModel() {
        dao = new FuncionarioDao();
    }

    public void salvar(Funcionario fun) {
        try {
            if (dao.listaId(fun.getCodigo())==null) {
                dao.cadastrar(fun);
            }
            Messages.getInstance().adicionarMensagem(null, "Funcionario cadastrado com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (Exception ex) {
            System.out.println("Erro ao salvar funcionarioModel");
        }

    }

    public void atualizar(Funcionario fun) {
        try {
            dao.alterar(fun);
        } catch (Exception e) {
            System.out.println("Erro ao alterar o funcionario");
        }
    }

    public List<Funcionario> findAll() {
        try {
            return dao.listarTudo();

        } catch (Exception e) {
            System.out.println("erro ao visualizar os funcionarios");
        }
        return null;
    }

    public Funcionario buscarPeloId(int id) {
        try {
            return dao.listaId(id);
        } catch (Exception e) {
            System.out.println("erro ao buscar o funcionario");
        }
        return null;
    }

    public void deletar(Funcionario funcionario) {
        try {
            dao.deletar(funcionario);
        } catch (Exception e) {
            System.out.println("erro ao deletar um funcionario");
        }

    }
}
