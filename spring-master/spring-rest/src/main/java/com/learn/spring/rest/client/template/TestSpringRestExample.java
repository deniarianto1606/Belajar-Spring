/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.rest.client.template;

import com.learn.spring.rest.controller.EmpRestURIConstant;
import com.learn.spring.rest.model.Employee;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author DeNiSa
 */
public class TestSpringRestExample {

    public static final String SERVER_URI = "http://localhost:8080/spring-rest/";

    public static void main(String args[]) {
        testGetDummyEmployee();
        System.out.println("*****");
        testCreateEmployee();
        System.out.println("*****");
        testGetEmployee();
        System.out.println("*****");
        testGetAllEmployee();
    }

    private static void testGetAllEmployee() {
        RestTemplate restTemplate = new RestTemplate();
        //we can't get List<Employee> because JSON convertor doesn't know the type of
        //object in the list and hence convert it to default JSON object type LinkedHashMap
        List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI + EmpRestURIConstant.GET_ALL_EMP, List.class);
        System.out.println(emps.size());
        for (LinkedHashMap map : emps) {
            System.out.println("ID=" + map.get("id") + ",Name=" + map.get("name") + ",CreatedDate=" + map.get("createdDate"));;
        }
    }

    private static void testCreateEmployee() {
        RestTemplate restTemplate = new RestTemplate();
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("Pankaj Kumar");
        Employee response = restTemplate.postForObject(SERVER_URI + EmpRestURIConstant.CREATE_EMP, emp, Employee.class);
        printEmpData(response);
    }

    private static void testGetEmployee() {
        RestTemplate restTemplate = new RestTemplate();
        Employee emp = restTemplate.getForObject(SERVER_URI + "/rest/emp/1", Employee.class);
        printEmpData(emp);
    }

    private static void testGetDummyEmployee() {
        RestTemplate restTemplate = new RestTemplate();
        Employee emp = restTemplate.getForObject(SERVER_URI + EmpRestURIConstant.DUMMY_EMP, Employee.class);
        printEmpData(emp);
    }

    public static void printEmpData(Employee emp) {
        System.out.println("ID=" + emp.getId() + ",Name=" + emp.getName() + ",CreatedDate=" + emp.getCreatedDate());
    }
}
