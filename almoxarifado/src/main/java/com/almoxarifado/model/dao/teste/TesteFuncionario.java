/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model.dao.teste;

import com.almoxarifado.controller.FuncionarioControler;
import com.almoxarifado.model.Funcionario;
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
        Scanner sc = new Scanner(System.in);
        int op = 0;
        do {
            System.out.println("informe a opcao\n"
                    + "1. cadastrar funcionario\n"
                    + "2. atualizar funcionario");
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

                    Funcionario funcionario = new Funcionario(id, nome, matricula, cargo, cpf, dataAdmissao, telefone);
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

                    funcionario = new Funcionario(id, nome, matricula, cargo, cpf, dataAdmissao, telefone);
                    funcionarioCtrl.alterar(funcionario);
            }

        } while (op != 0);

    }
}
