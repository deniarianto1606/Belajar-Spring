/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.rest.hibernate.service;

import java.util.List;
import org.hibernate.criterion.Order;

/**
 *
 * @author DeNiSa
 */
public interface BaseService<T> {
    public T findById(Long id) throws Exception;
    
    public void save(T entity) throws Exception;
    
    public void update(T entity) throws Exception;
    
    public void delete(T entity) throws Exception;
    
    public List<T> getAllData() throws Exception;
    
}

