/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model.dao;

import HibernateUtil.HibernateUtil;
import com.almoxarifado.model.Material;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;

/**
 *
 * @author Daniel
 */
public class MaterialDao implements DaoGenerico<Material> {

    private static MaterialDao instance;
    private SessionFactory sessionFactory;
    private Session session;

    public static MaterialDao getInstance() {
        if (instance == null) {
            instance = new MaterialDao();
        }
        return instance;
    }

    @Override
    public void cadastrar(Material material) {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(material);
            tx.commit();
        } catch (Exception erroCadMat) {
            erroCadMat.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void alterar(Material material) {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(material);
            tx.commit();
        } catch (Exception erroAlterMat) {
            erroAlterMat.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Material material) {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            List<Material> consulta = session.createQuery("FROM Material WHERE codigo="+material.getCodigo()).getResultList();
            material = (Material) consulta.get(0);
            session.remove(material);
            tx.commit();
        } catch (Exception erroRemover) {
            erroRemover.printStackTrace();
        } finally {
            session.close();
        }
    }
    @Override
        public List<Material> listarTudo() {

        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        @SuppressWarnings("unchecked")
            List<Material> result = session.createQuery("FROM Material").getResultList();
        tx.commit();
        session.close();
        return result;
    }

    @Override
        public Material listaId(Integer codigo){
            Material material = new Material();
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            List<Material> consulta = session.createQuery("FROM Material WHERE codigo="+codigo).getResultList();
            material = (Material) consulta.get(0);
            tx.commit();
        } catch (Exception erroRemover) {
            erroRemover.printStackTrace();
        } finally {
            session.close();
        }
        return material;
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
////        Material material = new Material(0, "tesourão", "material", 2, "emprestada");
////        session.persist(material);
////        tx.commit();
////        session.close();
//
//    }

}
