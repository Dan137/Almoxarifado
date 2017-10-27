/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.controller;

import com.almoxarifado.model.Material;
import com.almoxarifado.model.dao.MaterialDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Daniel
 */
@ManagedBean (name = "materialBean")
@SessionScoped
public class MaterialControler {
    private Material material;
    private Material selectedMaterial;
    
    public MaterialControler() {
        material = new Material();
    }
    public void cadastrar(Material material){
        MaterialDao.getInstance().cadastrar(material);
    }
    public void alterar  (Material material){
        MaterialDao.getInstance().alterar(material);
    }
    public void  deletar (Material material){
        MaterialDao.getInstance().deletar(material);
    }
    public List <Material> listarTudo (){
        List<Material> materiais = MaterialDao.getInstance().listarTudo();
        return materiais;
        
    }
    public Material listaId (Integer codigo){
        Material material=MaterialDao.getInstance().listaId(codigo);
        
        return material;
    
}

    /**
     * @return the material
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    public Material getSelectedMaterial() {
        return selectedMaterial;
    }

    public void setSelectedMaterial(Material selectedMaterial) {
        this.selectedMaterial = selectedMaterial;
    }
    
}
