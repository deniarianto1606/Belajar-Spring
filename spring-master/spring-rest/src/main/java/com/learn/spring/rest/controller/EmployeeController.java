/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.rest.controller;

import com.learn.spring.rest.model.Employee;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author DeNiSa
 */
@Controller
public class EmployeeController {

    //Map to store employees, ideally we should use database
    Map<Integer, Employee> empData = new HashMap<Integer, Employee>();

    @RequestMapping(value = EmpRestURIConstant.DUMMY_EMP, method = RequestMethod.GET)
    public @ResponseBody
    Employee getDummyEmployee() {
        System.out.println("start dummy");
        Employee emp = new Employee();
        emp.setId(9999);
        emp.setName("Dummy");
        emp.setCreatedDate(new Date());
        empData.put(9999, emp);
        return emp;
    }

    @RequestMapping(value = EmpRestURIConstant.GET_EMP, method = RequestMethod.GET)
    public @ResponseBody
    Employee getEmployee(@PathVariable("id") int empId) {
        System.out.println("start getEmployee. ID=" + empId);

        return empData.get(empId);
    }

    @RequestMapping(value = EmpRestURIConstant.GET_ALL_EMP, method = RequestMethod.GET)
    public @ResponseBody
    List<Employee> getAllEmployees() {
        System.out.println("Start getAllEmployees.");
        List<Employee> emps = new ArrayList<Employee>();
        Set<Integer> empIdKeys = empData.keySet();
        for (Integer i : empIdKeys) {
            emps.add(empData.get(i));
        }
        return emps;
    }

    @RequestMapping(value = EmpRestURIConstant.CREATE_EMP, method = RequestMethod.POST)
    public @ResponseBody
    Employee createEmployee(@RequestBody Employee emp) {
        
        System.out.println("Start Create Employee");
        emp.setCreatedDate(new Date());
        empData.put(emp.getId(), emp);
        return emp;
    }

    @RequestMapping(value = EmpRestURIConstant.DELETE_EMP, method = RequestMethod.PUT)
    public @ResponseBody
    Employee deleteEmployee(@PathVariable("id") int empId) {
        System.out.println("Start Delete Employee");
        Employee emp = empData.get(empId);
        empData.remove(empId);
        return emp;
    }
}
