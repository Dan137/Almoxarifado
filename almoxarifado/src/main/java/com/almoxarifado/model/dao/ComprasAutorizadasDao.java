/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model.dao;

import HibernateUtil.HibernateUtil;
import com.almoxarifado.model.ComprasAutorizadas;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Daniel
 */
public class ComprasAutorizadasDao implements DaoGenerico<ComprasAutorizadas> {

    private static ComprasAutorizadasDao myself = null;
    private ComprasAutorizadas comp_auto = null;
    private SessionFactory conexao;
    private Session session;
    private List<ComprasAutorizadas> consulta=null;
    
    public ComprasAutorizadasDao() {
        this.conexao=conexao;
        this.consulta=new ArrayList<>();
        this.comp_auto=new ComprasAutorizadas();
    }

    public static ComprasAutorizadasDao getInstance() {
        if (myself == null) {
            myself = new ComprasAutorizadasDao();
        }
        return myself;
    }

    @Override
    public void cadastrar(ComprasAutorizadas t) {
        conexao = HibernateUtil.getSessionFactory();
        session = conexao.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(t);
            tx.commit();
        } catch (Exception erroCadastroComprasAutorizadas) {
            System.out.println("erro ao cadastrar a compra");
            erroCadastroComprasAutorizadas.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Override
    public void alterar(ComprasAutorizadas t) {
        conexao = HibernateUtil.getSessionFactory();
        Session session = conexao.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(t);
            tx.commit();
        } catch (Exception erroAlteraComprasAutorizadas) {
             System.out.println("erro ao alterar a compra");
            erroAlteraComprasAutorizadas.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(ComprasAutorizadas t) {
       conexao = HibernateUtil.getSessionFactory();
        Session session = conexao.openSession();
        Transaction tx = session.beginTransaction();
        try {
            this.consulta=session.createQuery("from ComprasAutorizadas where codigo"+ t.getId()).getResultList();
            t=consulta.get(0);
            session.remove(t);
            tx.commit();
        } catch (Exception erroAlteraComprasAutorizadas) {
             System.out.println("erro ao deletar a compra");
            erroAlteraComprasAutorizadas.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<ComprasAutorizadas> listarTudo() {
        conexao = HibernateUtil.getSessionFactory();
        Session session = conexao.openSession();
        Transaction tx = session.beginTransaction();
        try {
            this.consulta=session.createQuery("from ComprasAutorizadas").getResultList();
            tx.commit();
        } catch (Exception erroAlteraComprasAutorizadas) {
             System.out.println("erro ao deletar a compra");
            erroAlteraComprasAutorizadas.printStackTrace();
        } finally {
            session.close();
        }
        return consulta;
    }

    @Override
    public ComprasAutorizadas listaId(Integer codigo) {
        
        conexao = HibernateUtil.getSessionFactory();
        Session session = conexao.openSession();
        Transaction tx = session.beginTransaction();
        try {
            this.consulta=session.createQuery("from ComprasAutorizadas where codigo="+ codigo).getResultList();
            comp_auto=consulta.get(0);
            tx.commit();
        } catch (Exception erroAlteraComprasAutorizadas) {
             System.out.println("erro ao deletar a compra");
            erroAlteraComprasAutorizadas.printStackTrace();
        } finally {
            session.close();
        }
        return comp_auto;
    }

}
