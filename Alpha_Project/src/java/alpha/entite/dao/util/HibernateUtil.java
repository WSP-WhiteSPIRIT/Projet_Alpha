/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.dao.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author INTI0225
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static final ThreadLocal session = new ThreadLocal();
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // builds a session factory from the service registry
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public  static Session currentSession() throws HibernateException {
        Session s = (Session) session.get();
        if (null == s) {
            s = sessionFactory.openSession();
            session.set(s);
        }
        return s;
    }
    
    public static void closeSession() throws HibernateException {
        Session s = (Session) session.get();
        session.set(null);
        if (null != s) {
            s.close();
            
        }
    }
    
    public static SessionFactory getSessionFactory() {
        
        return sessionFactory;
    }
}
