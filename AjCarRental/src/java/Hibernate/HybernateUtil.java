/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate;


import java.io.File;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
/**
 *
 * @author Johan
 */
public class HybernateUtil {
    Configuration conf = new Configuration()
              .configure("Hibernate/hibernate.cfg.xml");


    ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();


    SessionFactory sf = conf.buildSessionFactory(sr);

    Session session = sf.openSession();

    public SessionFactory getSessionFactory(){
        
       return sf;
    
    }
    public Session getcurrentSession(){
        return session;
    }
    public void close(){
        sf.close();
        
        
    }
}
