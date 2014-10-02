/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.dao.generiq;

import java.util.List;

/**
 *
 * @author INTI0225
 */
public interface IGeneriqDAO<T> {
    void create(T entity);
    void update(T entity);
    void delete(T entity);
    void delete(int entityId);
    List<T> getAll();
    T getById(int id);
    List<T> execNamedQuery(String namedQuery);
    List<T> execFreeHQLQuery(String freeQuery);

}
