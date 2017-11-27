/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model.dao;

import HibernateUtil.HibernateUtil;
import com.almoxarifado.model.Emprestimo;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Daniel
 */
public class EmprestimoDao implements DaoGenerico<Emprestimo> {

    private static EmprestimoDao instance = null;
    private SessionFactory sessionFactory;
    private Session session;

    public EmprestimoDao() {
    }

    public static EmprestimoDao getInstance() {
        if (instance == null) {
            instance = new EmprestimoDao();
        }
        return instance;
    }

    @Override
    public void cadastrar(Emprestimo t) {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(t);
            tx.commit();
        } catch (Exception e) {
            System.out.println("erro inserir um emprestimo");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void alterar(Emprestimo emprestimo) {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(emprestimo);
            tx.commit();
        } catch (Exception e) {
            System.out.println("erro ao alterar um empréstimo");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Emprestimo emprestimo) {
        List<Emprestimo> consulta = null;

        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            consulta = session.createQuery("from Emprestimo where id = " + emprestimo.getId()).getResultList();
            Emprestimo emp = consulta.get(0);
            session.remove(emp);
            tx.commit();
        } catch (Exception e) {
            System.out.println("erro ao deletar um empréstimo");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Emprestimo> listarTudo() {
         List<Emprestimo> consulta = null;

        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            consulta = session.createQuery("from Emprestimo").getResultList();
            tx.commit();
        } catch (Exception e) {
            System.out.println("erro ao deletar um empréstimo");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return consulta;
    }

    @Override
    public Emprestimo listaId(Integer codigo) {
         List<Emprestimo> consulta = null;
         Emprestimo emp=null;
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            consulta = session.createQuery("from Emprestimo where id = " + codigo).getResultList();
            emp = consulta.get(0);
            tx.commit();
        } catch (Exception e) {
            System.out.println("erro ao consultar todos os emprestimos");
            e.printStackTrace();
        } finally {
            session.close();
        }
    return emp;
    }

}
