/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.controller;

import com.almoxarifado.model.Emprestimo;
import com.almoxarifado.model.dao.EmprestimoDao;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class EmprestimoControler {

    
    public void inserir(Emprestimo emprestimo){
        EmprestimoDao.getInstance().cadastrar(emprestimo);
    }
    
    public void update (Emprestimo emprestimo){
        EmprestimoDao.getInstance().alterar(emprestimo);
    }
    
    public void remover (Emprestimo emprestimo){
        EmprestimoDao.getInstance().deletar(emprestimo);
    }
    
    public List <Emprestimo> readAll(){
        return EmprestimoDao.getInstance().listarTudo();
    }
    
    public Emprestimo findId(Integer id){
        return EmprestimoDao.getInstance().listaId(id);
    }
    
    
    
}
