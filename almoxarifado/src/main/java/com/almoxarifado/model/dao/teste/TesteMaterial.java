/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model.dao.teste;

import com.almoxarifado.controller.MaterialControler;
import com.almoxarifado.model.Material;
import com.almoxarifado.model.dao.MaterialDao;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class TesteMaterial {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String nome;
        Material material = new Material();
        MaterialControler materialcontroler = new MaterialControler();
        int op = 0;
        do {
            System.out.println("informe a opção\n"
                    + "1.cadastrar Material\n"
                    + "2.alterar Material\n"
                    + "3.Listar um Material\n"
                    + "4.Listar todos os materiais\n"
                    + "5.Remover material");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("informe o nome do material");
                    nome = sc.next();
                    material.setNome(nome);

                    materialcontroler.cadastrar(material);
                    break;
                case 2:
                    Integer cod;

                    System.out.println("informe o codigo do material para alteração");
                    cod = sc.nextInt();

                    System.out.println("informe o novo nome do material");
                    nome = sc.next();

                    material = new Material(cod, nome);
                    materialcontroler.alterar(material);
                    break;
                case 3:

                    Integer id = 0;
                    System.out.println("informe o codigo do material para busca");
                    id = sc.nextInt();
                    material = materialcontroler.listaId(id);

                    if (id == material.getCodigo()) {
                        System.out.println(material.getCodigo());
                        System.out.println(material.getNome());

                    }
                    break;
                case 4:
                    List<Material> materiais;

                    materiais = materialcontroler.listarTudo();

                    System.out.println("====lista de materiais====");
                    for (int i = 0; i < materiais.size(); i++) {
                        System.out.println("codigo: " + materiais.get(i).getCodigo());
                        System.out.println("Nome: " + materiais.get(i).getNome());
                        System.out.println("=====================================");

                    }
                    break;
                case 5:

                    Integer id_rem = 0;

                    System.out.println("informe o codigo para deletar o material");
                    id_rem = sc.nextInt();
                    material = MaterialDao.getInstance().listaId(id_rem);
                    materialcontroler.deletar(material);
                    break;
                default :
                    System.out.println("Opção inválida");
            }
            
        } while (op != 0);

    }
}
