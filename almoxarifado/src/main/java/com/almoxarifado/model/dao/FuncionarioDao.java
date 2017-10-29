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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        }    }

    @Override
    public void alterar(Funcionario funcionario) {
         try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(funcionario);
            tx.commit();
        } catch (Exception erroCadFuncionario) {
            System.out.println("erro ao atualizar o funcionario");
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Funcionario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> listarTudo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario listaId(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}

/*
@Override
    public void cadastrar(Funcionario funcionario) {
        

    }

    @Override
    public void alterar(Funcionario funcionario) {
       
    }

    @Override
    public void deletar(Funcionario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> listarTudo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario listaId(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
