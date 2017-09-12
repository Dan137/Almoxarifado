/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.material;

import com.almoxarifado.controller.MaterialControler;
import com.almoxarifado.model.Material;

import java.util.Scanner;



/**
 *
 * @author Daniel
 */
public class Listar_Id{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer id =0;
        Material material = new Material();
        MaterialControler materialcontroler= new MaterialControler();
        System.out.println("informe o codigo do material para busca");
        id = sc.nextInt();
        material = materialcontroler.listaId(id);
        
        if(id==material.getCodigo()){
            System.out.println(material.getCodigo());
            System.out.println(material.getNome());
            
        }
        
    }
}
