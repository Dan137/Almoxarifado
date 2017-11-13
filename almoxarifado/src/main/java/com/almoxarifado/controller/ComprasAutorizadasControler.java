/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.controller;

import com.almoxarifado.model.ComprasAutorizadas;
import com.almoxarifado.model.dao.ComprasAutorizadasDao;

/**
 *
 * @author Daniel
 */
public class ComprasAutorizadasControler {
    
    public ComprasAutorizadasControler() {
        
    }
    public void inserir(ComprasAutorizadas comp_auto){
        ComprasAutorizadasDao.getInstance().cadastrar(comp_auto);
    }
    public ComprasAutorizadas buscarID(int id){
        return ComprasAutorizadasDao.getInstance().listaId(id);
    }
    
}
