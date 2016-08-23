/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.rest.hibernate.dao.impl;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author DeNiSa
 */
public abstract class BaseDaoImpl<T> implements Serializable {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    /**
     * For get the instance class on the fly.
     * 
     * @return instance class.
     */
    public abstract Class<T> getEntityClass();
    
    public T findById(Long id){
        return (T) getCurrentSession().get(getEntityClass(), id);
    }
    
    public void save(T entity){
        this.getCurrentSession().save(entity);
    }
        
    public void update(T entity){
        this.getCurrentSession().update(entity);
    }
    
    public void delete(T entity){
        this.getCurrentSession().delete(entity);
    }
    
    public List<T> getAll(){
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.isNotNull("id"));
        return (List<T>) criteria.list();
    }
    
}
