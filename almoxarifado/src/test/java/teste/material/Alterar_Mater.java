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
public class Alterar_Mater {

    public static void main(String[] args) {
        Integer cod;
        String nome;
        Scanner sc = new Scanner(System.in);
        MaterialControler materialcontroler = new MaterialControler();
        System.out.println("informe o codigo do material para alteração");
        cod = sc.nextInt();

        System.out.println("informe o novo nome do material");
        nome = sc.next();

        Material material = new Material(cod, nome);
        materialcontroler.alterar(material);

    }
}
