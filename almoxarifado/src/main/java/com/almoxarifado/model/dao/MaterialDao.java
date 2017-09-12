/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almoxarifado.model.dao;

import com.almoxarifado.model.Material;
import hibernate.util.HibernateUtil;
import java.util.List;
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
    private Session session;
    private List<Material> materiais;
    private SessionFactory sf;

    public static MaterialDao getInstance() {
        if (instance == null) {
            instance = new MaterialDao();
        }
        return instance;
    }

    @Override
    public void cadastrar(Material material) {
        sf = HibernateUtil.getSessionFactory();
        session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(material);
        tx.commit();
        session.close();
        System.out.println("Material cadastrado com sucesso");
    }

    @Override
    public void alterar(Material material) {
        materiais = MaterialDao.getInstance().listarTudo();
        sf = HibernateUtil.getSessionFactory();
        session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        for (Material m : materiais) {
            if (m.getCodigo() == material.getCodigo()) {
                m.setNome(material.getNome());
            }
        }
        session.update(material);
        tx.commit();
        session.close();
        System.out.println("Material Alterado com sucesso");
    }

    @Override
    public void deletar(Material material) {
        List<Material> materiais = MaterialDao.getInstance().listarTudo();

        sf = HibernateUtil.getSessionFactory();
        session = sf.openSession();
        for (int i = 0; i < materiais.size(); i++) {
            if (material.getCodigo() == materiais.get(i).getCodigo()) {
                material.getCodigo();
                material.getNome();
                session.delete(material);
            }
        }
        Transaction tx = session.beginTransaction();

        tx.commit();
        session.close();
        System.out.println("Material deletado com sucesso");
    }

    @Override
    public List<Material> listarTudo() {

        sf = HibernateUtil.getSessionFactory();
        session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query consult = session.createQuery("from Material");
        materiais = consult.list();
        tx.commit();
        session.close();
        return materiais;
    }

    @Override
    public Material listaId(Integer codigo) {
        sf = HibernateUtil.getSessionFactory();
        session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query consult = session.createQuery("from Material where codigo=" + codigo);
        Material material = (Material) consult.list().get(0);
        tx.commit();
        session.close();
        return material;
    }

}
