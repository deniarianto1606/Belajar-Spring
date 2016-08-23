/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.rest.hibernate.controller;

import com.google.gson.Gson;
import com.learn.spring.rest.hibernate.contant.rest.PeopleURIConstants;
import com.learn.spring.rest.hibernate.entity.People;
import com.learn.spring.rest.hibernate.service.PeopleService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DeNiSa
 */
@RestController
public class PeopleRestController {

    @Autowired
    private PeopleService peopleService;
    
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @RequestMapping(value = PeopleURIConstants.GET_ALL_PEOPLE, method = RequestMethod.GET)
    public @ResponseBody String getAllPeople() throws IOException, Exception {
        System.out.println("Start getAllEmployees.");
        List<People> people = peopleService.getAllData();
        String jsonData = convertToJsonData(people);
        return jsonData;
    }

    private String convertToJsonData(List<People> listPeople) throws IOException {        
        Gson gson = new Gson();
        return gson.toJson(listPeople);
    }

}
