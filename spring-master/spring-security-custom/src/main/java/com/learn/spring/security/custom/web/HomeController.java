/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.security.custom.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author DeNiSa
 */
@Controller
public class HomeController {
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String index() {
        System.out.println("hohohoHOHOHOOH");
        return "admin/home";
    }
}
