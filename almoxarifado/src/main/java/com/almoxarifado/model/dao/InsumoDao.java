/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model.dao;

import com.almoxarifado.Util.HibernateUtil;
import com.almoxarifado.model.Entidades.Insumo;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;

/**
 *
 * @author Daniel
 */
public class InsumoDao implements DaoGenerico<Insumo> {

    private static InsumoDao instance;
    private SessionFactory sessionFactory;
    private Session session;

    public static InsumoDao getInstance() {
        if (instance == null) {
            instance = new InsumoDao();
        }
        return instance;
    }

    @Override
    public void cadastrar(Insumo insumo) {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(insumo);
            tx.commit();
        } catch (Exception erroCadMat) {
            erroCadMat.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void alterar(Insumo insumo) {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(insumo);
            tx.commit();
        } catch (Exception erroAlterMat) {
            erroAlterMat.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Insumo insumo) {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            List<Insumo> consulta = session.createQuery("FROM Insumo WHERE codigo="+insumo.getCodigo()).getResultList();
            insumo = (Insumo) consulta.get(0);
            session.remove(insumo);
            tx.commit();
        } catch (Exception erroRemover) {
            erroRemover.printStackTrace();
        } finally {
            session.close();
        }
    }
    @Override
        public List<Insumo> listarTudo() {

        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        @SuppressWarnings("unchecked")
            List<Insumo> result = session.createQuery("FROM Insumo").getResultList();
        tx.commit();
        session.close();
        return result;
    }

    @Override
        public Insumo listaId(Integer codigo){
            Insumo insumo = new Insumo();
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            List<Insumo> consulta = session.createQuery("FROM Insumo WHERE codigo="+codigo).getResultList();
            insumo = (Insumo) consulta.get(0);
            tx.commit();
        } catch (Exception erroRemover) {
            erroRemover.printStackTrace();
        } finally {
            session.close();
        }
        return insumo;
        } 

//    public static void main(String[] args) throws Exception {
//        /*
//         this.codigo = codigo;
//        this.nome = nome;
//        this.descricao=descricao;
//        this.quantidade=quantidade;
//        this.estado=estado;
//         */
////        SessionFactory sessionFactory = HibernateUtil.getSession();
//////        Session session = sessionFactory.openSession();
////        Transaction tx = session.beginTransaction();
////        Insumo material = new Insumo(0, "tesourão", "material", 2, "emprestada");
////        session.persist(material);
////        tx.commit();
////        session.close();
//
//    }

}
