/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author INTI0225
 * @param <T>
 */
public abstract class DAOTypeT<T> implements IDAOGenerique<T> {
    
    Session session;
    Transaction transaction;
    private final Class<T> typeArgumentClass;
    
    public DAOTypeT(Session session, Class<T> typeArgumentClass) {
        this.typeArgumentClass = typeArgumentClass;
        this.session = session;
    }
    
    public DAOTypeT(Class<T> typeArgumentClass) {
        this(HibernateUtil.currentSession(),typeArgumentClass);
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
        String req = String.format(
                "FROM %s WHERE id = :id",
                getTTypeName());
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
            session = session.getSessionFactory().openSession();
        }
        return session;
    }
   
}
