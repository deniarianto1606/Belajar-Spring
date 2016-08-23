/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.rest.hibernate.dao.impl;

import com.learn.spring.rest.hibernate.dao.PeopleDao;
import com.learn.spring.rest.hibernate.entity.People;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DeNiSa
 */
@Repository("peopleDao")
public class PeopleDaoImpl extends BaseDaoImpl<People> implements PeopleDao {
    @Override
    public Class<People> getEntityClass() {
        return People.class;
    }
}
