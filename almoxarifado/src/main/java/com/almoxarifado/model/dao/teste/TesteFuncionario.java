/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model.dao.teste;

import com.almoxarifado.controller.FuncionarioControler;
import com.almoxarifado.model.Entidades.Funcionario;
import com.almoxarifado.model.FuncionarioModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class TesteFuncionario {

    public static void main(String[] args) {
        Integer id = 0;
        String nome;
        String cargo;
        String cpf;
        String dataAdmissao;
        String telefone;
        String matricula;
        FuncionarioModel funcionarioModel = new FuncionarioModel();

        Scanner sc = new Scanner(System.in);
        int op = 0;
        do {
            System.out.println("informe a opcao\n"
                    + "1. cadastrar funcionario\n"
                    + "2. atualizar funcionario\n"
                    + "3. apresentar todos os funcionarios cadastrados\n"
                    + "4. buscar o funcionario pelo ID\n"
                    + "5. deletar um funcionario");
            op = sc.nextInt();

            Date dataCadastro = new Date();
            SimpleDateFormat formataDate = new SimpleDateFormat("dd/MM/yyyy");
            String dataHoje = formataDate.format(dataCadastro);
            switch (op) {

                case 1:

                    List<Funcionario> lista = new ArrayList<>();

                    Funcionario funcionario1 = new Funcionario(0, "20152d13gr0059", "Daniel", "A.S.G", "703.968.604-00", dataCadastro, "(87) 9.8135-5794" /*TesteFuncionario.getMateriais()*/);
                    Funcionario funcionario2 = new Funcionario(0, "20141d14gr4321", "everton", "A.S.G", "123.456.678-91", dataCadastro, "(87) 9.8153-3492" /*TesteFuncionario.getMateriais()*/);
                    Funcionario funcionario3 = new Funcionario(0, "1d123kjfd", "tiago", "gari", "132.132.149.93", dataCadastro, "(87) 9.8133-3938" /*TesteFuncionario.getMateriais()*/);

                    lista.add(funcionario1);
                    lista.add(funcionario2);
                    lista.add(funcionario3);

                    for (Funcionario f : lista) {
                        funcionarioModel.salvar(f);
                    }
                    break;

                case 2:
                    Funcionario funcionario = new Funcionario(2, "2d3c4a", "Noemi", "A.S.G", "153.834.434-02", dataCadastro, "(87)9.8135-3212");
                    funcionarioModel.atualizar(funcionario);
                    break;
                case 3:
                    List<Funcionario> funcionarios = funcionarioModel.findAll();
                    System.out.println("funcionarios cadastrados");
                    for (Funcionario f : funcionarios) {
                        System.out.println("nome: " + f.getNome());
                        System.out.println("codigo: " + f.getCodigo());
                        System.out.println("matricula: " + f.getMatricula());
                        System.out.println("CPF: " + f.getCpf());
                        System.out.println("cargo: " + f.getCargo());
                        System.out.println("dataAdmissao: " + f.getDataAdmissao());
                        System.out.println("telefone: " + f.getTelefone());
                        System.out.println("================================\n");

                    }
                    break;
                case 4:
                    System.out.println("digite o ID para buscar o funcionario");
                    id = sc.nextInt();
                    funcionario1 = funcionarioModel.buscarPeloId(id);

                    System.out.println("nome: " + funcionario1.getNome());
                    System.out.println("codigo: " + funcionario1.getCodigo());
                    System.out.println("CPF: " + funcionario1.getCpf());
                    System.out.println("matricula: " + funcionario1.getMatricula());
                    System.out.println("cargo: " + funcionario1.getCargo());
                    System.out.println("dataAdmissao: " + funcionario1.getDataAdmissao());
                    System.out.println("telefone: " + funcionario1.getTelefone());
                    break;
                case 5:
                    System.out.println("informe o id para deletar");
                    id = sc.nextInt();
                    funcionario1 = funcionarioModel.buscarPeloId(id);
                    funcionarioModel.deletar(funcionario1);
            }

        } while (op != 0);

    }
    /*
    public static List<Material> getMateriais() {
        Scanner sc = new Scanner(System.in);
        Integer id = 0;
        List<Material> materiais = new ArrayList();
        MaterialControler ctrl = new MaterialControler();
        Material material;

        do {
            System.out.println("informe o id do material ou o digite 0 para sair! ");
            id = sc.nextInt();

            material = ctrl.listaId(id);
            materiais.add(material);

        } while (id != 0);
        return materiais;
    }
     */
}
