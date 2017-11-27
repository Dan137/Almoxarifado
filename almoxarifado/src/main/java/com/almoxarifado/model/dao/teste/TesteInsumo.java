/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model.dao.teste;

import com.almoxarifado.controller.ComprasAutorizadasControler;
import com.almoxarifado.controller.EmprestimoControler;
import com.almoxarifado.controller.FuncionarioControler;
import com.almoxarifado.controller.InsumoControler;
import com.almoxarifado.model.ComprasAutorizadas;
import com.almoxarifado.model.Emprestimo;
import com.almoxarifado.model.Funcionario;
import com.almoxarifado.model.Insumo;
import com.almoxarifado.model.dao.InsumoDao;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class TesteInsumo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nome;
        String descricao;
        String estado;
        String tipo = " ";
        Emprestimo emprestimo= null;
        ComprasAutorizadas comp_auto = null;
        InsumoControler insumocontroler = new InsumoControler();
        
        int op = 0;
        do {

            System.out.println("informe a opção\n"
                    + "0. sair\n"
                    + "1. cadastrar\n"
                    + "2. atualizar\n"
                    + "3. remover\n"
                    + "4. listar todos os insumos\n"
                    + "5. listar pelo id\n"
                    + "6. exibir uma quantidade de insumos cadastrados");

            op = sc.nextInt();
            Insumo insumo1;
            switch (op) {
                
                case 1:
                    
                    insumo1 = new Insumo(0, "Tijolo_8Furos", "Unidade", null, null, "material");
                    insumocontroler.cadastrar(insumo1);
                    break;
                case 2:
                    
                    insumo1 = new Insumo(30, "cimento", "saco", getComprasAutorizadas(31),  getEmprestimo(34), "material");
                    insumocontroler.alterar(insumo1);
                    break;

                case 3:
                   
                    insumo1= insumocontroler.listaId(35);
                    insumocontroler.deletar(insumo1);
                    break;
                    
                case 4:
                    List <Insumo> insumos = insumocontroler.listarTudo();
                    System.out.println("todos os insumos cadastrados");
                    for(Insumo ins: insumos){
                        System.out.println("Codigo: "+ins.getCodigo());
                        System.out.println("Nome: "+ins.getNome());
                        System.out.println("Descrição: "+ins.getDescricao());
                        System.out.println("Funcionario: "+ins.getEmprestimo().getId());
                        System.out.println("compras autorizada"+ ins.getCompraAutorizada().getId());
                        System.out.println("Tipo: "+ins.getTipo());
                        System.out.println("====================================\n");
                    }
                    break;
                case 5:
                    
                    insumo1=insumocontroler.listaId(30);
                    System.out.println("Codigo: "+insumo1.getCodigo());
                        System.out.println("Nome: "+insumo1.getNome());
                        System.out.println("Descrição: "+insumo1.getDescricao());
                        System.out.println("Funcionario: "+insumo1.getCompraAutorizada().getId());
                        System.out.println("Funcionario: "+insumo1.getEmprestimo().getId());
                        System.out.println("Tipo: "+insumo1.getTipo());
                        break;
                        
                case 6:
                    int quantidade = CalcQuantidadeInsumos("carrinho");
                                
                        
            }
        } while (op != 0);

    } 

   

    public static int CalcQuantidadeInsumos(String name) {
        List<Insumo> insumos = InsumoDao.getInstance().listarTudo();
        int cont = 0;

        for (Insumo m : insumos) {
            if (name.equalsIgnoreCase(m.getNome())) {
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println("insumo não cadastrado!\n"
                    + "verifique o nome do material informado e digite novamente");

        }
        return cont;
    }
    public static Emprestimo getEmprestimo(Integer id){
        EmprestimoControler ctrl = new EmprestimoControler();
        return ctrl.findId(id);
    }
    
    public static ComprasAutorizadas getComprasAutorizadas(Integer id){
        ComprasAutorizadasControler ctrl = new ComprasAutorizadasControler();
        return ctrl.buscarID(id);
    }

}
