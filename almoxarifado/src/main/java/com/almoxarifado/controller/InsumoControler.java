/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.controller;

import com.almoxarifado.model.Insumo;
import com.almoxarifado.model.dao.InsumoDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Daniel
 */
@ManagedBean (name = "materialBean")
@SessionScoped
public class InsumoControler {
    private Insumo material;
    private Insumo selectedMaterial;
    
    public InsumoControler() {
        material = new Insumo();
    }
    public void cadastrar(Insumo material){
        InsumoDao.getInstance().cadastrar(material);
    }
    public void alterar  (Insumo insumo){
        InsumoDao.getInstance().alterar(insumo);
    }
    public void  deletar (Insumo insumo){
        InsumoDao.getInstance().deletar(insumo);
    }
    public List <Insumo> listarTudo (){
        List<Insumo> materiais = InsumoDao.getInstance().listarTudo();
        return materiais;
        
    }
    public Insumo listaId (Integer codigo){
        Insumo material=InsumoDao.getInstance().listaId(codigo);
        
        return material;
    
}

    /**
     * @return the material
     */
    public Insumo getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(Insumo material) {
        this.material = material;
    }

    public Insumo getSelectedMaterial() {
        return selectedMaterial;
    }

    public void setSelectedMaterial(Insumo selectedMaterial) {
        this.selectedMaterial = selectedMaterial;
    }
    
}
