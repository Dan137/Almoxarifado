/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HibernateUtil;

import com.almoxarifado.model.Material;
import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Daniel
 */
public class HibernateUtil {
    static SessionFactory sessionFactory = null;
   
    static {
        try{
        Configuration config = new Configuration();
        config.configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(config.getProperties());
        MetadataSources metadataSources = new MetadataSources();
        metadataSources.addAnnotatedClass(Material.class);
        Metadata metadata = metadataSources.buildMetadata(builder.build());
        sessionFactory = metadata.buildSessionFactory();
        }catch(Throwable ex){
            System.out.println("aconteceu um erro!!\n");
            throw  new ExceptionInInitializerError(ex);
        }
        
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    
    
}
