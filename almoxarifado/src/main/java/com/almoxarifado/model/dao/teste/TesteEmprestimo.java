/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model.dao.teste;

import com.almoxarifado.controller.EmprestimoControler;
import com.almoxarifado.controller.FuncionarioControler;
import com.almoxarifado.model.Entidades.Emprestimo;
import com.almoxarifado.model.Entidades.Funcionario;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class TesteEmprestimo {

    public static void main(String[] args) {
        EmprestimoControler emprestimoControler = new EmprestimoControler();
        Emprestimo emprestimo = new Emprestimo();
        int op = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("informe a opção!\n"
                + "1. cadastrar\n"
                + "2. atualizar\n"
                + "3. deletar\n"
                + "4. listar pelo Id\n"
                + "5. listar todos");
        op = sc.nextInt();

        switch (op) {
            case 1:
                List<Emprestimo> listaEmprestimo = new ArrayList<>();

                Date dataHoje = new Date();
                SimpleDateFormat formataDataHoje = new SimpleDateFormat("dd/MM/yyyy");
                String data = formataDataHoje.format(dataHoje);

                emprestimo = new Emprestimo(0, getFuncionario(28), null, dataHoje);
                Emprestimo emprestimo2 = new Emprestimo(0, getFuncionario(29), null, dataHoje);

                listaEmprestimo.add(emprestimo);
                listaEmprestimo.add(emprestimo2);

                for (Emprestimo emp : listaEmprestimo) {
                    emprestimoControler.inserir(emp);
                }

                break;

            case 2:
                Date datHoje = new Date();
                SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
                String dat = formatData.format(datHoje);

                emprestimo.setId(33);
                emprestimo.setDate(datHoje);
                emprestimo.setFuncionario(getFuncionario(26));

                emprestimoControler.update(emprestimo);
                break;

            case 3:
                emprestimo = emprestimoControler.findId(33);
                emprestimoControler.remover(emprestimo);

                break;
            case 4:
                emprestimo = emprestimoControler.findId(34);

                System.out.println("Id: " + emprestimo.getId());
                System.out.println("data: " + emprestimo.getDate());
                System.out.println("funcionario: " + emprestimo.getFuncionario().getCodigo());

                break;
            case 5:
                List<Emprestimo> emprestimos = emprestimoControler.readAll();
                System.out.println("emprestimos cadastrados");
                
                for (Emprestimo e : emprestimos) {
                    System.out.println("id: "+ e.getId());
                    System.out.println("Data : "+ e.getDate());
                    System.out.println("Funcionario: "+e.getFuncionario().getCodigo());

                    System.out.println("==================================");
                }
        }

    }
//    obtém um funcionario

    public static Funcionario getFuncionario(Integer id) {
        FuncionarioControler controler = new FuncionarioControler();
        Funcionario funcionario = controler.consultaPorId(id);

        return funcionario;
    }

}
