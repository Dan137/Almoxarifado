/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model.dao;

import HibernateUtil.HibernateUtil;
import com.almoxarifado.model.Funcionario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Daniel
 */
public class FuncionarioDao implements FuncionarioModel {

    private static FuncionarioDao instance;
    private SessionFactory sessionFactory;
    private Session session;
    private List<Funcionario> consulta;

    public FuncionarioDao() {

    }

    public static FuncionarioDao getInstance() {
        if (instance == null) {
            instance = new FuncionarioDao();
        }
        return instance;
    }

    @Override
    public Funcionario queryByMatricula(String matricula) {
        Funcionario funcionario = new Funcionario();
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            consulta = session.createQuery("from Funcionario where matricula=" + matricula).getResultList();
            funcionario = consulta.get(0);
            tx.commit();
        } catch (Exception erroConsultaMatricula) {
            System.out.println("não conseguimos buscar pelo matricula!!");
            erroConsultaMatricula.printStackTrace();
        }finally{
            session.close();
        }
        return funcionario;
    }

    @Override
    public void cadastrar(Funcionario funcionario) {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(funcionario);
            tx.commit();
        } catch (Exception erroCadFuncionario) {
            System.out.println("erro ao cadastrar o funcionario");
        } finally {
            session.close();
        }
    }

    @Override
    public void alterar(Funcionario funcionario) {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {

            session.update(funcionario);
            tx.commit();
        } catch (Exception erroCadFuncionario) {
            System.out.println("erro ao atualizar o funcionario");
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Funcionario funcionario) {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            consulta = session.createQuery("from Funcionario where codigo=" + funcionario.getCodigo()).getResultList();
            funcionario = consulta.get(0);
            session.remove(funcionario);
            tx.commit();
        } catch (Exception erroDelete) {
            System.out.println("erro ao deletar");
            erroDelete.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Funcionario> listarTudo() {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            consulta = session.createQuery("from Funcionario").getResultList();
            tx.commit();
        } catch (Exception erroApresentFuncio) {
            erroApresentFuncio.printStackTrace();
        } finally {
            session.close();
        }
        return consulta;
    }

    @Override
    public Funcionario listaId(Integer codigo) {
         Funcionario funcionario = new Funcionario();
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            consulta = session.createQuery("from Funcionario where codigo=" + codigo).getResultList();
            funcionario = consulta.get(0);
            tx.commit();
        } catch (Exception erroConsultaFuncionario) {
            System.out.println("falha na busca");
            erroConsultaFuncionario.printStackTrace();
        }finally{
            session.close();
        }
        return funcionario;
    }

}