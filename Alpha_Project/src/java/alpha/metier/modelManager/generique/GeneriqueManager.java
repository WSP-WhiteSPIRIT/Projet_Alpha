/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.metier.modelManager.generique;

import alpha.entite.dao.generiq.IGeneriqDAO;
import java.util.List;

/**
 *
 * @author BOTREL Jordan
 */
public abstract class GeneriqueManager<T> implements IGeneriqueManager<T> {

    protected IGeneriqDAO<T> dao;
    
    @Override
    public void create(T entity) {
        dao.create(entity);
    }

    @Override
    public void update(T entity) {
        dao.update(entity);
    }

    @Override
    public void delete(T entity) {
        dao.delete(entity);
    }

    @Override
    public void delete(int entityId) {
        dao.delete(entityId);
    }

    @Override
    public List<T> getAll() {
        return dao.getAll();
    }

    @Override
    public T getById(int id) {
        return dao.getById(id);
    }

    @Override
    public List<T> execNamedQuery(String namedQuery) {
        return dao.execNamedQuery(namedQuery);
    }

    @Override
    public List<T> execFreeHQLQuery(String freeQuery) {
        return dao.execFreeHQLQuery(freeQuery);
    }

}
