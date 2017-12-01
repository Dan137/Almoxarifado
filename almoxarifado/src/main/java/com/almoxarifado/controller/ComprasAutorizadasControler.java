/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.controller;

import com.almoxarifado.model.Entidades.ComprasAutorizadas;
import com.almoxarifado.model.dao.ComprasAutorizadasDao;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class ComprasAutorizadasControler {

    public ComprasAutorizadasControler() {

    }

    public void inserir(ComprasAutorizadas comp_auto) {
        ComprasAutorizadasDao.getInstance().cadastrar(comp_auto);
    }

    public void altera(ComprasAutorizadas comp_auto) {
        ComprasAutorizadasDao.getInstance().alterar(comp_auto);
    }
    
    public void delete (ComprasAutorizadas comp_auto){
        ComprasAutorizadasDao.getInstance().deletar(comp_auto);
    }

    public ComprasAutorizadas buscarID(int id) {
        return ComprasAutorizadasDao.getInstance().listaId(id);
    }
    
   public List<ComprasAutorizadas> findAll(){
       
       List <ComprasAutorizadas> compras = ComprasAutorizadasDao.getInstance().listarTudo();
       return compras;
   }
}
