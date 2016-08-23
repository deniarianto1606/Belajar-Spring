/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.rest.hibernate.dao;

import java.util.List;
import org.hibernate.criterion.Order;

/**
 *
 * @author DeNiSa
 */
public interface BaseDao <T> {
    public T findById(Long id);
    
    public void save(T entity);
    
    public void update(T entity);
    
    public void delete(T entity);
    
    public List<T> getAll();
    
}
