/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model.dao;

import java.util.List;

/**
 *
 * @author Daniel
 */
public interface DaoGenerico <T> {
    public void cadastrar(T t);
    public void alterar  (T t);
    public void  deletar (T t);
    public List <T> listarTudo ();
    public T listaId (Integer codigo);    
}
