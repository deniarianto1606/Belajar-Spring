/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.webflow.service.impl;

import com.learn.spring.webflow.service.LibraryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author DeNiSa
 */
public class LibraryServiceImpl implements LibraryService {

    @Override
    public List<Date> getHolidays() {
        List<Date> holidays = new ArrayList<Date>();
        holidays.add(new GregorianCalendar(2016, 11, 25).getTime());
        holidays.add(new GregorianCalendar(2016, 0, 1).getTime());
        return holidays;
    }
    
}
