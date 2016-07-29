package com.learn.spring.dependency.injection.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DeNiSa
 */
public class Main {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //membuat object generator dengan menginject instance dari ApplicationContext
        SequenceGenerator generator = (SequenceGenerator) context.getBean("sequenceGenerator");
        
        System.out.println(generator.getSequence());
        System.out.println(generator.getSequence());
    }
}
