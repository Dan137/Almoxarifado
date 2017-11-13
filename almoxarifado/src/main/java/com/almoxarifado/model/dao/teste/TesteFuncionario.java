/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model.dao.teste;

import com.almoxarifado.controller.FuncionarioControler;
import com.almoxarifado.model.Funcionario;
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
        FuncionarioControler funcionarioCtrl = new FuncionarioControler();
        Funcionario funcionario;
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
            switch (op) {
                case 1:
                    System.out.println("informe o nome do funcionario");
                    nome = sc.next();

                    System.out.println("informe o cargo do funcionario");
                    cargo = sc.next();

                    System.out.println("informe o cpf do funcionario");
                    cpf = sc.next();

                    System.out.println("informe a data de admissao do funcionario ");
                    dataAdmissao = sc.next();

                    System.out.println("informe o telefone do funcionario");
                    telefone = sc.next();

                    System.out.println("informe a matricula do funcionario");
                    matricula = sc.next();

                    funcionario = new Funcionario(0, matricula, nome, cargo, cpf, dataAdmissao, telefone /*TesteFuncionario.getMateriais()*/);
                    funcionarioCtrl.cadastrar(funcionario);
                    break;
                case 2:
                    System.out.println("alterar o nome do funcionario");
                    nome = sc.next();

                    System.out.println("alterar o cargo do funcionario");
                    cargo = sc.next();

                    System.out.println("alterar o cpf do funcionario");
                    cpf = sc.next();

                    System.out.println("alterar a data de admissao");
                    dataAdmissao = sc.next();

                    System.out.println("alterar o telefone do funcionario");
                    telefone = sc.next();

                    System.out.println("alterar a matricula do funcionario");
                    matricula = sc.next();

                    System.out.println("informe o codigo do funcionario para alteração");
                    id = sc.nextInt();

//                    funcionario = new Funcionario(id, nome, matricula, cargo, cpf, dataAdmissao, telefone);
//                    funcionarioCtrl.alterar(funcionario);
                    break;
                case 3:
                    List<Funcionario> funcionarios = funcionarioCtrl.listarTodos();
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
                    funcionario = funcionarioCtrl.consultaPorId(id);

                    System.out.println("nome: " + funcionario.getNome());
                    System.out.println("codigo: " + funcionario.getCodigo());
                    System.out.println("CPF: " + funcionario.getCpf());
                    System.out.println("matricula: " + funcionario.getMatricula());
                    System.out.println("cargo: " + funcionario.getCargo());
                    System.out.println("dataAdmissao: " + funcionario.getDataAdmissao());
                    System.out.println("telefone: " + funcionario.getTelefone());
                    break;
                case 5:
                    System.out.println("informe o id para deletar");
                    id = sc.nextInt();
                    funcionario = funcionarioCtrl.consultaPorId(id);
                    funcionarioCtrl.deletar(funcionario);
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
