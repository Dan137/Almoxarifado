/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.controller;

import com.almoxarifado.model.Entidades.ComprasAutorizadas;
import com.almoxarifado.model.Entidades.Insumo;
import com.almoxarifado.model.dao.ComprasAutorizadasDao;
import com.almoxarifado.model.dao.InsumoDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Daniel
 */
@ManagedBean
@SessionScoped
public class ComprasAutorizadasControler {
    private List<Insumo> insumo;
    private ComprasAutorizadas compras;
    private Insumo insumos;
    public ComprasAutorizadasControler() {
        insumo = new ArrayList<>();
        compras = new ComprasAutorizadas();
        insumos = new Insumo();
    }

    public void inserir() {
        compras.setInsumos(insumo);
        ComprasAutorizadasDao.getInstance().cadastrar(compras);
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
    public void inserirInsumos(){

        InsumoDao.getInstance().cadastrar(insumos);
        insumo.add(InsumoDao.getInstance().listaId(insumos.getCodigo()));
    }
    
   public List<ComprasAutorizadas> findAll(){
       
       List <ComprasAutorizadas> compras = ComprasAutorizadasDao.getInstance().listarTudo();
       return compras;
   }

    public ComprasAutorizadas getCompras() {
        return compras;
    }

    public List<Insumo> getInsumo() {
        return insumo;
    }

    public void setCompras(ComprasAutorizadas compras) {
        this.compras = compras;
    }

    public void setInsumo(List<Insumo> insumo) {
        this.insumo = insumo;
    }

    public Insumo getInsumos() {
        return insumos;
    }

    public void setInsumos(Insumo insumos) {
        this.insumos = insumos;
    }
   
}
