/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model.dao.teste;

import com.almoxarifado.controller.ComprasAutorizadasControler;
import com.almoxarifado.controller.FuncionarioControler;
import com.almoxarifado.model.ComprasAutorizadas;
import com.almoxarifado.model.Funcionario;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class TesteComprasAutorizadas {
    
    public static void main(String[] args) {
        FuncionarioControler ctrl = new FuncionarioControler();
        
        ComprasAutorizadasControler compr_controler = new ComprasAutorizadasControler();
        Scanner sc = new Scanner(System.in);
        
        int op = 0;
        Date dataHoje = new Date();
        do {
            System.out.println("informe a opção\n"
                    + "1. cadastrar\n"
                    + "2. atualizar\n"
                    + "3. remover\n"
                    + "4. procurar\n"
                    + "5. listar");
            op = sc.nextInt();
            switch (op) {
                //        cadastra a compra autorizada
                case 1:
                    List<ComprasAutorizadas> lista = new ArrayList<>();
                    
                    ComprasAutorizadas comp1 = new ComprasAutorizadas();
                    ComprasAutorizadas comp2 = new ComprasAutorizadas();
                    
                    SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
                    String data = formataData.format(dataHoje);
                    
                    comp1 = new ComprasAutorizadas(0, dataHoje, null, obtemFuncionario(26));
                    comp2 = new ComprasAutorizadas(0, dataHoje, null, obtemFuncionario(27));
                    
                    lista.add(comp1);
                    lista.add(comp2);
                    for (ComprasAutorizadas c : lista) {
                        compr_controler.inserir(c);
                    }
                    
                    break;
                
                case 2:
                    SimpleDateFormat formDate = new SimpleDateFormat("dd/MM/yyyy");
                    String dateToday = formDate.format(dataHoje);
                    
                    ComprasAutorizadas comp = new ComprasAutorizadas(32, dataHoje, null, obtemFuncionario(29));
                    
                    compr_controler.altera(comp);
                    
                    break;
                case 3:
                    ComprasAutorizadas compr = compr_controler.buscarID(31);
                    compr_controler.delete(compr);
                    
                    break;
                case 4:
                    compr = compr_controler.buscarID(32);
                    System.out.println("id:"+ compr.getId());                    
                    System.out.println("data compra:"+ compr.getDataCompra());                    
                    System.out.println("funcionario :"+ compr.getFuncionario().getCodigo());   
                    
                    break;
                case 5:
                     List<ComprasAutorizadas> listaCompras = compr_controler.findAll();
                    System.out.println("Compras autorizadas cadastrados");
                    for (ComprasAutorizadas compra: listaCompras) {
                        System.out.println("Id: " + compra.getId());
                        System.out.println("data da compra: " + compra.getDataCompra());
                        System.out.println("funcionarios " + compra.getFuncionario().getCodigo());
                    }
            }
        } while (op != 0);
        
    }
    
    public static Funcionario obtemFuncionario(Integer id) {
        FuncionarioControler fc = new FuncionarioControler();
        return fc.consultaPorId(id);
    }
    
}
