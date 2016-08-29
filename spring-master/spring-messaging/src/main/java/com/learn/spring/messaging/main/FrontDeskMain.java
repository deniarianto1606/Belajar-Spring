/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.messaging.main;

import com.learn.spring.messaging.entity.Mail;
import com.learn.spring.messaging.service.FrontDesk;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author DeNiSa
 */
public class FrontDeskMain {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-front.xml");
        
        FrontDesk frontDesk = (FrontDesk) context.getBean("frontDesk");
        frontDesk.sendMail(new Mail("1234", "US", 1.5));
    }
}
