/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.material;

import com.almoxarifado.controller.MaterialControler;
import com.almoxarifado.model.Material;
import com.almoxarifado.model.dao.MaterialDao;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class ListarTud_Materiais {

    public static void main(String[] args) {
        List<Material> materiais;
        
        MaterialControler materialcontroler = new MaterialControler();
        materiais = materialcontroler.listarTudo();
        
        System.out.println("====lista de materiais====");
        for (int i=0; i<materiais.size(); i++) {
            System.out.println("codigo: "+materiais.get(i).getCodigo());
            System.out.println("Nome: "+materiais.get(i).getNome());
            System.out.println("=====================================");
            
        }
    }

}


