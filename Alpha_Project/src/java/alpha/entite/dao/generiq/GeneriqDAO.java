/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.dao.generiq;

import alpha.entite.dao.generiq.IGeneriqDAO;
import alpha.entite.dao.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author INTI0225
 * @param <T>
 */
public abstract class GeneriqDAO<T> implements IGeneriqDAO<T> {
    
    Session session;
    Transaction transaction;
    private final Class<T> typeArgumentClass;
    
    public GeneriqDAO(Class<T> typeArgumentClass) {
        this(HibernateUtil.currentSession(),typeArgumentClass);
    }
    
    public GeneriqDAO(Session session, Class<T> typeArgumentClass) {
        this.typeArgumentClass = typeArgumentClass;
        this.session = session;
    }

    @Override
    public void create(T entity) {
        session = getSession();
        try {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (HibernateException hex) {
            throw new HibernateException(hex.getCause());
        } finally {
            session.close();
        }
    }

    @Override
    public void update(T entity) {
        session = getSession();
        try {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (HibernateException hex) {
            throw new HibernateException(hex.getCause());
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(T entity) {
        session = getSession();
        try {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (HibernateException hex) {
            throw new HibernateException(hex.getCause());
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(int entityId) {
        delete(getById(entityId));
    }

    @Override
    public List<T> getAll() {
        List<T> list;
        session = getSession();
        try {
            list = session.createQuery("FROM "+getTTypeName()).list();
            return list;
        } catch (HibernateException hex) {
            throw new HibernateException(hex.getCause());
        } finally {
            session.close();
        }
    }

    @Override
    public List<T> execNamedQuery(String namedQuery) {
        List<T> list;
        session = getSession();
        try {
            transaction = session.beginTransaction();
            list = session.getNamedQuery(namedQuery).list();
            transaction.commit();
            return list;
        } catch (HibernateException hex) {
            transaction.rollback();
            throw new HibernateException(hex.getCause());
        } finally {
            session.close();
        }
    }

    @Override
    public T getById(int id) {
        session = getSession();
        String req = String.format("FROM %s WHERE %s = :id",getTTypeName(),"id"+getTTypeName());
        return (T) session.createQuery(req).setInteger("id", id).uniqueResult();
    }

    @Override
    public List<T> execFreeHQLQuery(String freeQuery) {
        List<T> list;
        session = getSession();
        try {
            transaction = session.beginTransaction();
            list = session.createQuery(freeQuery).list();
            transaction.commit();
            return list;
        } catch (HibernateException hex) {
            transaction.rollback();
            throw new HibernateException(hex.getCause());
        } finally {
            session.close();
        }
    }
    
    private String getTTypeName() {
        return typeArgumentClass.getSimpleName();
    }
    
    protected Session getSession() {
        if (!session.isOpen()) {
            System.err.println("isOpen");
            session = session.getSessionFactory().openSession();
        }
        session = session.getSessionFactory().openSession();
        return session;
    }
   
}
