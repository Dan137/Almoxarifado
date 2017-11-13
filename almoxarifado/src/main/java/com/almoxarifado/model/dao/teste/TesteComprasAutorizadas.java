/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model.dao.teste;

import com.almoxarifado.controller.ComprasAutorizadasControler;
import com.almoxarifado.model.ComprasAutorizadas;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class TesteComprasAutorizadas {

    public static void main(String[] args) {
        /*
        this.dataCompra = dataCompra;
        this.id = id;
        this.dataCompra = dataCompra;
        this.insumos = insumos;
        
       Date dataHoje = new Date();
        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
        String data = formataData.format(dataHoje);
    }
         */
        int op = 0;
        Scanner sc = new Scanner(System.in);
        ComprasAutorizadasControler ctrl = new ComprasAutorizadasControler();
        ComprasAutorizadas comp_auto = new ComprasAutorizadas();
        do {
            System.out.println("digite a opção\n"
                    + "1. cadastrar");
            op = sc.nextInt();
            switch (op) {
                case 1:
//                    cadastra uma compra
                    Date dataCompra = new Date();
                    SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
                    String data = formataData.format(dataCompra);

                    comp_auto = new ComprasAutorizadas(0, dataCompra, null);
                    ctrl.inserir(comp_auto);

            }

        } while (op != 0);

    }
}
