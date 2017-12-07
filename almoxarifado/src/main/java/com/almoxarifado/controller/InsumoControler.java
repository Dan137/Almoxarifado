/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.controller;

import com.almoxarifado.model.Entidades.Insumo;
import com.almoxarifado.model.dao.InsumoDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Daniel
 */
@ManagedBean (name = "insumoBean")
@SessionScoped
public class InsumoControler {
    private Insumo insumo;
    private Insumo selectedInsumo;
    
    public InsumoControler() {
        insumo = new Insumo();
    }
    public void cadastrar(Insumo insumo){
        InsumoDao.getInstance().cadastrar(insumo);
    }
    public void alterar  (Insumo insumo){
        InsumoDao.getInstance().alterar(insumo);
    }
    public void  deletar (Insumo insumo){
        InsumoDao.getInstance().deletar(insumo);
    }
    public List <Insumo> listarTudo (){
        List<Insumo> insumo = InsumoDao.getInstance().listarTudo();
        return insumo;
        
    }
    public Insumo listaId (Integer codigo){
        Insumo insumo=InsumoDao.getInstance().listaId(codigo);
        
        return insumo;
    
}

    /**
     * @return the insumo
     */
    public Insumo getInsumo() {
        return insumo;
    }

    /**
     * @param material the insumo to set
     */
    public void setMaterial(Insumo insumo) {
        this.insumo = insumo;
    }

    public Insumo getSelectedInsumo() {
        return selectedInsumo;
    }

    public void setSelectedInsumo(Insumo selectedMaterial) {
        this.selectedInsumo = selectedMaterial;
    }
    
}
