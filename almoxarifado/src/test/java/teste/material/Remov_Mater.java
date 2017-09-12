/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.material;

import com.almoxarifado.controller.MaterialControler;
import com.almoxarifado.model.Material;
import com.almoxarifado.model.dao.MaterialDao;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Remov_Mater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer id;
        MaterialControler materialcontroler = new MaterialControler();
        System.out.println("informe o codigo para deletar o material");
        id=sc.nextInt();
        Material material = MaterialDao.getInstance().listaId(id);
        materialcontroler.deletar(material);
        
        
    }
}
